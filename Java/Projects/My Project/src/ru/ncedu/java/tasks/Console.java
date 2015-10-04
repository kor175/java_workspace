package ru.ncedu.java.tasks;

import java.io.*;
import java.util.Scanner;

public class Console {
    Repository repository;
    public Console(Repository repository){
        this.repository = repository;
    }

    public void callConsole(){
        Scanner commands = new Scanner(System.in);
        String str;
        try {
            for (;;) {
                System.out.print("Input command: ");
                str = commands.nextLine();
                if (str.equalsIgnoreCase("exit")) {
                    break;
                }
                if (str.equalsIgnoreCase("load groups")) {
                    repository.loadGroups();
                } else if (str.equalsIgnoreCase("load news")) {
                    repository.loadAllNews();
                } else if (str.equalsIgnoreCase("load published news")) {
                    repository.loadPublishedNews();
                } else if (str.equalsIgnoreCase("update news")) {
                    repository.updateNews();
                } else if (str.equalsIgnoreCase("upload news")) {
                    repository.uploadAllNews();
                } else if (str.equalsIgnoreCase("upload published news")) {
                    repository.uploadPublishedNews();
                } else if (str.equalsIgnoreCase("upload groups")) {
                    repository.uploadGroups();
                } else {
                    System.out.println("Illegal Expression");
                }
            }
        }
        catch (IOException ioe){

        }
    }
}