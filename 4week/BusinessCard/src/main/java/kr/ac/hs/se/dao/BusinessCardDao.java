package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.BusinessCard;
import kr.ac.hs.se.util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardDao {

    private static BusinessCardDao businessCardDao;

    private BusinessCardDao() {
    }

    public static synchronized BusinessCardDao getInstance() {
        if (businessCardDao == null) {
            businessCardDao = new BusinessCardDao();
        }
        return businessCardDao;
    }

    public void insertBusinessCard(BusinessCard businessCard) {
        String sql = "INSERT INTO business_card(person_name, phone_no, company_name) VALUES(?, ?, ?)";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, businessCard.getPersonName());
            ps.setString(2, businessCard.getPhoneNo());
            ps.setString(3, businessCard.getCompanyName());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BusinessCard> searchedBusinessCard(String searchedName) {
        String sql = "SELECT card_no, person_name, phone_no, company_name FROM business_card WHERE person_name = ?";
        List<BusinessCard> businessCardList = new ArrayList<>();

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, searchedName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int cardNo = rs.getInt("CARD_NO");
                    String personName = rs.getString("PERSON_NAME");
                    String phoneNo = rs.getString("PHONE_NO");
                    String companyName = rs.getString("COMPANY_NAME");

                    BusinessCard businessCard = BusinessCard.builder()
                            .cardNo(cardNo)
                            .personName(personName)
                            .phoneNo(phoneNo)
                            .companyName(companyName)
                            .build();

                    businessCardList.add(businessCard);
                }
                return businessCardList;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBusiness(int cardNo) {
        String sql = "DELETE FROM business_card WHERE card_no = ?";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, cardNo);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBusinessCard(BusinessCard businessCard) {
        String sql = "UPDATE business_card SET person_name = ?, phone_no = ?, company_name = ? WHERE card_no = ?";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, businessCard.getPersonName());
            ps.setString(2, businessCard.getPhoneNo());
            ps.setString(3, businessCard.getCompanyName());
            ps.setInt(4, businessCard.getCardNo());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BusinessCard> selectBusinessCards(int limit, int offset) {
        String sql = "select card_no, person_name, phone_no, company_name FROM(SELECT * FROM business_card ORDER BY card_no) PAGE LIMIT ? OFFSET ?";
        List<BusinessCard> businessCardList = new ArrayList<>();

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int cardNo = rs.getInt("CARD_NO");
                    String personName = rs.getString("PERSON_NAME");
                    String phoneNo = rs.getString("PHONE_NO");
                    String companyName = rs.getString("COMPANY_NAME");

                    BusinessCard businessCard = BusinessCard.builder()
                            .cardNo(cardNo)
                            .personName(personName)
                            .phoneNo(phoneNo)
                            .companyName(companyName)
                            .build();

                    businessCardList.add(businessCard);
                }
                return businessCardList;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
