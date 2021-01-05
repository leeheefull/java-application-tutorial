package kr.ac.hs.se.module;

import java.util.ArrayList;
import java.util.List;

import kr.ac.hs.se.model.PurchasedLotto;
import kr.ac.hs.se.model.WinningLotto;

public class LottoModule {

	private List<PurchasedLotto> purchasedLottoList;
	private WinningLotto winningLotto;

	public LottoModule() {
		this.purchasedLottoList = new ArrayList<>();
		this.winningLotto = new WinningLotto();
	}

	public List<PurchasedLotto> getPurchasedLottoList() {
		return this.purchasedLottoList;
	}

	public void setPurchasedLottoList(int n) {
		for (int i = 0; i < n; i++) {
			this.purchasedLottoList.add(new PurchasedLotto());
		}
	}

	public int whatIsRanking(PurchasedLotto purchasedLotto) {
		int cnt = 0;
		// 구매된 로또와 당첨 로또가 같으면, 1등
		if (purchasedLotto.getNumbers().containsAll(this.winningLotto.getNumbers())) {
			return 1;
		}
		// 구매된 로또와 당첨 로또가 5개 같으면서 보너스 번호를 갖고 있다면, 2등
		int bonusNumber = this.winningLotto.getBonusNumber();
		if (cnt == 5 && isWinningBonusNumber(purchasedLotto, bonusNumber)) {
			return 2;
		}
		// 구매된 로또와 당첨 로또 중에서 같은 개수가 몇개 인지
		for (int i = 0; i < this.winningLotto.getNumbers().size(); i++) {
			if (purchasedLotto.getNumbers().contains(this.winningLotto.getNumbers().get(i))) {
				cnt++;
			}
		}
		// 3등 ~ 8등 까지 반환
		return 8 - cnt;
	}

	private boolean isWinningBonusNumber(PurchasedLotto purchasedLotto, int bonusNumber) {
		if (purchasedLotto.getNumbers().contains(bonusNumber)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String outputStr = "";
		// 당첨 번호 출력
		outputStr += winningLotto;
		// 구매된 로또 리스트 출력
		for (PurchasedLotto purchasedLotto : purchasedLottoList) {
			int rank = whatIsRanking(purchasedLotto);
			if (5 < rank) {
				outputStr += purchasedLotto + "-> 낙첨\n";
			} else {
				outputStr += purchasedLotto + "-> " + rank + "\n";
			}
		}
		return outputStr;
	}
}
