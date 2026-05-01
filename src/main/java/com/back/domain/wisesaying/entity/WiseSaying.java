package com.back.domain.wisesaying.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WiseSaying {
    private int id;
    private String writer;
    private String content;

    public WiseSaying(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }
    public boolean isNew() {
        return id ==0;
    }
}
