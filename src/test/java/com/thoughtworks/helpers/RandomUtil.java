package com.thoughtworks.helpers;

import com.github.javafaker.Faker;

public class RandomUtil {

    private static Faker faker = new Faker();

    private RandomUtil() {

    }

    public static String randomString() {
        return faker.regexify("[A-Z]{5}");
    }

}
