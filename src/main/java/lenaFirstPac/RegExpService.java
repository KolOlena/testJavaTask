package lenaFirstPac;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpService {
    private String searchExpression = csvEditor.DEPARTMENT_CODE;
    Matcher matcher = null;
    public Matcher createMatcher(String source) {
            Pattern pattern = Pattern.compile(searchExpression);
             matcher = pattern.matcher(source);
             return matcher;
    }
}
