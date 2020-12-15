package lenaFirstPac;

import java.io.*;

public interface InputOutputCreator {
    InputStream getInputStream (String path) throws IOException;
    OutputStream getOutputStream (String path) throws IOException;
}
