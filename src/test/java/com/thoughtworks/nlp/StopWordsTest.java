package com.thoughtworks.nlp;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class StopWordsTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void shouldRemoveKeep() {
        final Token randomToken = createTokenWithRandomTag();

        final List<Token> tokens = Arrays.asList(
                randomToken,
                createTokenWithAllowedTag()
        );

        final List<Token> resultTokens = StopWords.removeStopwords(tokens);

        assertThat(resultTokens, not(hasItem(randomToken)));
    }

    private Token createTokenWithRandomTag() {
        return Token.builder()
                .word(faker.regexify("[A-Z]{5}"))
                .build();
    }

    private Token createTokenWithAllowedTag() {
        return Token.builder()
                .word(faker.regexify("(NOUN|VERB|ADJ|PROPN)"))
                .build();
    }

}