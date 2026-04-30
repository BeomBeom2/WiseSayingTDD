package com.back.domain.wisesaying.controller;

import com.back.AppContext;
import com.back.domain.wisesaying.entity.WiseSaying;
import com.back.domain.system.service.WiseSayingService;

import java.util.Scanner;

public class WiseSayingController {
    WiseSayingService service = new WiseSayingService();
    Scanner sc;

    public WiseSayingController() {
        this.sc = AppContext.scanner;
        this.service = AppContext.wiseSayingService;
    }

    public void actionEnroll() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String writer = sc.nextLine().trim();
        int idx = service.enroll(writer, content);

        System.out.println(idx + "번 명언이 등록되었습니다.");

    }

    public void actionPrint() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for(WiseSaying cur : service.findForList()){
            System.out.println(cur.getId() + " / " + cur.getWriter() + " / " + cur.getContent());
        }
    }
}
