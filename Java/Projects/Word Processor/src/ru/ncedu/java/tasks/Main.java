package ru.ncedu.java.tasks;

import java.io.IOException;
import java.util.Set;

/**
 * Created by z3roplusplus on 02.11.14.
 */
public class Main {
    public static void main(String[] args) {
        WordProcessorImpl wp = new WordProcessorImpl();
        try{
            wp.setSourceFile("/home/z3roplusplus/videotest.txt");
            //System.out.println(wp.getText());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Set<String> set = wp.wordsStartWith(null);
        System.out.println(set);
    }
}
