package fan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 系统启动类
 *
 * @author Fan
 * @since 2023/6/9 10:59
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class FanWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FanWebApplication.class, args);
    }
}
