package lenaFirstPac;

import lombok.Data;
import java.util.Arrays;
import java.util.List;

@Data
public class LineItem {
    private String name;
    private String department;
    private String departmentCode;
    private String departmentCodeName;
    private String departmentCodeNumber;
    private String amount;

    public List<String> asList() {
        return Arrays.asList(name, department, departmentCode, departmentCodeName, departmentCodeNumber, amount);
    }

}
