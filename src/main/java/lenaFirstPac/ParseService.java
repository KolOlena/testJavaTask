package lenaFirstPac;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.regex.Matcher;

public class ParseService {
    private static RegExpService regExpService = new RegExpService();
    private static NumberFormatter numberFormatter = new NumberFormatter();
    private static PrintService printService = new PrintService();

    void parseSource(Reader reader, Writer writer) {
        try (
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Name", "Department", "Department Code", "Amount"));
        ) {
            double grandAmount = 0;

            printService.createWriter(writer);

            for (CSVRecord csvRecord : csvParser) {
                Matcher matcher = regExpService.createRegExp(csvRecord.get("Department Code"));

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

                    printService.print(lineItem.asList());

                    grandAmount += Double.parseDouble(numberFormatter.format(csvRecord.get(3)));
                }
            }
            LineItem lineItem = new LineItem();

            lineItem.setName("Total");
            lineItem.setDepartment("");
            lineItem.setDepartmentCode("");
            lineItem.setAmount(Double.toString(grandAmount));

            printService.print(lineItem.asList());
        }
        catch (IOException e) {}
    }
}