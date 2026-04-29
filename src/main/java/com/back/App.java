package com.back;

import java.util.Scanner;

public class App {
    Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        int idx = 0;
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            if(cmd.equals("종료")){
                return;
            } else if(cmd.equals("등록")){
                System.out.print("명언 : ");
                String content = sc.nextLine().trim();
                System.out.print("작가 : ");
                String writer = sc.nextLine().trim();
                idx++;
                System.out.println(idx + "번 명언이 등록되었습니다.");
            }
        }
    }
}
