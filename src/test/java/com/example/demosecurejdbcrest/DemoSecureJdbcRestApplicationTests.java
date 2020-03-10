package com.example.demosecurejdbcrest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class DemoSecureJdbcRestApplicationTests {


    void contextLoads() {

    }

    public static void main(String[] args) {
        String testString = "28.03.17";
//        String apper = "efefefe";
        Pattern pat9 = Pattern.compile("^\\d{3}\\.\\d\\d");// проверка на xxx.xx
        System.out.println(pat9.matcher(testString).matches());
        if (pat9.matcher(testString).matches()){
            System.out.println(testString);
        }

    }
}
