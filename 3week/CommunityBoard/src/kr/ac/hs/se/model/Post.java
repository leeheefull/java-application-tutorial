package kr.ac.hs.se.model;

import kr.ac.hs.se.util.BoardConstants;

import java.time.LocalDateTime;

public class Post {

    private int no;
    private String title;
    private String id;
    private String date;
    private String content;

    public Post() {
        this.setDate(BoardConstants.YYYYMMDD.format(LocalDateTime.now()));
    }

    public Post(int no, String title, String id, String content) {
        this.setNo(no);
        this.setTitle(title);
        this.setId(id);
        this.setDate(BoardConstants.YYYYMMDD.format(LocalDateTime.now()));
        this.setContent(content);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return no + "\t" + title + '\t' + id + '\t' + date + '\t' + content + "\n";
    }
}
