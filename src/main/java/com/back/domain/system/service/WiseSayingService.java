package com.back.domain.system.service;

import com.back.AppContext;
import com.back.domain.system.repository.WiseSayingRepository;
import com.back.domain.wisesaying.entity.WiseSaying;
import java.util.List;

public class WiseSayingService {
    WiseSayingRepository repository;

    public WiseSayingService() {
        this.repository = AppContext.wiseSayingRepository;
    }

    public int enroll(String writer, String content) {
        return repository.enroll(new WiseSaying(writer, content));
    }

    public List<WiseSaying> findForList(String keywordType, String keyword, String page) {
        return repository.findForList(keywordType, keyword, page);
    }

    public WiseSaying findById(int id) {
        return repository.findById(id);
    }

    public boolean delete(int id) {
        WiseSaying wiseSaying = repository.findById(id);

        if ( wiseSaying == null ) return false;

        repository.delete(wiseSaying);

        return true;
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setWriter(author);

        repository.save(wiseSaying);
    }
}
