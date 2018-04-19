package hello;

public class Message {
    // сообщение
    private String message;
    private String name;
    // конструктор по умолчанию
    public Message() {
    }
    // конструктор со строкой
    public Message(String name, String message) {
        this.message = message;
        this.name = name;
    }
    // получение строки
    public String getName() {
        return name;
    }
    public String getMessage() {
        return message;
    }

    // установка строки
    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
