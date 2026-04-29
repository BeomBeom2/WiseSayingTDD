package com.back.domain.system.repository;

import com.back.domain.wisesaying.entity.WiseSaying;
import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private final List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public int enroll(WiseSaying wiseSaying) {
        wiseSaying.setId(++lastId);

        wiseSayings.add(wiseSaying);

        return lastId;
    }

    public List<WiseSaying> findForList() {
        return wiseSayings.reversed();
    }
}