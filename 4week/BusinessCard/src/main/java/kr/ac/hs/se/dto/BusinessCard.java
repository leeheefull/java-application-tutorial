package kr.ac.hs.se.dto;

import lombok.*;

@Getter
public class BusinessCard {

    private final int cardNo;
    private final String personName;
    private final String phoneNo;
    private final String companyName;

    private BusinessCard(BusinessCardBuilder builder) {
        this.cardNo = builder.cardNo;
        this.personName = builder.personName;
        this.phoneNo = builder.phoneNo;
        this.companyName = builder.companyName;
    }

    @Override
    public String toString() {
        return cardNo + "\t\t" + personName + "\t" + phoneNo + "\t\t" + companyName;
    }

    public static class BusinessCardBuilder {

        private final int cardNo;
        private String personName;
        private String phoneNo;
        private String companyName;

        public BusinessCardBuilder(int cardNo) {
            this.cardNo = cardNo;
        }

        public BusinessCardBuilder setPersonName(String personName) {
            this.personName = personName;
            return this;
        }

        public BusinessCardBuilder setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public BusinessCardBuilder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public BusinessCard build() {
            return new BusinessCard(this);
        }
    }
}
