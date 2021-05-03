package home;


import home.dev.resource.TagEditorApiImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@ComponentScan(basePackageClasses = TagEditorApiImpl.class)
class TagEditor {

    public static void main(String[] args) {
        SpringApplication.run(TagEditor.class, args);
    }
}
