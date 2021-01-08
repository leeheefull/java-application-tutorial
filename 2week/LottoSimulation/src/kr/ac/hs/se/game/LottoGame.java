package kr.ac.hs.se.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.sun.jdi.IntegerType;
import kr.ac.hs.se.model.PurchasedLotto;
import kr.ac.hs.se.model.WinningLotto;

public class LottoGame {

    private final List<PurchasedLotto> purchasedLottoList;
    private WinningLotto winningLotto;

    public LottoGame() {
        this.purchasedLottoList = new ArrayList<>();
        this.winningLotto = new WinningLotto();
    }

    public void clearLottoGame() {
        for (PurchasedLotto purchasedLotto : purchasedLottoList) {
            purchasedLotto.clear();
        }
        this.purchasedLottoList.clear();
        this.winningLotto.clear();
    }

    public List<PurchasedLotto> getPurchasedLottoList() {
        return this.purchasedLottoList;
    }

    public void setPurchasedLottoList(int numberOfLotto) {
        while (purchasedLottoList.size() < numberOfLotto) {
            this.purchasedLottoList.add(new PurchasedLotto());
        }
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public void setWinningLotto() {
        this.winningLotto = new WinningLotto();
    }

    public void setLottoListResult() {
        for (PurchasedLotto purchasedLotto : purchasedLottoList) {
            int rank = getRank(purchasedLotto);
            if (rank <= 5) {
                purchasedLotto.setWinningResult(rank + "등");
            } else {
                purchasedLotto.setWinningResult("낙첨");
            }
        }
    }

    private int getRank(PurchasedLotto purchasedLotto) {
        int cnt = 0;
        for (Integer integer : this.winningLotto.getBasicNumbers()) {
            if (purchasedLotto.getBasicNumbers().contains(integer)) {
                cnt++;
            }
        }
        if (purchasedLotto.getBasicNumbers().containsAll(this.winningLotto.getBasicNumbers())) {
            return 1;
        }
        int bonusNumber = this.winningLotto.getBonusNumber();
        if (cnt == 5 && isWinningBonusNumber(purchasedLotto, bonusNumber)) {
            return 2;
        }
        return 8 - cnt;
    }

    private boolean isWinningBonusNumber(PurchasedLotto purchasedLotto, int bonusNumber) {
        return purchasedLotto.getBasicNumbers().contains(bonusNumber);
    }
}
