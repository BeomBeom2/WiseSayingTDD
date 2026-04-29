package com.back.domain.entity;

public class WiseSaying {
    private int id;
    private String writer;
    private String content;

    public WiseSaying(int id, String writer, String content) {
        this.id = id;
        this.writer = writer;
        this.content = content;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
