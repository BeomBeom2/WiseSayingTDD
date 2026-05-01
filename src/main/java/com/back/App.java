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
        WiseSayingController wiseSayingController = AppContext.wiseSayingController;
        SystemController systemController = AppContext.systemController;

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            String actionName = cmd.split("\\?", 2)[0];

            if (actionName.equals("종료")) {
                systemController.actionExit();
                return;
            } else if (actionName.equals("등록")) {
                wiseSayingController.actionEnroll();
            } else if (actionName.equals("목록")) {
                wiseSayingController.actionPrint(cmd);
            } else if(actionName.equals("삭제")) {
                wiseSayingController.actionDelete(cmd);
            } else if(actionName.equals("수정")) {
                wiseSayingController.actionModify(cmd);
            }
        }
    }
}
