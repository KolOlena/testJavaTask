package lenaFirstPac;

import java.io.BufferedWriter;
import java.io.IOException;

public interface OutputCreator {
    BufferedWriter getWriter(String path) throws IOException;
}
