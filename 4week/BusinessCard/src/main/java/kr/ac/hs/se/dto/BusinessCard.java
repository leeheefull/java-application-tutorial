package kr.ac.hs.se.dto;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusinessCard {

    private int cardNo;
    @NonNull
    private String personName;
    @NonNull
    private String phoneNo;
    @NonNull
    private String companyName;

    private static BusinessCard businessCard = new BusinessCard();

    public static BusinessCard getInstance(int cardNo, String personName, String phoneNo, String companyName) {
        businessCard.setCardNo(cardNo);
        businessCard.setPersonName(personName);
        businessCard.setPhoneNo(phoneNo);
        businessCard.setCompanyName(companyName);
        return businessCard;
    }

    @Override
    public String toString() {
        return cardNo + "\t\t" + personName + "\t" + phoneNo + "\t\t" + companyName;
    }
}
