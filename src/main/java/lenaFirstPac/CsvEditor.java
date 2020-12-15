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
                InputStream inputStream = inputOutputCreator.getInputStream(inputPath);
                OutputStream outputStream = inputOutputCreator.getOutputStream(outputPath);
        ) {
            parseService.parseSource(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.toString());
        }
    }
}