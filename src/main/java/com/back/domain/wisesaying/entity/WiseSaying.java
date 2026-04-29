package com.back.domain.wisesaying.entity;

public class WiseSaying {
    private int id;
    private String writer;
    private String content;

    public WiseSaying(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
