package kr.ac.hs.se.model;

import java.util.Set;

public interface Lotto {

    int SIZE = 6;

    void clear();

    Set<Integer> getBasicNumbers();

    void setBasicNumbers();
}