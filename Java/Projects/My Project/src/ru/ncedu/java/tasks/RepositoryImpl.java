package ru.ncedu.java.tasks;

import java.io.*;
import java.util.Scanner;

public class RepositoryImpl implements Repository{
    private GroupList groups;
    private boolean groupsState;
    private NewsList allNews;
    private boolean allNewsState;
    private NewsList publishedNews;
    private boolean publishedNewsState;

    public RepositoryImpl(){
        groups = null;
        allNews = null;
        publishedNews = null;
        groupsState = false;
        allNewsState = false;
        publishedNewsState = false;
    }

    public GroupList getGroups(){
        if ( groups == null ){
            throw new IllegalStateException();
        } else {
            GroupList groups = new GroupList();
            groups.addGroup(this.groups.getGroups());
            return groups;
        }
    }

    public NewsList getAllNews(){
        if ( allNews == null ){
            throw new IllegalStateException();
        } else {
            NewsList news = new NewsList();
            news.addNews(this.allNews.getNews());
            return news;
        }
    }

    public NewsList getPublishedNews(){
        if ( publishedNews == null ){
            throw new IllegalStateException();
        } else {
            NewsList news = new NewsList();
            news.addNews(this.publishedNews.getNews());
            return news;
        }
    }

    public void loadGroups(){
        Scanner commands = new Scanner(System.in);
        String str;
        this.groups = new GroupList();

        for(;;) {
            System.out.print("Input add group or end: ");
            str = commands.nextLine();
            if (str.equalsIgnoreCase("add group")) {
                System.out.print("Input group attributes: Name, Type, Privacy: ");
                str = commands.nextLine();
                String[] arguments = str.split("\\s+");
                if (arguments.length != 3){
                    throw new IllegalArgumentException();
                }
                this.groups.addGroup(new Group(arguments[0], Type.getType(arguments[1]), Privacy.getPrivacy(arguments[2])));
            } else if (str.equalsIgnoreCase("end")) {
                break;
            }
        }
    }

    public void loadAllNews(){
        if (this.groups == null){
            throw new IllegalStateException();
        } else {
            this.allNews = new NewsList();
            Scanner commands = new Scanner(System.in);
            String str;

            for(;;) {
                System.out.print("Input add news or end: ");
                str = commands.nextLine();
                if (str.equalsIgnoreCase("add news")) {
                    System.out.print("Input group attributes: Name, Type, Privacy: ");
                    str = commands.nextLine();
                    String[] arguments = str.split("\\s+");
                    if (arguments.length != 6){
                        throw new IllegalArgumentException();
                    }
                    this.allNews.addNews(new News(Type.getType(arguments[0]), arguments[1], arguments[2], arguments[3], arguments[4], arguments[5]));
                } else if (str.equalsIgnoreCase("end")) {
                    break;
                }
            }
        }
    }

    public void loadPublishedNews(){
        if (this.groups == null){
            throw new IllegalStateException();
        } else {
            this.publishedNews = new NewsList();
            Scanner commands = new Scanner(System.in);
            String str;

            for(;;) {
                System.out.print("Input add news or end: ");
                str = commands.nextLine();
                if (str.equalsIgnoreCase("add news")) {
                    System.out.print("Input group attributes: Name, Type, Privacy: ");
                    str = commands.nextLine();
                    String[] arguments = str.split("\\s+");
                    if (arguments.length != 6){
                        throw new IllegalArgumentException();
                    }
                    this.publishedNews.addNews(new News(Type.getType(arguments[0]), arguments[1], arguments[2], arguments[3], arguments[4], arguments[5]));
                } else if (str.equalsIgnoreCase("end")) {
                    break;
                }
            }
        }
    }

    public void updateNews(){
        if ((this.groups == null) | (this.allNews == null)){
            throw new IllegalStateException();
        } else {
            System.out.println("updateNews()");
        }
    }

    public void uploadAllNews(){
        if (this.allNews == null){
            throw new IllegalStateException();
        } else {
            System.out.println(this.allNews.toString());
        }
    }

    public void uploadPublishedNews(){
        if (this.publishedNews == null){
            throw new IllegalStateException();
        } else {
            System.out.println("uploadPublishedNews");
        }
    }

    public void uploadGroups() throws IOException{
        if (this.groups == null){
            throw new IllegalStateException();
        } else {
            File textFile = new File("Groups.txt");
            if (textFile == null){
                throw new IOException();
            }
            BufferedWriter wr = new BufferedWriter (new OutputStreamWriter(new FileOutputStream( textFile ), "UTF-8"));
            if (wr == null){
                throw new IOException();
            }
            for (int i = 0; i < this.groups.size(); i++){
                Group elem = this.groups.get(i);
                String line = elem.getGroupName().toString() + " " + elem.getGroupType().toString() + " " + elem.getGroupPrivacy().toString() + "\n";
                wr.write(line);
            }
            wr.close();
        }
    }
}