package kr.ac.hs.se.model;

import java.util.Set;
import java.util.TreeSet;

public class PurchasedLotto implements Lotto {

	private Set<Integer> basicNumbers;
	private String winningResult;

	public PurchasedLotto() {
		this.basicNumbers = new TreeSet<>();
		this.setBasicNumbers();
	}

	@Override
	public Set<Integer> getBasicNumbers() {
		return this.basicNumbers;
	}

	// 기본 번호의 개수가 6이 될 때까지, 반복
	@Override
	public void setBasicNumbers() {
		while (this.basicNumbers.size() < SIZE) {
			int tmp = (int) (Math.random() * 42) + 1;
			this.basicNumbers.add(tmp);
		}
	}

	public String getResult() {
		return winningResult;
	}

	public void setResult(String winningResult) {
		this.winningResult = winningResult;
	}

	// 기본 번호 한 줄 출력
	@Override
	public String toString() {
		String outputStr = "";
		for (int number : this.basicNumbers) {
			outputStr += number + "\t";
		}
		return outputStr + this.winningResult;
	}
}