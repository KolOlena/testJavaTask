package lenaFirstPac;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class PrintService {
    private static final String[] HEADER = csvEditor.HEADER;
    CSVPrinter csvPrinter;
    public void createPrinter(Writer writer) throws IOException{
            csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(HEADER));
    }

    public void printRecord(List<String> lineItem) throws IOException {
            csvPrinter.printRecord(lineItem);
    }

    public void printClose() throws IOException {
        csvPrinter.close();
    }
}
