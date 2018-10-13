package com.thoughtworks.app;

import com.thoughtworks.nlp.POSTagging;
import com.thoughtworks.nlp.StopWords;
import com.thoughtworks.nlp.Token;
import com.thoughtworks.reader.CorpusReader;
import com.thoughtworks.reader.DirectoryReader;
import com.thoughtworks.reader.FileInfo;
import edu.stanford.nlp.dcoref.SieveCoreferenceSystem;

import java.io.IOException;
import java.util.Dictionary;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String content = "El hombre está en el medio";

        POSTagging tag = new POSTagging();
        List<Token> token = tag.getTags(content);

//        token = StopWords.removeStopwords(token);

        System.out.println(token);
    }
}
