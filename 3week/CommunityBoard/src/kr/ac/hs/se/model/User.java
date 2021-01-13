package kr.ac.hs.se.model;

public class User {

    private String id;
    private String name;
    private String pw;

    public User() {
    }

    public User(String id, String name, String pw) {
        this.setId(id);
        this.setName(name);
        this.setPw(pw);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String passWord) {
        this.pw = passWord;
    }
}
