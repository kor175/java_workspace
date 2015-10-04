package ru.ncedu.java.tasks;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.Map.Entry;

public class WordCounterImpl implements WordCounter{
    private String text;
    private Map<String, Long> wordCounts;

    public WordCounterImpl (){
        text = null;
        wordCounts = null;
    }
    static final Comparator<Entry<String, Long>> SENIORITY_ORDER =
            new Comparator<Entry<String, Long>>() {
                public int compare(Entry<String, Long> e1, Entry<String, Long> e2) {
                    int entryCmp = e2.getValue().compareTo(e1.getValue());
                    if (entryCmp != 0) {
                        return entryCmp;
                    } else {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                }
            };
    public void setText (String text){
        this.text = text;
        wordCounts = this.getWordCounts();
    }
    public String getText (){
        return this.text;
    }
    public Map<String, Long> getWordCounts () throws IllegalStateException{
        if (this.text == null){
            throw new IllegalStateException();
        } else {
            wordCounts = new HashMap<String, Long>();
            String formatText = text.toLowerCase();
            boolean mark = false;
            char[] newText = formatText.toCharArray();
            for (int i = 0; i < newText.length; i++){
                if ( newText[i] == '<') {
                    mark = true;
                    newText[i] = ' ';
                } else if ( newText[i] == '>'){
                    mark = false;
                    newText[i] = ' ';
                } else if ( mark ){
                    newText[i] = ' ';
                }
            }
            formatText = new String( newText );
            String words[] = formatText.split("\\s+");
            for (int i = 0; i < words.length; i++){
                if (words[i].length() == 0) {
                } else {
                    Long freq = wordCounts.get(words[i]);
                    wordCounts.put(words[i], freq == null ? 1 : ++freq);
                }
            }
            return this.wordCounts;
        }
    }
    public List<Map.Entry<String, Long>> getWordCountsSorted () throws IllegalStateException{
        if (this.text == null){
            throw new IllegalStateException();
        } else {
            return this.sortWordCounts(this.getWordCounts());
        }
    }
    public List<Map.Entry<String, Long>> sortWordCounts( Map<String, Long> orig) {
        List<Map.Entry<String, Long>> list = new ArrayList<Entry<String, Long>>();
        if (orig == null){
            return null;
        } else {
            for (Map.Entry entry : orig.entrySet()) {
                list.add(entry);
            }
            Collections.sort(list, SENIORITY_ORDER);
            return list;
        }
    }
    public void printWordCounts (PrintStream ps) throws IllegalStateException{
        if (this.text == null){
            throw new IllegalStateException();
        } else {
            for (Map.Entry entry : this.getWordCounts().entrySet()) {
                ps.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
    public void printWordCountsSorted (PrintStream ps) throws IllegalStateException{
        if (this.text == null){
            throw new IllegalStateException();
        } else {
            List<Map.Entry<String, Long>> list = getWordCountsSorted();
            for (int i = 0; i < list.size(); i++) {
                ps.println(list.get(i).getKey() + " " + list.get(i).getValue());
            }
        }

    }
}