package com.back.domain.system.service;

import com.back.domain.entity.WiseSaying;
import java.util.ArrayList;

public class WiseSayingService {
    int idx = 0;
    ArrayList<WiseSaying> list = new ArrayList<>();
    public int enroll(String writer, String content) {
        list.add(new WiseSaying(++idx, writer, content));
        return idx;
    }

    public ArrayList<WiseSaying> findForList() {
        return list;
    }
}
