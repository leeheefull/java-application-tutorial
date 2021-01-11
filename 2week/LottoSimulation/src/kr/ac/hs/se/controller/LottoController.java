package kr.ac.hs.se.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import kr.ac.hs.se.game.LottoGame;
import kr.ac.hs.se.view.LottoView;

import static kr.ac.hs.se.util.LottoConstants.Menu.*;

public class LottoController {

    private final LottoGame lottoGame;
    private final LottoView view;

    public LottoController() {
        lottoGame = new LottoGame();
        view = new LottoView();
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                view.showProgramTitle();
                String menu = inputMenu(br);

                if (menu.equals(START)) {
                    int numberOfLotto = inputNumber(br);
                    start(numberOfLotto);

                    view.winningLineBreak();
                    view.showWinningLotto(lottoGame.getWinningLotto());

                    view.purchasedLottoListLineBreak();
                    showLottoResult();
                    view.lineBreak();

                    lottoGame.clearLottoGame();
                } else if (menu.equals(END)) {
                    lottoGame.clearLottoGame();
                    view.lineBreak();
                    return;
                } else {
                    view.showErrorMassage();
                }
            }
        } catch (Exception e) {
            view.showErrorMassage();
            e.printStackTrace();
        }
    }

    private String inputMenu(BufferedReader br) throws IOException {
        view.showMenu();
        return br.readLine();
    }

    private int inputNumber(BufferedReader br) throws IOException {
        view.inputNumberOfLotto();
        return Integer.parseInt(br.readLine());
    }

    private void start(int numberOfLotto) {
        lottoGame.createWinningLotto();
        lottoGame.addPurchasedLottoList(numberOfLotto);
    }

    private void showLottoResult() {
        lottoGame.setRankLottoList();
        view.showPurchasedLottoList(lottoGame.getPurchasedLottoList());
    }
}