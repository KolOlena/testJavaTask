package lenaFirstPac;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class InputOutputFileImpl implements InputOutputCreator{

    @Override
    public InputStream getInputStream(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        return inputStream;
    }

    @Override
    public OutputStream getOutputStream(String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        return outputStream;
    }
}
