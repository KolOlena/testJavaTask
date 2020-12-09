package lenaFirstPac;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class InputFromFileImpl implements InputCreator {

    @Override
    public Reader getReader (String path) throws IOException {
        return createFileReader(path);
    }

    private Reader createFileReader (String path) throws IOException{
        Reader reader = Files.newBufferedReader(Paths.get(path));
        return reader;
    }

}
