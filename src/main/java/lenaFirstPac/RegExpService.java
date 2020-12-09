package lenaFirstPac;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegExpService {
    public static final String DEPARTMENT_CODE = "([A-Z]*)-(\\d{3})";
    Matcher matcher = null;
    public Matcher createMatcher(String source) throws RuntimeException {
        if (DEPARTMENT_CODE == null || source == null) {
            throw new RuntimeException("Regexp template or substring is incorrect");
        }
            Pattern pattern = Pattern.compile(DEPARTMENT_CODE);
             matcher = pattern.matcher(source);
             return matcher;
    }
}
