package lenaFirstPac;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.Reader;
import java.io.Writer;
import java.util.regex.Matcher;

public class ParseService {
    private RegExpService regExpService = new RegExpService();
    private NumberFormatter numberFormatter = new NumberFormatter();
    private PrintService printService = new PrintService();

    void parseSource(Reader reader, Writer writer) throws Exception {
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Name", "Department", "Department Code", "Amount"));
        double grandAmount = 0;

        printService.createPrinter(writer);

        for (CSVRecord csvRecord : csvParser) {
            Matcher matcher = regExpService.createMatcher(csvRecord.get("Department Code"));

            LineItem lineItem = new LineItem();

            if (matcher.matches()) {
                String name = numberFormatter.format(csvRecord.get("Name"));
                String department = numberFormatter.format(csvRecord.get("Department"));
                String departmentCode = numberFormatter.format(csvRecord.get("Department Code"));
                String amount = numberFormatter.format(csvRecord.get("Amount"));

                lineItem.setName(name.isEmpty() ? "N/A" : name);
                lineItem.setDepartment(department.isEmpty() ? "N/A" : department);
                lineItem.setDepartmentCode(departmentCode.isEmpty() ? "N/A" : departmentCode);
                lineItem.setDepartmentCodeName(matcher.group(1));
                lineItem.setDepartmentCodeNumber(matcher.group(2));
                lineItem.setAmount(amount.isEmpty() ? "N/A" : amount);

                printService.printRecord(lineItem.asList());

                grandAmount += Double.parseDouble(numberFormatter.format(csvRecord.get(3)));
            }
        }
        LineItem lineItem = new LineItem();

        lineItem.setName("Total");
        lineItem.setDepartment("");
        lineItem.setDepartmentCode("");
        lineItem.setAmount(Double.toString(grandAmount));

        printService.printRecord(lineItem.asList());
        printService.printClose();
        csvParser.close();
    }
}