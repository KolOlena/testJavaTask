package lenaFirstPac;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpService {
    private String searchExpression = csvEditor.DEPARTMENT_CODE;
//    private String searchExpression = null;
    Matcher matcher = null;
    public Matcher createMatcher(String source) throws RuntimeException {
        if (searchExpression == null || source == null) {
            throw new RuntimeException("Regexp template or substring is incorrect");
        }
            Pattern pattern = Pattern.compile(searchExpression);
             matcher = pattern.matcher(source);
             return matcher;
    }
}
