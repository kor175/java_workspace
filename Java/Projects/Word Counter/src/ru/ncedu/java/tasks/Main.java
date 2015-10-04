package ru.ncedu.java.tasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by z3roplusplus on 02.11.14.
 */
public class Main {

    public static void main(String[] args) {
        WordCounterImpl list = new WordCounterImpl();
        //list.setText("abc lcvgh1232gdh gdfjdh    \n\n \t f \n  jhj FGDH DFJ D\rF DF Dgh fdD>    \nABC     lfk\n kgh ls LS Ls");
        list.setText("");
        //Map<String, Long> map = list.getWordCounts();
        //list.printWordCounts(System.out);
        //System.out.println(list.getText());
        //Map<String, Long> map1 = list.getWordCounts();
        //list.printWordCountsSorted(System.out);
        //list.printWordCountsSorted(System.out);
        list.printWordCounts(System.out);
        System.out.println("------");
        list.printWordCountsSorted(System.out);
    }
}
