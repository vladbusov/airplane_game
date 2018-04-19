package hello;

public class Position {
    private Integer positionX;
    private Integer positionY;
    private String nickname;
    private Boolean exist;

    Position() {
    }

    public Position(Integer positionX, Integer positionY, String nickname, Boolean exist) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.nickname = nickname;
        this.exist = exist;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }
}
