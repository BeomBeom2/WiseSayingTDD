package com.back;

import com.back.domain.system.controller.SystemController;
import com.back.domain.wisesaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner sc;

    public App() {
        Scanner sc1;
        sc1 = AppContext.scanner;
        this.sc = sc1;
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
