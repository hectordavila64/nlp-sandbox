package com.thoughtworks.nlp;

import com.github.javafaker.Faker;
import com.thoughtworks.helpers.RandomUtil;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TokenTest {

    @Test
    public void shouldReturnCorrectToStringValue() {
        String randomTag = RandomUtil.randomString();
        String randomLemma = RandomUtil.randomString();
        String randomWord = RandomUtil.randomString();

        Token token = Token.builder()
                .tag(randomTag)
                .lemma(randomLemma)
                .word(randomWord)
                .build();


        assertThat(token.toString(), is(randomWord + ":" + randomLemma + "(" + randomTag + ")"));
    }

}