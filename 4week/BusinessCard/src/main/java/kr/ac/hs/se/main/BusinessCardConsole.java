package kr.ac.hs.se.main;

import kr.ac.hs.se.controller.BusinessCardController;

public class BusinessCardConsole {

    public static void main(String[] args) {
        BusinessCardController.getInstance().run();
    }
}
