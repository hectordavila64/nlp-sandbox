package com.thoughtworks.nlp;

import com.thoughtworks.exception.LoadNLPPropertiesException;
import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class POSTagging {

    private static StanfordCoreNLP pipeline;

    public List<Token> getTags(String text) {
        initialize();
        CoreDocument document = new CoreDocument(text);
        pipeline.annotate(document);
        List<Token> tokens = new ArrayList<>();

        for (CoreLabel label : document.tokens()) {
            String tag = label.tag();
            String lemma = label.lemma();
            String word = label.word();
            int s = label.beginPosition();
            int e = label.endPosition();
            Token token = Token.builder()
                    .word(word)
                    .lemma(lemma)
                    .tag(tag)
                    .build();
            tokens.add(token);
        }

        return tokens;
    }

    private void initialize() {
        if (pipeline != null) {
            return;
        }

        try {
            Properties props = new Properties();
            props.load(IOUtils.readerFromString("StanfordCoreNLP-spanish.properties"));
            props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
            pipeline = new StanfordCoreNLP(props);
        } catch (IOException ex) {
            throw new LoadNLPPropertiesException(ex);
        }
    }

}
