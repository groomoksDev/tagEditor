package home;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
class TagEditor {

    public static void main(String[] args) {
        SpringApplication.run(TagEditor.class, args);
    }
}
