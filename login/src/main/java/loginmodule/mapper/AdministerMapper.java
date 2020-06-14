package loginmodule.mapper;

import loginmodule.bean.Administer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministerMapper {

    Administer selectAdministerByUNAndPW(@Param("ad_username") String ad_username, @Param("ad_password") String ad_password);
}
