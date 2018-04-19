package hello;

public class Greeting {

    private String content;
    // модель приветствия, конструктор приветствия
    public Greeting() {
    }
    // конструктор по строке
    public Greeting(String content) {
        this.content = content;
    }
    // гетер
    public String getContent() {
        return content;
    }

}
