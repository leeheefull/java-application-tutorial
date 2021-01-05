package kr.ac.hs.se.controller;

import java.util.Scanner;

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
		try (Scanner scan = new Scanner(System.in)) {
			int numberOfLotto = scan.nextInt();
			lottoService.setPurchasedLottoList(numberOfLotto);
			view.show(lottoService);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
