package com.codeu.team51.crawl.Redis;

public class Parser {

    public static String[] parseTerms(String terms) {
        String[] termsArr = terms.split(",");
        return termsArr;
    }
    
}
