package lenaFirstPac;

import org.springframework.stereotype.Service;

@Service
public class NumberFormatter {
    public String format (String input) {
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
