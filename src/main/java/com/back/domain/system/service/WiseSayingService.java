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

    public List<WiseSaying> findForList() {
        return repository.findForList();
    }

    public boolean delete(int id) {
        WiseSaying wiseSaying = repository.findById(id);

        if ( wiseSaying == null ) return false;

        repository.delete(wiseSaying);

        return true;
    }
}
