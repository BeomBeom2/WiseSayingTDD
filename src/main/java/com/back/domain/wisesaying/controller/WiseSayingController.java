package com.back.domain.wisesaying.controller;

import com.back.AppContext;
import com.back.domain.wisesaying.entity.WiseSaying;
import com.back.domain.system.service.WiseSayingService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Collections.emptyMap;

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

    public void actionPrint(String cmd) {
        Map<String, String> params = getParams(cmd);

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for(WiseSaying cur : service.findForList(params.getOrDefault("keywordType", "all"), params.getOrDefault("keyword", ""))){
            System.out.println(cur.getId() + " / " + cur.getWriter() + " / " + cur.getContent());
        }
    }

    public Map<String, String> getParams(String cmd) {
        String[] splits = cmd.split("\\?");
        if(splits.length < 2) return emptyMap();

        return Arrays
                .stream(splits[1].split("&"))
                .map(e -> e.split("=", 2))
                .filter(e -> e.length == 2 && !e[0].isBlank() && !e[1].isBlank() )
                .collect(Collectors.toMap(e -> e[0].trim(), e -> e[1].trim()));
    }

    public void actionDelete(String cmd) {
        Map<String, String> params = getParams(cmd);

        String delIdx = params.getOrDefault("id", "");
        if(delIdx.isEmpty()) return;
        boolean isSuccess = service.delete(Integer.parseInt(delIdx));

        if(isSuccess)
            System.out.printf("%s번 명언이 삭제되었습니다.\n", delIdx);
        else
            System.out.printf("%s번 명언은 존재하지 않습니다.\n", delIdx);
    }

    public void actionModify(String cmd) {
        Map<String, String> params = getParams(cmd);

        String idStr = params.getOrDefault("id", "");
        int id = Integer.parseInt(idStr);

        WiseSaying wiseSaying = service.findById(id);

        if ( wiseSaying == null ) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n",  wiseSaying.getContent());
        System.out.printf("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가(기존) : %s\n",  wiseSaying.getWriter());
        System.out.printf("작가 : ");
        String author = sc.nextLine();

        service.modify(wiseSaying, content, author);
    }
}
