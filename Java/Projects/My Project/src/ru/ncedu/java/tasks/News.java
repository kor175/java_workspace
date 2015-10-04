package ru.ncedu.java.tasks;

public class News {
    private static Long currentID = 1L;
    private Long newsID;
    private Type newsType;
    private String newsGroup;
    private String newsText;
    private String newsImage;
    private String newsSound;
    private String newsReference;

    public News(Type newsType, String newsGroup, String newsText, String newsImage, String newsSound, String newsReference){
        this.newsID = currentID++;
        this.newsType = newsType;
        this.newsGroup = newsGroup;
        this.newsText = newsText;
        this.newsImage = newsImage;
        this.newsSound = newsSound;
        this.newsReference = newsReference;
    }

    public News(News news){
        this.newsID = news.newsID;
        this.newsType = news.newsType;
        this.newsGroup = news.newsGroup;
        this.newsText = news.newsText;
        this.newsImage = news.newsImage;
        this.newsSound = news.newsSound;
        this.newsReference = news.newsReference;
    }

    public Long getNewsID(){
        return this.newsID;
    }

    public Type getNewsType(){
        return this.newsType;
    }

    public String getNewsGroup(){
        return this.newsGroup;
    }

    public String getNewsText(){
        return this.newsText;
    }

    public String getNewsImage(){
        return this.newsImage;
    }

    public String getNewsSound(){
        return this.newsSound;
    }

    public String getNewsReference(){
        return this.newsReference;
    }

    public String toString(){
        String out = "ID:        " + this.newsID.toString() +
                     "\ntype:      " + this.newsType.toString() +
                     "\ngroup:     " + this.newsGroup.toString() +
                     "\ntext:      " + this.newsText.toString() +
                     "\nimage:     " + this.newsImage.toString() +
                     "\nsound:     " + this.newsSound.toString() +
                     "\nreference: " + this.newsReference.toString() + "\n";
        return out;
    }
}