package lenaFirstPac;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    public Matcher regExpChecker (String searchPatter,String searchField ) {
        Pattern pattern = Pattern.compile(searchPatter);
        Matcher matcher = pattern.matcher(searchField);
        return matcher;
    }
}
