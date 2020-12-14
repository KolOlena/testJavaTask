package lenaFirstPac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.logging.Logger;

@Component
public class CsvEditor {
    private static final Logger logger = Logger.getGlobal();

    @Autowired
    private ParseService parseService;
    @Autowired
    private InputOutputCreator inputOutputCreator;

    public void processFile(String inputPath, String outputPath) {
        try (
                Reader reader = inputOutputCreator.getReader(inputPath);
                BufferedWriter writer = inputOutputCreator.getWriter(outputPath);
        ) {
            parseService.parseSource(reader, writer);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.toString());
        }
    }
}