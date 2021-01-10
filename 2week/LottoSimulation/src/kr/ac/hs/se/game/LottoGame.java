package kr.ac.hs.se.game;

import java.util.ArrayList;
import java.util.List;

import kr.ac.hs.se.model.PurchasedLotto;
import kr.ac.hs.se.model.WinningLotto;
import kr.ac.hs.se.model.WinningRank;

public class LottoGame {

    private final List<PurchasedLotto> purchasedLottoList;
    private WinningLotto winningLotto;

    public LottoGame() {
        this.purchasedLottoList = new ArrayList<>();
        this.winningLotto = new WinningLotto();
    }

    public void clearLottoGame() {
        this.purchasedLottoList.clear();
        this.winningLotto.clear();
    }

    public List<PurchasedLotto> getPurchasedLottoList() {
        return this.purchasedLottoList;
    }

    public void addPurchasedLottoList(int numberOfLotto) {
        while (purchasedLottoList.size() < numberOfLotto) {
            this.purchasedLottoList.add(new PurchasedLotto());
        }
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public void createWinningLotto() {
        this.winningLotto = new WinningLotto();
    }

    public void setRankLottoList() {
        for (PurchasedLotto purchasedLotto : purchasedLottoList) {
            int cnt = 0;
            purchasedLotto.setWinningRank(WinningRank.OTHERS);
            for (Integer integer : this.winningLotto.getBasicNumbers()) {
                if (purchasedLotto.getBasicNumbers().contains(integer)) {
                    cnt++;
                    if (3 <= cnt) {
                        purchasedLotto.setWinningRank(purchasedLotto.getWinningRank().getNextRank());
                    }
                }
            }
            int bonusNumber = this.winningLotto.getBonusNumber();
            if (purchasedLotto.getWinningRank() == WinningRank.THREE && isWinningBonusNumber(purchasedLotto, bonusNumber)) {
                purchasedLotto.setWinningRank(WinningRank.TWO);
            }
        }
    }

    private boolean isWinningBonusNumber(PurchasedLotto purchasedLotto, int bonusNumber) {
        return purchasedLotto.getBasicNumbers().contains(bonusNumber);
    }
}