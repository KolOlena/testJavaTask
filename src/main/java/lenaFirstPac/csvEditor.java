package lenaFirstPac;

import java.io.*;

public class csvEditor {
    public static final String DEPARTMENT_CODE = "([A-Z]*)-(\\d{3})";
    public static final String[] HEADER = new String [] {"Name", "Department", "Department Code", "Department Code Name", "Department Code Number", "Amount"};
    private static final String SAMPLE_CSV_FILE_PATH = "./src/main/resources/input-training.csv";
    private static final String OUTPUT_FILE = "./src/main/resources/output-training.csv";
    private static InputCreator inputCreator = new InputFromFileImpl();
    private static OutputCreator outputCreator = new OutputToFileImpl();
    private static ParseService parseService = new ParseService();

    public static void main(String[] args) {
        try (
                Reader reader = inputCreator.getReader(SAMPLE_CSV_FILE_PATH);
                BufferedWriter writer = outputCreator.getWriter(OUTPUT_FILE);
                ) {
            parseService.parseSource(reader, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}