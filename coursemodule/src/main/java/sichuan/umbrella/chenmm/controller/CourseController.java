
package sichuan.umbrella.chenmm.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sichuan.umbrella.chenmm.bean.Course;
import sichuan.umbrella.chenmm.bean.CourseDetail;
import sichuan.umbrella.chenmm.bean.CourseWithTeacher;
import sichuan.umbrella.chenmm.bean.Group;
import sichuan.umbrella.chenmm.remote.GroupRemote;
import sichuan.umbrella.chenmm.service.CourseDetailService;
import sichuan.umbrella.chenmm.service.CourseService;
import sichuan.umbrella.chenmm.service.UserJoinCourseService;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService courseService;
    private CourseDetailService courseDetailService;
    private UserJoinCourseService userJoinCourseService;
    private GroupRemote groupRemote;
    private Gson gson;

    @Autowired
    public void setUserJoinCourseService(UserJoinCourseService userJoinCourseService) {
        this.userJoinCourseService = userJoinCourseService;
    }

    @Autowired
    public void setGroupRemote(GroupRemote groupRemote) {
        this.groupRemote = groupRemote;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setCourseDetailService(CourseDetailService courseDetailService) {
        this.courseDetailService = courseDetailService;
    }

    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }

    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @GetMapping("/getCourseByCosId")
    public String courseById(@RequestParam("cosId") Integer cosId) {
        return gson.toJson(courseService.selectCourseById(cosId));
    }

    @GetMapping("/courseRecommend")
    public String courseRecommend(@RequestParam("need") int need) {
        JsonArray array = new JsonArray();
        List<Integer> ids = courseService.randomCourseId(need);
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        for (Integer id : ids) {
            Course course = courseService.selectCourseById(id);
            CourseDetail courseDetail = courseDetailService.selectCourseDetailInfo(id);
            JsonObject object = new JsonObject();
            object.addProperty("cosId", course.getCosId());
            object.addProperty("cosTitle", course.getCosTitle());
            object.addProperty("cdtTchUsername", courseDetail.getCdtTchUsername());
            object.addProperty("cosStartDate", format.format(course.getCosStartDate()));
            array.add(object);
        }
        return array.toString();
    }

    /**
     * 选择公益、热门、名师->听力、写作
     *
     * @param type        课程大分类：公益0、热门1、名师2
     * @param cosCategory 课程分类：听力、写作……
     * @return json课程列表
     */
    @GetMapping("/welfareCastle")
    public String courseList(Integer type, String cosCategory) {
        if (cosCategory == null || cosCategory.equals("全部")) cosCategory = null;
        List<Course> list;
        if (type == 0) {
            list = courseService.selectActivityIsPublic(cosCategory);
        } else if (type == 1) {
            list = courseService.selectActivityIsHot(cosCategory);
        } else if (type == 2) {
            list = courseService.selectActivityIsFamousTeacher(cosCategory);
        } else {
            list = courseService.selectCourseByCategory(cosCategory);
        }
        return gson.toJson(list);
    }

    /**
     * 发布新的课程
     *
     * @param cosTitle       标题
     * @param cosStartDate   开始日期
     * @param cosEndDate     结束日期
     * @param cosStartTime   开始时间
     * @param cosEndTime     结束时间
     * @param cosFee         费用
     * @param cosCategory    类型
     * @param cdtTchUsername 老师名字
     * @param cdtPortrait    宣传图
     * @param cdtPlan        计划
     * @param cdtPattern     方式
     * @param cdtGuide       指南
     * @return 字符串
     */
    @PostMapping("/releaseCourse")
    @Transactional
    public String insertCourseBasicInfo(@RequestParam("cosTitle") String cosTitle,
                                        @RequestParam("cosStartDate") Date cosStartDate,
                                        @RequestParam("cosEndDate") Date cosEndDate,
                                        @RequestParam("cosStartTime") Time cosStartTime,
                                        @RequestParam("cosEndTime") Time cosEndTime,
                                        @RequestParam("cosFee") Double cosFee,
                                        @RequestParam("cosCategory") String cosCategory,
                                        @RequestParam("cdtTchUsername") String cdtTchUsername,
                                        @RequestParam("cdtPortrait") String cdtPortrait,
                                        @RequestParam("cdtPlan") String cdtPlan,
                                        @RequestParam("cdtPattern") String cdtPattern,
                                        @RequestParam("cdtGuide") String cdtGuide) {
        HashSet<Integer> hashSet = new HashSet<>(courseService.selectAllCourseId());

        int id;
        Random random = new Random();
        do {
            id = random.nextInt(Integer.MAX_VALUE);
        } while (hashSet.contains(id));

        Course course = new Course();
        course.setCosId(id);
        course.setCosTitle(cosTitle);
        course.setCosStartDate(cosStartDate);
        course.setCosEndDate(cosEndDate);
        course.setCosStartTime(cosStartTime);
        course.setCosEndTime(cosEndTime);
        course.setCosFee(cosFee);
        course.setCosCategory(cosCategory);
        course.setCosStage("每天");
        course.setCosStatus("报名中");

        Group group = new Group();
        group.setGrpType("名师课堂群");
        group.setGrpName(cosTitle + "课堂群");
        group.setGrpPortrait(cdtPortrait);
        group.setGrpCreator(cdtTchUsername);
        String grpId = groupRemote.createGroup(group);

        CourseDetail courseDetail = new CourseDetail();
        courseDetail.setCdtCosId(id);
        courseDetail.setCdtGrpId(Long.valueOf(grpId));
        courseDetail.setCdtTchUsername(cdtTchUsername);
        courseDetail.setCdtPortrait(cdtPortrait);
        courseDetail.setCdtPlan(cdtPlan);
        courseDetail.setCdtPattern(cdtPattern);
        courseDetail.setCdtGuide(cdtGuide);

        logger.info("新增课程：" + course);
        logger.info("课程详细信息：" + courseDetail);

        boolean insertSuccess = courseDetailService.insertCourseDetailInfo(courseDetail);
        boolean releaseSuccess = courseService.insertCourseBasicInfo(course);
        userJoinCourseService.insertUserUnpaidOrder(id, cdtTchUsername);
        userJoinCourseService.updateUserStatusToPaid(id, cdtTchUsername);

        if (releaseSuccess && insertSuccess) return "1";
        else return "0";
    }

    /**
     * 按照时间从早到晚给课程排序
     *
     * @param cosStartDate 开始日期2020-06-13
     * @param cosStartTime 开始时间10:30
     * @return 排序后的课程json
     */
    @GetMapping("/sortByTime")
    public String selectCourseByTime(@RequestParam("cosStartDate") String cosStartDate, @RequestParam("cosStartTime") String cosStartTime) {
        List<Course> list = courseService.selectCourseByTime(cosStartDate, cosStartTime);
        return gson.toJson(list);
    }

    /**
     * 管理员课程列表页动态查询课程
     *
     * @param cosTitle       课程名称
     * @param cosCategory    课程种类：写作、听力……
     * @param cdtTchUsername 该课教室名字
     * @return json
     */
    @GetMapping("/selectCourseDynamic")
    public String selectCourseDynamic(String cosTitle, String cosCategory, String cdtTchUsername) {
        if (cosTitle.equals("")) cosTitle = null;
        if (cosCategory.equals("")) cosCategory = null;
        if (cdtTchUsername.equals("")) cdtTchUsername = null;
        List<Course> list = courseService.selectCourseDynamic(cosTitle, cosCategory, cdtTchUsername);
        return gson.toJson(list);
    }

    /**
     * 管理员功能——按照课程id恢复课程，根据当前日期和目标课程的开课日记做比较，调整课程状态为报名或者开课
     *
     * @param cosIdsMap：课程id
     * @throws ParseException 日期parse异常
     */
    @RequestMapping(value = "/recoverCourse", method = RequestMethod.POST)
    public void recoverCourseById(@RequestBody Map<String, List<Integer>> cosIdsMap) throws ParseException {
        //获取想恢复的课程的开课日期
        List<Integer> cosIds = cosIdsMap.get("cosIds");
        for (Integer cosId : cosIds) {
            Course course = courseService.selectCourseById(cosId);
            Date courseOpenDate = course.getCosStartDate();
            //获取当前的日期
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date nowDate = new Date(System.currentTimeMillis());
            String nowDateString = formatter.format(nowDate);
            nowDate = formatter.parse(nowDateString);
            String result;
            if (nowDate.compareTo(courseOpenDate) < 0) {
                courseService.signUpCourseById(cosId);
                // result = "课程状态改变成开课";
                //return gson.toJson(result);
            } else {
                courseService.openCourseById(cosId);
                // result = "课程状态改变成报名";
                //return gson.toJson(result);
            }
        }
    }

    @RequestMapping("/getAllCourseInfo")
    public List<CourseWithTeacher> getAllCourseInfo() {
        return courseService.selectAllCourseInfo();
    }

    @RequestMapping(value = "/closeCourse", method = RequestMethod.POST)
    public void closeCourseById(@RequestBody Map<String, List<Integer>> cosIdMap) {
        List<Integer> cosIds = cosIdMap.get("cosIds");
        for (Integer cosId : cosIds) {
            System.out.println(cosId);
            // courseService.closeCourseById(cosId);
        }
        //
    }


}
