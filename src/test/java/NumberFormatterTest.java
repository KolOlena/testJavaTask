import lenaFirstPac.NumberFormatter;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.commons.io.IOUtils;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class NumberFormatterTest {
    NumberFormatter numberFormatter = new NumberFormatter();

    @Test
    public void csvEditorTesting() throws IOException {
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
