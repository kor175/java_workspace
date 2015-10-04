package ru.ncedu.java.tasks;

import java.util.ArrayList;
import java.util.List;

public class NewsList {
    private List<News> news;

    public NewsList(){
        news = new ArrayList<News>();
    }

    public void setNews ( List<News> news ){
        this.news = news;
    }

    public List<News> getNews (){
        List<News> returnNews = new ArrayList<News> ();
        for (int i = 0; i < this.news.size(); i++){
            returnNews.add(news.get(i));
        }
        return returnNews;
    }

    public List<News> getNews ( Type type ){
        List<News> returnnews = new ArrayList<News>();

        for ( int i = 0; i < news.size(); i++ ){
            if ( news.get(i).getNewsType().equals( type ))
                returnnews.add(news.get(i));
        }
        return returnnews;
    }

    public void addNews ( News news ){
        this.news.add( news );
    }

    public void addNews ( List<News> news ){
        for ( int i = 0; i < news.size(); i++ ) {
            this.news.add( news.get( i ) );
        }
    }

    public void deleteNews( Long ID ){
        for ( int i = 0; i < this.news.size(); i++ ) {
            if ( this.news.get( i ).getNewsID().equals( ID ) ){
                this.news.remove( i );
                break;
            }
        }
    }

    public String toString(){
        String out = "";
        for (int i = 0; i < this.news.size(); i++){
            out += this.news.get(i).toString() + "\n";
        }
        return out;
    }

    public News get(int index){
        News n = new News(this.news.get(index));
        return n;
    }

    public int size(){
        return this.news.size();
    }
}