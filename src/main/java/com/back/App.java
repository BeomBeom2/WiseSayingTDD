package com.back;

import java.util.Scanner;

public class App {
    Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        String cmd = sc.nextLine().trim();
        while(true) {
            if(cmd.equals("종료")){
                return;
            }
        }
    }
}
