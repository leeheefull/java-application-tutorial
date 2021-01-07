package kr.ac.hs.se.model;

import java.util.Set;

public interface Lotto {

	public static final int SIZE = 6;

	public abstract Set<Integer> getBasicNumbers();

	public abstract void setBasicNumbers();
}
