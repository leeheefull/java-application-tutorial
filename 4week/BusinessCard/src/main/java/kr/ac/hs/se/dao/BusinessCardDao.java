package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.BusinessCard;
import kr.ac.hs.se.util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessCardDao {

    public void insertBusinessCard(String personName, String phoneNo, String companyName) {
        String sql = "INSERT INTO business_card(person_name, phone_no, company_name) VALUES(?, ?, ?)";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, personName);
            ps.setString(2, phoneNo);
            ps.setString(3, companyName);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public BusinessCard selectBusinessCard(int cardNo) {
        BusinessCard businessCard = null;
        ResultSet rs = null;
        String sql = "SELECT card_no, person_name, phone_no, company_name FROM business_card WHERE card_no = ?";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, cardNo);
            rs = ps.executeQuery();

            if (rs.next()) {
                int cardNo_ = rs.getInt(1);
                String personName_ = rs.getString(2);
                String phoneNo_ = rs.getString(3);
                String companyName_ = rs.getString(4);

                businessCard = BusinessCard.getInstance(cardNo_, personName_, phoneNo_, companyName_);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException();
                }
            }
        }
        return businessCard;
    }
}
