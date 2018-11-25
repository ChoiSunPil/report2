
package sopt.org.seminar2_review.Model;

public class User {
    private int userIdx;
    private String name;
    private String part;

    public User() {
    }

    public User(int userIdx, String name, String part) {
        this.userIdx = userIdx;
        this.name = name;
        this.part = part;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}