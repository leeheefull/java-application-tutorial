package kr.ac.hs.se.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr.ac.hs.se.model.PurchasedLotto;
import kr.ac.hs.se.model.WinningLotto;

public class LottoGame {

	private final List<PurchasedLotto> purchasedLottoList;
	private final WinningLotto winningLotto;

	public LottoGame() {
		this.purchasedLottoList = new ArrayList<>();
		this.winningLotto = new WinningLotto();
	}

	public WinningLotto getWinningLotto() {
		return winningLotto;
	}

	public List<PurchasedLotto> getPurchasedLottoList() {
		return this.purchasedLottoList;
	}

	// 시뮬래이션 할 복권 리스트의 setter
	public void setPurchasedLottoList(int numberOfLotto) {
		while (purchasedLottoList.size() < numberOfLotto) {
			this.purchasedLottoList.add(new PurchasedLotto());
		}
	}

	// 각 시뮬레이션 로또들의 결과를 set
	public void setLottoListResult() {
		for (PurchasedLotto purchasedLotto : purchasedLottoList) {
			int rank = getRanking(purchasedLotto);
			if (5 < rank) {
				purchasedLotto.setResult("낙첨");
			} else {
				purchasedLotto.setResult(rank + "등");
			}
		}
	}

	// 시뮬레이션할 복권 리스트의 등수
	private int getRanking(PurchasedLotto purchasedLotto) {
		int cnt = 0;
		// 구매된 로또와 당첨 로또가 같으면, 1등
		if (purchasedLotto.getBasicNumbers().containsAll(this.winningLotto.getBasicNumbers())) {
			return 1;
		}
		// 구매된 로또와 당첨 로또가 5개로 같으면서 보너스 번호를 갖고 있다면, 2등
		int bonusNumber = this.winningLotto.getBonusNumber();
		if (cnt == 5 && isWinningBonusNumber(purchasedLotto, bonusNumber)) {
			return 2;
		}
		// 구매된 로또와 당첨 로또 중에서 같은 개수가 몇개 인지
		Iterator<Integer> winningBasicNumber = this.winningLotto.getBasicNumbers().iterator();
		while (winningBasicNumber.hasNext()) {
			if (purchasedLotto.getBasicNumbers().contains(winningBasicNumber.next())) {
				cnt++;
			}
		}
		// 3등 ~ 8등 까지 반환
		return 8 - cnt;
	}

	// 보너스 번호가 일치하는지
	private boolean isWinningBonusNumber(PurchasedLotto purchasedLotto, int bonusNumber) {
		return purchasedLotto.getBasicNumbers().contains(bonusNumber);
	}
}
