package lenaFirstPac;

import java.io.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class csvEditor {
    private static final String SAMPLE_CSV_FILE_PATH = "./src/main/resources/input-training.csv";
    private static final String OUTPUT_FILE = "./src/main/resources/output-training.csv";
    private static final String DEPARTMENT_CODE = "([A-Z]*)-(\\d{3})";


    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile(DEPARTMENT_CODE);

        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Name", "Department", "Department Code", "Amount"));
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(OUTPUT_FILE));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Name", "Department", "Department Code","Department Code Name", "Department Code Number", "Amount"));
        ) {
            double grandAmount = 0;

            for (CSVRecord csvRecord : csvParser) {
                Matcher matcher = pattern.matcher(csvRecord.get("Department Code"));
                LineItem lineItem = new LineItem();

                if (matcher.matches()) {
                    String name = format(csvRecord.get("Name"));
                    String department = format(csvRecord.get("Department"));
                    String departmentCode = format(csvRecord.get("Department Code"));
                    String amount = format(csvRecord.get("Amount"));

                    lineItem.setName(name.isEmpty() ? "N/A" : name);
                    lineItem.setDepartment(department.isEmpty() ? "N/A" : department);
                    lineItem.setDepartmentCode(departmentCode.isEmpty() ? "N/A" : departmentCode);
                    lineItem.setDepartmentCodeName(matcher.group(1));
                    lineItem.setDepartmentCodeNumber(matcher.group(2));
                    lineItem.setAmount(amount.isEmpty() ? "N/A" : amount);

                    csvPrinter.printRecord(lineItem.asList());

                    grandAmount += Double.parseDouble(format(csvRecord.get(3)));
                }
            }

            LineItem lineItem = new LineItem();

            lineItem.setName("Total");
            lineItem.setDepartment("");
            lineItem.setDepartmentCode("");
            lineItem.setAmount(Double.toString(grandAmount));

            csvPrinter.printRecord(lineItem.asList());
        }
    }


    private static String format (String input) {
        input = input.trim()
                .replaceAll(" ", "")
                .replaceAll(",", "")
                .replaceAll("\\$", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "");

        if (input.isEmpty()) return "";

        return input;
    }

}