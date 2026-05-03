package com.back.domain.system.repository;

import com.back.domain.standard.dto.Pageable;
import com.back.domain.wisesaying.entity.WiseSaying;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;

public class WiseSayingRepository {
    private final List<WiseSaying> wiseSayings = new ArrayList<>();
    private final Pageable  page = new Pageable(1, 5);
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

    public List<WiseSaying> findForList(String keywordType, String keyword, String pageStr) {

        int p = pageStr.isEmpty() ? 1 : Integer.parseInt(pageStr);
        if (p < 1) page.setPage(1);
        else page.setPage(p);

        List<WiseSaying> filtered = wiseSayings.reversed().stream()
                .filter(e -> {
                    if (keywordType.equals("all")) {
                        if (keyword.isEmpty()) return true;
                        return e.getWriter().contains(keyword) || e.getContent().contains(keyword);
                    } else if (keywordType.equals("author")) {
                        return e.getWriter().contains(keyword);
                    } else if (keywordType.equals("content")) {
                        return e.getContent().contains(keyword);
                    }
                    return false;
                })
                .toList();

        if (page.getSkipCount() >= filtered.size()) {
            return List.of();
        }

        int toIndex = Math.min(page.getSkipCount() + page.getPageSize(), filtered.size());

        return filtered.subList(page.getSkipCount() , toIndex);
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