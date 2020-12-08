package lenaFirstPac;

import lombok.Data;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Data
public class PrintService {
    private static final String[] HEADER = csvEditor.HEADER;
    CSVPrinter csvPrinter;

    public void createWriter (Writer writer) {
        try {
            csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(HEADER));
        } catch (IOException e) {}
    }

    public void print( List<String> lineItem) throws IOException {
            csvPrinter.printRecord(lineItem);
    }
}
