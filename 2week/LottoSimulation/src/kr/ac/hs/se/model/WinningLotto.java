package kr.ac.hs.se.model;

import java.util.Set;
import java.util.TreeSet;

public class WinningLotto implements Lotto {

	private Set<Integer> basicNumbers;
	private int bonusNumber;

	public WinningLotto() {
		this.basicNumbers = new TreeSet<>();
		this.setBasicNumbers();
		this.setBonusNumber();
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

	public int getBonusNumber() {
		return this.bonusNumber;
	}

	// 기본 번호와 중복되지 않게 set
	public void setBonusNumber() {
		int tmp = (int) (Math.random() * 42) + 1;
		while (this.basicNumbers.contains(tmp)) {
			tmp = (int) (Math.random() * 42) + 1;
		}
		this.bonusNumber = tmp;
	}

	// 당첨 번호 한 줄 출력
	@Override
	public String toString() {
		String outputStr = "";
		for (int number : basicNumbers) {
			outputStr += number + "\t";
		}
		return outputStr + "+ " + this.bonusNumber;
	}
}
