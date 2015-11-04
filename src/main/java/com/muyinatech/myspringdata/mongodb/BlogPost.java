package com.muyinatech.myspringdata.mongodb;

import java.util.Date;

public class BlogPost {

    private String title;
    private String content;
    private Date date;

    public BlogPost(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
