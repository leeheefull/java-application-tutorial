package kr.ac.hs.se.service;

import kr.ac.hs.se.dao.BusinessCardDao;
import kr.ac.hs.se.dto.BusinessCard;
import lombok.AllArgsConstructor;

import java.util.List;

public class BusinessCardService {

    private static BusinessCardService businessCardService;
    private final BusinessCardDao businessCardDao = BusinessCardDao.getInstance();

    public static BusinessCardService getInstance() {
        if (businessCardService == null) {
            businessCardService = new BusinessCardService();
        }
        return businessCardService;
    }

    public void createBusinessCard(String personName, String phoneNo, String companyName) {
        businessCardDao.insertBusinessCard(personName, phoneNo, companyName);
    }

    public BusinessCard searchBusinessCard(int selectedNo) {
        return businessCardDao.selectBusinessCard(selectedNo);
    }

    public void removeBusinessCard(int cardNo) {
        businessCardDao.deleteBusiness(cardNo);
    }

    public void updateBusinessCard(int cardNo, String personName, String phoneNo, String companyName) {
        businessCardDao.updateBusinessCard(cardNo, personName, phoneNo, companyName);
    }

    public List<BusinessCard> getBusinessCards() {
        return businessCardDao.selectBusinessCards();
    }
}
