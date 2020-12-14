package lenaFirstPac;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ParseService {
    public static final String DEPARTMENT_CODE = "([A-Z]*)-(\\d{3})";
    public static final String N_A = "N/A";
    Pattern pattern = Pattern.compile(DEPARTMENT_CODE);
    public static final String[] HEADER = new String[]{"Name", "Department", "Department Code", "Department Code Name", "Department Code Number", "Amount"};


    @Autowired
    private NumberFormatter numberFormatter;

    public void parseSource(InputStream inputStream, OutputStream outputStream) throws Exception {

        // TODO: use try with resources
        CSVParser csvParser = new CSVParser(new InputStreamReader(inputStream), CSVFormat.DEFAULT.withHeader("Name", "Department", "Department Code", "Amount"));
        double grandAmount = 0;
        CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(outputStream) {
        }, CSVFormat.DEFAULT.withHeader(HEADER));

        for (CSVRecord csvRecord : csvParser) {
            String name = numberFormatter.format(csvRecord.get("Name"));
            String department = numberFormatter.format(csvRecord.get("Department"));
            String departmentCode = numberFormatter.format(csvRecord.get("Department Code"));
            String amount = numberFormatter.format(csvRecord.get("Amount"));

            Matcher matcher = pattern.matcher(departmentCode);

            LineItem lineItem = new LineItem();

            if (matcher.matches()) {

                lineItem.setName(name.isEmpty() ? N_A : name);
                lineItem.setDepartment(department.isEmpty() ? N_A : department);
                lineItem.setDepartmentCode(departmentCode.isEmpty() ? N_A : departmentCode);
                lineItem.setDepartmentCodeName(matcher.group(1));
                lineItem.setDepartmentCodeNumber(matcher.group(2));
                lineItem.setAmount(amount.isEmpty() ? N_A : amount);

                printing(csvPrinter, lineItem.asList());
                delimetr(lineItem.asList());

//                csvPrinter.printRecord(lineItem.asList());

                grandAmount += Double.parseDouble(numberFormatter.format(csvRecord.get(3)));
            }
        }

        LineItem lineItem = new LineItem();

        lineItem.setName("Total");
        lineItem.setDepartment("");
        lineItem.setDepartmentCode("");
        lineItem.setAmount(Double.toString(grandAmount));

        csvPrinter.printRecord(lineItem.asList());
    }

    List delimetr (List lineItem) {
        return lineItem;
    }
    void printing (CSVPrinter csvPrinter, List lineItem) throws IOException {

        csvPrinter.printRecord(lineItem);
    }
}

