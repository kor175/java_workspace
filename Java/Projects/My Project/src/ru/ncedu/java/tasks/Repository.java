package ru.ncedu.java.tasks;

import java.io.IOException;

public interface Repository {
    public GroupList getGroups();

    public NewsList getAllNews();

    public NewsList getPublishedNews();

    public void loadGroups() throws IOException;

    public void loadAllNews() throws IOException;

    public void loadPublishedNews() throws IOException;

    public void updateNews();

    public void uploadAllNews() throws IOException;

    public void uploadPublishedNews() throws IOException;

    public void uploadGroups() throws IOException;
}
