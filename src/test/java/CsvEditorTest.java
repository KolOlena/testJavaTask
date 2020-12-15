import lenaFirstPac.MainConfig;
import lenaFirstPac.ParseService;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import java.io.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfig.class, loader = AnnotationConfigContextLoader.class)
public class CsvEditorTest {
    private static String INPUT_PATH = "./src/test/resources/input-training.csv";
    private static String EXPECT_PATH = "./src/test/resources/expect-result.csv";
    private static String SYSTEM_LINE_DELIMITER = System.getProperty("line.separator");
    private static String WIN_LINE_DELIMITER = "\r\n";

    @Autowired
    ParseService parseService;

    @Test
    public void csvEditorTesting() throws Exception {

        InputStream inputStream = new FileInputStream(INPUT_PATH);
        InputStream expect = new FileInputStream(new File(EXPECT_PATH));
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        parseService.parseSource(inputStream, result);

        String actual = new String(result.toByteArray());
        String expectedOutput = IOUtils.toString(expect).replace(SYSTEM_LINE_DELIMITER, WIN_LINE_DELIMITER);

        assertEquals(expectedOutput, actual);
    }
}