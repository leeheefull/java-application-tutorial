package kr.ac.hs.se.controller;

import java.io.BufferedReader;
import java.io.IOException;

public interface Controller {

    String inputMenu(BufferedReader br) throws IOException;
}
