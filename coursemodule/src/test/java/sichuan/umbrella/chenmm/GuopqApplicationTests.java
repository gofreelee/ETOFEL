package sichuan.umbrella.chenmm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import sichuan.umbrella.chenmm.bean.CourseComment;
import sichuan.umbrella.chenmm.bean.CourseDetail;
import sichuan.umbrella.chenmm.bean.UserJoinCourse;
import sichuan.umbrella.chenmm.controller.CourseCommentController;
import sichuan.umbrella.chenmm.controller.CourseController;
import sichuan.umbrella.chenmm.controller.CourseDetailController;
import sichuan.umbrella.chenmm.controller.UserJoinCourseController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GuopqApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Autowired
    private CourseDetailController courseDetailController;
    @Autowired
    private CourseCommentController courseCommentController;
    @Autowired
    private UserJoinCourseController userJoinCourseController;
    @Before
    public void setUp() throws Exception {
        //MockMvcBuilders.webAppContextSetup(WebApplicationContext context)：指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc；
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
    }

    //测试访问课程具体界面
    @Test
    public void courseDetailInfo() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/courseDetail/getCourseDetail?cdtCosId=1") //请求的url,请求的方法是get
                .contentType(MediaType.APPLICATION_JSON_UTF8) //数据的格式
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk())  //返回的状态是200
                .andDo(MockMvcResultHandlers.print()) //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符

        System.out.println(responseString);
    }
    //测试查找课程资料
    @Test
    public void selectCourseData() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/courseData/getCourseData?cdaId=1&cdaCosId=1") //请求的url,请求的方法是get
                .contentType(MediaType.APPLICATION_JSON_UTF8) //数据的格式
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk())  //返回的状态是200
                .andDo(MockMvcResultHandlers.print()) //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符

        System.out.println(responseString);
    }
    //测试查找课程详细教师点赞
    @Test
    public void selectCourseDetailLikeNum() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/courseDetail/getCourseDetailLikeNum?cdtCosId=2") //请求的url,请求的方法是get
                .contentType(MediaType.APPLICATION_JSON_UTF8) //数据的格式
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk())  //返回的状态是200
                .andDo(MockMvcResultHandlers.print()) //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符

        System.out.println(responseString);
    }
    //测试查找课程详细教师点赞
    @Test
    public void selectCourseDetailTchInfo() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/courseDetail/getCourseDetailTeacherInfo?cdtCosId=2") //请求的url,请求的方法是get
                .contentType(MediaType.APPLICATION_JSON_UTF8) //数据的格式
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk())  //返回的状态是200
                .andDo(MockMvcResultHandlers.print()) //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符

        System.out.println(responseString);
    }
    //课程详细页添加评论
    @Test
    public void insertCourseComment() throws Exception {

        Date date = new Date();//需要new一个Date对象
        String string ="1999-05-22";//输入想要添加的生日
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //设置日期格式  yyyy-MM-dd-HH-mm-ss这个是完整的
        date = dateFormat.parse(string);//将字符串转换成date类型数据
        CourseComment courseComment = new CourseComment("郭沛祺", 1, date, "这个课程还不错，推荐给大家");
        System.out.println(courseComment+"-----------------");
        String result = courseCommentController.insertCourseComment(courseComment);
        System.out.println(result);
    }
    //测试课程详细的页面的全部评论查找
    @Test
    public void selectAllCourseDetailComment() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/courseComment/getAllCourseComment?ccmtCosDetailId=1") //请求的url,请求的方法是get
                .contentType(MediaType.APPLICATION_JSON_UTF8) //数据的格式
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk())  //返回的状态是200
                .andDo(MockMvcResultHandlers.print()) //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符

        System.out.println(responseString);
        System.out.println("success");
    }
    //测试管理员功能——课程状态的关闭
    @Test
    public void closeCourseById() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/course/closeCourse?cosId=1") //请求的url,请求的方法是get
                .contentType(MediaType.APPLICATION_JSON_UTF8) //数据的格式
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk())  //返回的状态是200
                .andDo(MockMvcResultHandlers.print()) //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符
        System.out.println(responseString);
    }
    //测试管理员功能——课程状态的恢复
    @Test
    public void recoverCourseById() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/course/recoverCourse?cosId=1") //请求的url,请求的方法是get
                .contentType(MediaType.APPLICATION_JSON_UTF8) //数据的格式
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk())  //返回的状态是200
                .andDo(MockMvcResultHandlers.print()) //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符

        System.out.println(responseString);
        System.out.println("success");
    }


//    @Test
//    public void test01(){
//        CourseDetail courseDetail = courseDetailController.selectCourseDetailInfo(1);
//        System.out.println(courseDetail);
//
//    }





}
