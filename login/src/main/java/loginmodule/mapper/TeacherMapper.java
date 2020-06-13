package loginmodule.mapper;

import loginmodule.bean.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {

    String selectTeacherUsername(String usr_username);

    Teacher selectByUNAndPW(String tch_username,String tch_password);
}
