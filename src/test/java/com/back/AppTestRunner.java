package com.back;

import com.back.standard.util.TestUtil;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String str) {
        Scanner scanner = TestUtil.genScanner(str + "\n종료");

        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        new App(scanner).run();

        return output.toString();
    }
}
