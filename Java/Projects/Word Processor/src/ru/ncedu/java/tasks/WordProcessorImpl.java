package ru.ncedu.java.tasks;

import java.io.*;
import java.util.*;

public class WordProcessorImpl implements WordProcessor {
    private String text;
    private List<String> words;

    public  WordProcessorImpl (){
        text = null;
        words = null;
    }
    public String getText (){
        if (this.text != null){
            return this.text;
        } else {
            return null;
        }
    }
    public void setSource (String src) throws IllegalArgumentException {
        if (src == null){
            throw new IllegalArgumentException();
        } else {
            this.text = src;
            words = null;
        }
    }
    public void setSourceFile (String srcFile) throws IOException, IllegalArgumentException{
        if (srcFile == null) {
            throw new IllegalArgumentException();
        } else {
            words = new ArrayList<String>();
            File textFile = new File(srcFile);
            if (textFile == null){
                throw new IOException();
            }
            BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( textFile ), "UTF-8"));
            if (br == null){
                throw new IOException();
            }
            String line = null;
            while ((line = br.readLine()) != null) {
                String wordsInString[] = line.split("\\s+");
                for (int i = 0; i < wordsInString.length; i++){
                    if (wordsInString[i].length() == 0){
                    } else {
                        words.add(wordsInString[i].toLowerCase());
                    }
                }
            }
            br.close();
        }
    }
    public void setSource (FileInputStream fis) throws IOException{
        if (fis == null) {
            throw new IllegalArgumentException();
        } else {
            words = new ArrayList<String>();
            BufferedReader br = new BufferedReader (new InputStreamReader( fis, "UTF-8"));
            if (br == null){
                throw new IOException();
            }
            String line = null;
            while ((line = br.readLine()) != null) {
                String wordsInString[] = line.split("\\s+");
                for (int i = 0; i < wordsInString.length; i++) {
                    if (wordsInString[i].length() == 0){
                    } else {
                        words.add(wordsInString[i].toLowerCase());
                    }
                }
            }
            br.close();
        }
    }
    public Set<String> wordsStartWith (String begin){
        if (text == null){
            throw new IllegalArgumentException();
        }
        Set<String> set = new HashSet<String>();
        if ( begin == null ){
            for (int i = 0; i < words.size(); i++) {
                set.add(words.get(i));
                System.out.println( words.get(i).length());
            }
        } else {
            for (int i = 0; i < words.size(); i++) {
                if (begin.equalsIgnoreCase(words.get(i).substring(0, begin.length()))) {
                    set.add(words.get(i));
                }
            }
        }
        return set;
    };
}
