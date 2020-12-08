package lenaFirstPac;

import java.io.IOException;
import java.io.Reader;


public interface InputCreator {
    Reader getReader(String path) throws IOException;
}
