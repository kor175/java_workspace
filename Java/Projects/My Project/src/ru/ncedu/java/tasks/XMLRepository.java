package ru.ncedu.java.tasks;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class XMLRepository implements Repository {
    private GroupList groups;
    private boolean groupsState;
    private NewsList allNews;
    private boolean allNewsState;
    private NewsList publishedNews;
    private boolean publishedNewsState;

    public XMLRepository(){
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

    public void loadGroups() throws IllegalArgumentException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("Groups.xml"));
            /*File textFile = new File("Groups.txt");
            if (textFile == null){
                throw new IOException();
            }
            BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( textFile ), "UTF-8"));
            if (br == null){
                throw new IOException();
            }
            this.groups = new GroupList();
            String line;
            while ((line = br.readLine()) != null) {
                String[] arguments = line.split("\\s+");
                if (arguments.length != 3) {
                    throw new IllegalArgumentException();
                }
                this.groups.addGroup(new Group(arguments[0], Type.getType(arguments[1]), Privacy.getPrivacy(arguments[2])));
            }
            br.close();*/
            this.groups = new GroupList();
            NodeList nodes = document.getChildNodes();
            System.out.println(nodes.toString());
            for ( int i = 0; i < nodes.getLength(); i++ ){
                NodeList properties = nodes.item(i).getChildNodes();
                String groupName = properties.item(0).getChildNodes().item(0).getTextContent();
                Type groupType = Type.getType(properties.item(1).getChildNodes().item(0).getTextContent());
                Privacy groupPrivacy = Privacy.getPrivacy(properties.item(2).getTextContent());
            }
            if (this.groups.size() == 0){
                this.groups = null;
            }
        }
        catch ( ParserConfigurationException pars ){
        }
        catch ( SAXException saxe ){
        }
        catch ( IOException io ){
        }
    }

    public void loadAllNews() throws IOException, IllegalArgumentException{
        File textFile = new File("AllNews.txt");
        if (textFile == null){
            throw new IOException();
        }
        BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( textFile ), "UTF-8"));
        if (br == null){
            throw new IOException();
        }
        this.allNews = new NewsList();
        String line;
        while ((line = br.readLine()) != null) {
            String[] arguments = line.split("\\s+");
            if (arguments.length > 6){
                throw new IllegalArgumentException();
            }
            this.allNews.addNews(new News(Type.getType(arguments[0]), arguments[1], arguments[2], arguments[3], arguments[4], arguments[5]));
        }
        br.close();
        if (this.groups.size() == 0){
            this.groups = null;
        }
    }

    public void loadPublishedNews() throws IOException{
        File textFile = new File("PublishedNews.txt");
        if (textFile == null){
            throw new IOException();
        }
        BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( textFile ), "UTF-8"));
        if (br == null){
            throw new IOException();
        }
        this.publishedNews = new NewsList();
        String line;
        while ((line = br.readLine()) != null) {
            String[] arguments = line.split("\\s+");
            if (arguments.length > 6){
                throw new IllegalArgumentException();
            }
            this.publishedNews.addNews(new News(Type.getType(arguments[0]), arguments[1], arguments[2], arguments[3], arguments[4], arguments[5]));
        }
        br.close();
        if (this.groups.size() == 0){
            this.groups = null;
        }
    }

    public void updateNews(){
        if ((this.groups == null) | (this.allNews == null)){
            throw new IllegalStateException();
        } else {
            System.out.println("updateNews()");
        }
    }

    public void uploadAllNews() throws IOException{
        if (this.allNews == null){
            throw new IllegalStateException();
        } else {
            File textFile = new File("AllNews.txt");
            if (textFile == null){
                throw new IOException();
            }
            BufferedWriter wr = new BufferedWriter (new OutputStreamWriter(new FileOutputStream( textFile ), "UTF-8"));
            if (wr == null){
                throw new IOException();
            }
            for (int i = 0; i < this.allNews.size(); i++){
                News elem = this.allNews.get(i);
                String line = elem.getNewsType().toString() + " " +
                        elem.getNewsGroup() + " " +
                        elem.getNewsText() + " " +
                        elem.getNewsImage() + " " +
                        elem.getNewsSound() + " " +
                        elem.getNewsReference() +"\n";
                wr.write(line);
            }
            wr.close();
        }
    }

    public void uploadPublishedNews() throws  IOException {
        if (this.publishedNews == null){
            throw new IllegalStateException();
        } else {
            File textFile = new File("PublishedNews.txt");
            if (textFile == null){
                throw new IOException();
            }
            BufferedWriter wr = new BufferedWriter (new OutputStreamWriter(new FileOutputStream( textFile ), "UTF-8"));
            if (wr == null){
                throw new IOException();
            }
            for (int i = 0; i < this.publishedNews.size(); i++){
                News elem = this.publishedNews.get(i);
                String line = elem.getNewsType().toString() + " " +
                        elem.getNewsGroup() + " " +
                        elem.getNewsText() + " " +
                        elem.getNewsImage() + " " +
                        elem.getNewsSound() + " " +
                        elem.getNewsReference() +"\n";
                wr.write(line);
            }
            wr.close();
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
                String line = elem.getGroupName() + " " + elem.getGroupType().toString() + " " + elem.getGroupPrivacy().toString() + "\n";
                wr.write(line);
            }
            wr.close();
        }
    }
}