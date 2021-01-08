package kr.ac.hs.se.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.sun.jdi.IntegerType;
import kr.ac.hs.se.model.PurchasedLotto;
import kr.ac.hs.se.model.WinningLotto;
import kr.ac.hs.se.model.WinningResult;

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
            setRank(purchasedLotto);
        }
    }

    private void setRank(PurchasedLotto purchasedLotto) {
        purchasedLotto.setWinningResult(WinningResult.EIGHT);
        for (Integer integer : this.winningLotto.getBasicNumbers()) {
            if (purchasedLotto.getBasicNumbers().contains(integer)) {
                purchasedLotto.setWinningResult(purchasedLotto.getWinningResult().getNextRank());
            }
        }
        int bonusNumber = this.winningLotto.getBonusNumber();
        if (purchasedLotto.getWinningResult().getRank() == 2 && isWinningBonusNumber(purchasedLotto, bonusNumber)) {
            purchasedLotto.setWinningResult(WinningResult.TWO);
        }
    }

    private boolean isWinningBonusNumber(PurchasedLotto purchasedLotto, int bonusNumber) {
        return purchasedLotto.getBasicNumbers().contains(bonusNumber);
    }
}