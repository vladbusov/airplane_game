package hello;

public class Position {
    private Integer positionX;
    private Integer positionY;
    private String nickname;
    private Boolean exist;
    private Integer degrees;

    Position() {
    }

    public Position(Integer positionX, Integer positionY, String nickname, Boolean exist, Integer degrees) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.nickname = nickname;
        this.exist = exist;
        this.degrees = degrees;
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

    public Integer getDegrees() {
        return degrees;
    }

    public void setDegrees(Integer degrees) {
        this.degrees = degrees;
    }
}
