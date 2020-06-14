package loginmodule.mapper;

import loginmodule.bean.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {

    Teacher selectTeacherUsername(String usr_username);

    Teacher selectByUNAndPW(@Param("tch_username") String tch_username, @Param("tch_password") String tch_password);
}
