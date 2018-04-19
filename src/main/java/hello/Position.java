package hello;

public class Position {
    private Integer positionX;
    private Integer positionY;
    private String nickname;

    Position() {
    }

    public Position(Integer positionX, Integer positionY, String nickname) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.nickname = nickname;
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
}
