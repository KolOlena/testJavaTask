package lenaFirstPac;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class RegExpService {
    private String expression = csvEditor.DEPARTMENT_CODE;
    Matcher matcher = null;
    public Matcher createRegExp (String source) {
            Pattern pattern = Pattern.compile(expression);
             matcher = pattern.matcher(source);
             return matcher;
    }

}
