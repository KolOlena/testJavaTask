package lenaFirstPac;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;

public interface InputOutputCreator {
    Reader getReader(String path) throws IOException;
    BufferedWriter getWriter(String path) throws IOException;
}
