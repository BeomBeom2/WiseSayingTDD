package com.back.domain.wisesaying.controller;

import com.back.AppContext;
import com.back.domain.wisesaying.entity.WiseSaying;
import com.back.domain.system.service.WiseSayingService;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WiseSayingController {
    final WiseSayingService  service;
    final Scanner sc;

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

    public void actionDelete(String cmd) {
        String[] splits = cmd.split("\\?");
        if(splits.length < 2) return;

        Map<String, String> params = Arrays
                .stream(splits[1].split("&"))
                .map(e -> e.split("=", 2))
                .filter(e -> e.length == 2 && !e[0].isBlank() && !e[1].isBlank() )
                .collect(Collectors.toMap(e -> e[0].trim(), e -> e[1].trim()));

        String delIdx = params.getOrDefault("id", "");
        if(delIdx.isEmpty()) return;
        boolean isSuccess = service.delete(Integer.parseInt(delIdx));

        if(isSuccess)
            System.out.printf("%s번 명언이 삭제되었습니다.\n", delIdx);
        else
            System.out.printf("%s번 명언은 존재하지 않습니다.\n", delIdx);
    }
}
