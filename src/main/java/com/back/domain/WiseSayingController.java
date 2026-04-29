package com.back.domain;

import com.back.domain.entity.WiseSaying;

import java.util.ArrayList;
import java.util.Scanner;

public class WiseSayingController {
    Scanner sc;
    int idx = 0;
    ArrayList<WiseSaying> list = new ArrayList<>();

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
    }

    public void actionEnroll() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String writer = sc.nextLine().trim();
        idx++;
        list.add(new WiseSaying(idx, writer, content));
        System.out.println(idx + "번 명언이 등록되었습니다.");

    }

    public void actionPrint() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        list.reversed().forEach(obj -> System.out.println(obj.getId() + " / " + obj.getWriter() + " / " + obj.getContent()));
    }
}
