package kr.ac.hs.se.service;

import kr.ac.hs.se.dao.BusinessCardDao;
import kr.ac.hs.se.dto.BusinessCard;

import java.util.ArrayList;
import java.util.List;

public class BusinessCardService {

    private static BusinessCardService businessCardService;
    private final BusinessCardDao businessCardDao = BusinessCardDao.getInstance();

    private BusinessCardService() {
    }

    public static synchronized BusinessCardService getInstance() {
        if (businessCardService == null) {
            businessCardService = new BusinessCardService();
        }
        return businessCardService;
    }

    public void createBusinessCard(String personName, String phoneNo, String companyName) {
        BusinessCard businessCard = BusinessCard.builder()
                .personName(personName)
                .phoneNo(phoneNo)
                .companyName(companyName)
                .build();
        businessCardDao.insertBusinessCard(businessCard);
    }

    public List<BusinessCard> searchBusinessCard(String searchedName) {
        return new ArrayList<>(businessCardDao.searchedBusinessCard(searchedName));
    }

    public void removeBusinessCard(int cardNo) {
        businessCardDao.deleteBusiness(cardNo);
    }

    public void updateBusinessCard(int cardNo, String personName, String phoneNo, String companyName) {
        BusinessCard businessCard = BusinessCard.builder()
                .cardNo(cardNo)
                .personName(personName)
                .phoneNo(phoneNo)
                .companyName(companyName)
                .build();
        businessCardDao.updateBusinessCard(businessCard);
    }

    public List<BusinessCard> getBusinessCardByPage(int pageSize, int page) {
        int offset = pageSize * (page - 1);
        return new ArrayList<>(businessCardDao.selectBusinessCards(pageSize, offset));
    }
}
