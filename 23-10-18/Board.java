package ch15.sec02;

// Board 클래스(ArrayListExample의 제네릭에 활용)

public class Board {
    // 필드 선언
    // private 접근 제한자를 사용하였으므로 getter(), setter()를 통해서만 접근 가능
    private String subject;
    private String content;
    private String writer;

    public Board(String subject, String content, String writer) {
        this.subject = subject;
        this.content = content;
        this.writer = writer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
