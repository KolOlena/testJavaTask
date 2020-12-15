package lenaFirstPac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "lenaFirstPac")
public class MainConfig {
    private static final String SAMPLE_CSV_FILE_PATH = "./src/main/resources/input-training.csv";
    private static final String OUTPUT_FILE = "./src/main/resources/output-training.csv";

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        CsvEditor csvEditor = context.getBean("csvEditor", CsvEditor.class);
        csvEditor.processFile(SAMPLE_CSV_FILE_PATH, OUTPUT_FILE);
    }
}
