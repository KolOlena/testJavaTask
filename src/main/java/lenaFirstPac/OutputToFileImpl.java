package lenaFirstPac;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;

@Service
public class OutputToFileImpl implements OutputCreator {

    @Override
    public BufferedWriter getWriter(String path) throws IOException {
        return createFileWriter(path);
    }

    private BufferedWriter createFileWriter(String path) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));
        return writer;
    }
}
