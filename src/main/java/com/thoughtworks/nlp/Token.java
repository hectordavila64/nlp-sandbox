package com.thoughtworks.nlp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Token {

    private String word;
    private String lemma;
    private String tag;

    public String toString() {
        return String.format("%s:%s(%s)", word, lemma, tag);
    }

}
