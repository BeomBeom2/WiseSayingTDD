package com.back;

import com.back.domain.SystemController;
import com.back.domain.WiseSayingController;

import java.util.Scanner;

public class App {
    Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        WiseSayingController wiseSayingController = new WiseSayingController(this.sc);
        SystemController systemController = new SystemController();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) {
                systemController.actionExit();
                return;
            } else if (cmd.equals("등록")) {
                wiseSayingController.actionEnroll();
            } else if (cmd.equals("목록")) {
                wiseSayingController.actionPrint();
            }
        }
    }
}
