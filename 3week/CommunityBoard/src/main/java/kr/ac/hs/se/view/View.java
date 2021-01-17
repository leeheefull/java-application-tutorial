package kr.ac.hs.se.view;

import java.io.PrintStream;

public interface View {

    PrintStream out = new PrintStream(System.out);

    void showMenu();
}
