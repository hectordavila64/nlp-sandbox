package com.thoughtworks.nlp;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StopWords {

    public static final String NOUN = "NOUN";
    public static final String VERB = "VERB";
    public static final String ADJ = "ADJ";
    public static final String PROPN = "PROPN";

    public static final List<String> tagsToKeep = Arrays.asList(NOUN, VERB, ADJ, PROPN);

    public static List<Token> removeStopwords(final List<Token> tokens) {
        return tokens.stream()
                .filter(token -> tagsToKeep.contains(token.getTag()))
                .collect(toList());
    }

}