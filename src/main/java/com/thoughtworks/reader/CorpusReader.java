package com.thoughtworks.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class CorpusReader {

    private String corpusPath;

    public CorpusReader(String corpusPath) {
        this.corpusPath = corpusPath;
    }

    public String read() {
        try {
            List<String> lines = Files.readAllLines(new File(corpusPath).toPath(), StandardCharsets.ISO_8859_1);
            return String.join(" ", lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
