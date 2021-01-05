package kr.ac.hs.se.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import kr.ac.hs.se.module.LottoModule;
import kr.ac.hs.se.view.LottoView;

public class LottoController {

	LottoModule lottoService;
	LottoView view;

	public LottoController() {
		lottoService = new LottoModule();
		view = new LottoView();
	}

	public void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			view.showProgramTitle();
			createLotto(br);
			view.showLottoList(lottoService);
		} catch (Exception e) {
			view.showErrorMassage();
			e.printStackTrace();
		}
	}

	private void createLotto(BufferedReader br) throws NumberFormatException, IOException {
		view.showInput();
		int numberOfLotto = Integer.parseInt(br.readLine());
		lottoService.setPurchasedLottoList(numberOfLotto);
	}
}