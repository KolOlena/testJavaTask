package lenaFirstPac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.logging.Logger;

@Component
public class CsvEditor {
    private static final Logger logger = Logger.getGlobal();

    private static final String SAMPLE_CSV_FILE_PATH = "./src/main/resources/input-training.csv";
    private static final String OUTPUT_FILE = "./src/main/resources/output-training.csv";

    @Autowired
    private InputCreator inputCreator;
    @Autowired
    private OutputCreator outputCreator;
    @Autowired
    private ParseService parseService;

    public void executeAll () {
        try (
                Reader reader = inputCreator.getReader(SAMPLE_CSV_FILE_PATH);
                BufferedWriter writer = outputCreator.getWriter(OUTPUT_FILE);
        ) {
            parseService.parseSource(reader, writer);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.toString());
        }
    }
}