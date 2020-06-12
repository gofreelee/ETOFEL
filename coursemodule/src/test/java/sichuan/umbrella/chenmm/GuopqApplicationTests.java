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
import sichuan.umbrella.chenmm.bean.CourseDetail;
import sichuan.umbrella.chenmm.controller.CourseController;
import sichuan.umbrella.chenmm.controller.CourseDetailController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GuopqApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Autowired
    private CourseDetailController courseDetailController;
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
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/courseDetail//getCourseDetailLikeNum?cdtCosId=2") //请求的url,请求的方法是get
                .contentType(MediaType.APPLICATION_JSON_UTF8) //数据的格式
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk())  //返回的状态是200
                .andDo(MockMvcResultHandlers.print()) //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符

        System.out.println(responseString);
    }
//    @Test
//    public void test01(){
//        CourseDetail courseDetail = courseDetailController.selectCourseDetailInfo(1);
//        System.out.println(courseDetail);
//
//    }





}
