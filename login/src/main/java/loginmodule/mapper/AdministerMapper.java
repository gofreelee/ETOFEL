package loginmodule.mapper;

import loginmodule.bean.Administer;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministerMapper {

    Administer selectAdministerByUNAndPW(String ad_username,String ad_password);
}
