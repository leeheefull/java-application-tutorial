package kr.ac.hs.se.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BusinessCard {

    private final int cardNo;
    private final String personName;
    private final String phoneNo;
    private final String companyName;

    @Override
    public String toString() {
        return cardNo + "\t\t" + personName + "\t" + phoneNo + "\t\t" + companyName;
    }
}
