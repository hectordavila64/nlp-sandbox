package com.thoughtworks.reader;

public class FileInfo {
    private String fileName;
    private String FileContent;

    public FileInfo(String fileName, String fileContent) {
        this.fileName = fileName;
        FileContent = fileContent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContent() {
        return FileContent;
    }

    public void setFileContent(String fileContent) {
        FileContent = fileContent;
    }
}
