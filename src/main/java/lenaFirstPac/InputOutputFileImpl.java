package lenaFirstPac;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class InputOutputFileImpl implements InputOutputCreator{

    @Override
    public Reader getReader(String path) {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("Reader error");
        }
        return reader;
    }

    @Override
    public BufferedWriter getWriter(String path) {
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("Writer error");
        }
        return writer;
    }
}
