package com.back.domain.system.repository;

import com.back.domain.wisesaying.entity.WiseSaying;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;

public class WiseSayingRepository {
    private final List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public int enroll(WiseSaying wiseSaying) {
        wiseSaying.setId(++lastId);

        wiseSayings.add(wiseSaying);

        return lastId;
    }

    public int findIndexById(int id ) {
        return IntStream
                .range(0, wiseSayings.size())
                .filter(i -> wiseSayings.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }

    public WiseSaying findById(int id) {
        int index = findIndexById(id);
        if(index == -1) return null;

        return wiseSayings.get(index);
    }

    public List<WiseSaying> findForList(String keywordType, String keyword) {
        if(keywordType.equals("all"))
            return wiseSayings.reversed();
        else if(keywordType.equals("author")) {
            return wiseSayings
                    .stream()
                    .filter(e -> e.getWriter().contains(keyword))
                    .toList();
        }  else if(keywordType.equals("content")) {
            return wiseSayings
                    .stream()
                    .filter(e -> e.getContent().contains(keyword))
                    .toList();
        } else {
            return emptyList();
        }
    }

    public void delete(WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);
    }

    public void save(WiseSaying wiseSaying) {
        if(wiseSaying.isNew()){
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }
    }
}