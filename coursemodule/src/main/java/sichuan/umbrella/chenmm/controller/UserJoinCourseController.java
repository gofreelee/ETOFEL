package sichuan.umbrella.chenmm.controller;

import com.google.gson.Gson;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sichuan.umbrella.chenmm.bean.UserJoinCourse;
import sichuan.umbrella.chenmm.service.UserJoinCourseService;

@RestController
@RequestMapping("/userJoinCourse")
public class UserJoinCourseController {

    private UserJoinCourseService userJoinCourseService;
    private Gson gson;
    private final Logger logger = LoggerFactory.getLogger(UserJoinCourseController.class);

    @Autowired
    public void setUserJoinCourseService(UserJoinCourseService userJoinCourseService) {
        this.userJoinCourseService = userJoinCourseService;
    }

    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }

    @GetMapping("/getJoinedCourse")
    public String getJoinedCourse(@RequestParam("ujcUsrUsername") String ujcUsrUsername) {
        return gson.toJson(userJoinCourseService.getJoinedCourse(ujcUsrUsername));
    }

    @GetMapping("getJoinedStatus")
    public String getJoinedStatus(@RequestParam("ujcCosId") Integer ujcCosId,
                                  @RequestParam("ujcUsrUsername") String ujcUsrUsername) {
        UserJoinCourse userJoinCourse = userJoinCourseService.getJoinedStatus(ujcCosId, ujcUsrUsername);
        logger.info("查询我的课程状态：" + gson.toJson(userJoinCourse));
        return gson.toJson(userJoinCourse);
    }

    /**
     * 计算课程的参加人数
     *
     * @param ujcCosId 用户加入的课程id
     * @return 该课程的参与人数
     */
    @GetMapping("/countCourseJoin")
    public String countCourseJoin(@RequestParam("ujcCosId") Integer ujcCosId) {
        int countJoin = userJoinCourseService.countCourseJoin(ujcCosId);
        return gson.toJson(countJoin);
    }

    /**
     * 用户提交课程订单信息，插入一条未支付数据
     *
     * @param ujcCosId       课程id
     * @param ujcUsrUsername 用户名
     * @return 是否插入成功
     */
    @GetMapping("/insertUserUnpaidOrder")
    public String insertUserUnpaidOrder(@RequestParam("ujcCosId") Integer ujcCosId, @RequestParam("ujcUsrUsername") String ujcUsrUsername) {
        boolean insertSuccess = userJoinCourseService.insertUserUnpaidOrder(ujcCosId, ujcUsrUsername);
        if (insertSuccess) return "success";
        else return "failed";
    }

    /**
     * 当用户成功支付，更新用户支付状态为“已支付”
     *
     * @param ujcCosId       课程id
     * @param ujcUsrUsername 用户名
     * @return json支付是否成功
     */
    @GetMapping("/updateUserStatusToPaid")
    public String updateUserStatusToPaid(@RequestParam("ujcCosId") Integer ujcCosId, @RequestParam("ujcUsrUsername") String ujcUsrUsername) {
        //调用一个pay支付函数，pay操作成功再更新(pay函数未写)
        // if (pay成功){
        userJoinCourseService.updateUserStatusToPaid(ujcCosId, ujcUsrUsername);
        return "paySuccess";
        /*}else{
             return "payFalse"
        }*/
    }

    @Transactional
    @PostMapping("/joinCourse")
    public void joinCourse(@RequestParam("ujcCosId") Integer ujcCosId, @RequestParam("ujcUsrUsername") String ujcUsrUsername) {
        logger.info(ujcUsrUsername + "加入课程" + ujcCosId);
        UserJoinCourse userJoinCourse = userJoinCourseService.getJoinedStatus(ujcCosId, ujcUsrUsername);
        if (userJoinCourse == null) {
            userJoinCourseService.insertUserUnpaidOrder(ujcCosId, ujcUsrUsername);
        }
        userJoinCourseService.updateUserStatusToPaid(ujcCosId, ujcUsrUsername);
    }
}
