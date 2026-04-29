package com.back.domain.system.service;

import com.back.domain.system.repository.WiseSayingRepository;
import com.back.domain.wisesaying.entity.WiseSaying;
import java.util.List;

public class WiseSayingService {
    WiseSayingRepository repository;

    public WiseSayingService() {
        this.repository = new WiseSayingRepository();
    }

    public int enroll(String writer, String content) {
        return repository.enroll(new WiseSaying(writer, content));
    }

    public List<WiseSaying> findForList() {
        return repository.findForList();
    }
}
