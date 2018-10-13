package com.thoughtworks.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectoryReader {

    private String directoryPath;
    private List<String> allowedFileExtensions = Arrays.asList("txt");

    public DirectoryReader(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public List<FileInfo> read() {
        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles();
        List<FileInfo> content = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isFile() && isTextFile(file)) {
                String filePath = file.getPath();
                CorpusReader corpusReader = new CorpusReader(filePath);
                String fileContent = corpusReader.read();
                FileInfo fileInfo = new FileInfo(file.getName(),fileContent);
                content.add(fileInfo);
            }
        }
        return content;
    }

    private boolean isTextFile(File file){
        String fileName = file.getName();
        String [] fileNameParts = fileName.split("\\.");
        if(fileNameParts.length<2){
            return false;
        }
        String fileExtension = fileNameParts[fileNameParts.length-1];
        return allowedFileExtensions.contains(fileExtension);
    }
}
