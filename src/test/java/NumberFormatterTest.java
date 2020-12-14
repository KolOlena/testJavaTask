import lenaFirstPac.CsvEditor;
import lenaFirstPac.MainConfig;
import lenaFirstPac.NumberFormatter;
import lenaFirstPac.ParseService;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfig.class, loader = AnnotationConfigContextLoader.class)
public class NumberFormatterTest {

    @Autowired
    NumberFormatter numberFormatter;
    @Autowired
    ParseService parseService;

    @Test
    public void contextIsLoaded() {
        assertNotNull(numberFormatter);
    }

    @Test
    public void csvEditorTesting() throws IOException {
        String inputPath = "./src/main/resources/output-training.csv";

        parseService.parseSource(//TODO );



        InputStream expect = new FileInputStream(new File("./src/main/resources/expected-output-training.csv"));
        InputStream fact = new FileInputStream(new File("./src/main/resources/output-training.csv"));

        String expectedOutput = IOUtils.toString(expect);


        String actualOutput = IOUtils.toString(fact);
                assertEquals(expectedOutput, actualOutput);

//        String factNum = numberFormatter.format(" 56$ ");
//        String expectNum = "56";
//        assertEquals(expectNum, factNum);
    }
}
