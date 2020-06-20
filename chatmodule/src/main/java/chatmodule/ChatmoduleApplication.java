package chatmodule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("chatmodule")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ChatmoduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatmoduleApplication.class, args);
    }

}
