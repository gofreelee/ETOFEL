package chatmodule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("chatmodule")
@SpringBootApplication
public class ChatmoduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatmoduleApplication.class, args);
    }

}
