package kr.ac.hs.se.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import kr.ac.hs.se.game.LottoGame;
import kr.ac.hs.se.view.LottoView;

public class LottoController {

	private final LottoGame lottoGame;
	private final LottoView view;

	public LottoController() {
		lottoGame = new LottoGame();
		view = new LottoView();
	}

	public void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			createLotto(br);
			showGame();
		} catch (Exception e) {
			view.showErrorMassage();
			e.printStackTrace();
		}
	}

	private void createLotto(BufferedReader br) throws NumberFormatException, IOException {
		view.showProgramTitle();
		view.showInput();
		int numberOfLotto = Integer.parseInt(br.readLine());
		lottoGame.setPurchasedLottoList(numberOfLotto);
	}

	private void showGame() {
		view.winningLineBreak();
		view.showWinningLotto(lottoGame.getWinningLotto());
		view.purchasedLottoListLineBreak();
		showLottosResult();
		view.lineBreak();
	}

	// 시뮬레이션 된 로또 복권들의 결과를 보여주는 메소드
	private void showLottosResult() {
		lottoGame.setLottoListResult();
		for (int i = 0; i < lottoGame.getPurchasedLottoList().size(); i++) {
			view.showPurchasedLotto(lottoGame.getPurchasedLottoList().get(i));
		}
	}
}