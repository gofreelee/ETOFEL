package loginmodule;

import loginmodule.service.LoginService;
import loginmodule.service.UserManageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginApplicationTests {

	@Autowired
	LoginService loginService;
	UserManageService userManageService;

	@Test
	void contextLoads() {
	}

	@Test
	void testUserCrud(){
		String username = "clearlove";
		String password = "123456";
		String email = "111@qq.com";
		System.out.println("addUser:"+loginService.addUserByNPE(username,password,email));
		System.out.println("selectuser:"+loginService.selectUserByUNAndPW(username,password));
		System.out.print("NoExistInUser:"+loginService.NoExistInUser(username));
		System.out.println("NoExistInTeacher:"+loginService.NoExistInTeacher(username));
	}

	@Test
	void testTeacherCrud(){
		String username = "English";
		String password = "123456";
		System.out.println("selectteacher:"+loginService.selectTeacherByUNAndPW(username,password));
	}

	@Test
	void testAdministerCrud(){
		String username = "admin";
		String password = "adminpassword";
		System.out.println("selectadminister:"+loginService.selectAdministerByUNAndPW(username,password));
	}

	@Test
	void testUserListCrud(){
		String username = "admin";
		String state = "正常";
		System.out.println("selectUserListWithStateAndUsername:"+userManageService.selectUserByUNAndState(username,state));
		System.out.print("selectUserListWithState:"+userManageService.selectUserByUNAndState(null,state));
		System.out.println("setStateToNormal:"+userManageService.updateStaToNormal(username));
		System.out.println("setStateToFrozen:"+userManageService.updateStaToFrozen(username));
	}
}
