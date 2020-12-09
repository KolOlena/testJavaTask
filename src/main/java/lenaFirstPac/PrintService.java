package lenaFirstPac;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class PrintService {
    public static final String[] HEADER = new String[]{"Name", "Department", "Department Code", "Department Code Name", "Department Code Number", "Amount"};

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
