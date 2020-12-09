package lenaFirstPac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "lenaFirstPac")
public class MainConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        CsvEditor csvEditor = context.getBean("csvEditor", CsvEditor.class);
        csvEditor.executeAll();
    }
}
