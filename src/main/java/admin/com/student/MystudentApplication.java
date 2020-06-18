package admin.com.student;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "admin.com.student")
@MapperScan({"admin.com.student.**.mapper"})
public class MystudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(MystudentApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n");
    }
}
