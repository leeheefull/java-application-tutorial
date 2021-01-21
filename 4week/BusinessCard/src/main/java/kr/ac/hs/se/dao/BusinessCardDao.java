package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.BusinessCard;
import kr.ac.hs.se.util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessCardDao {

    public void insertBusinessCard(BusinessCard businessCard) {
        String sql = "INSERT INTO business_card(name, phone_no, company_name) VALUES(?, ?, ?)";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, businessCard.getName());
            ps.setString(2, businessCard.getPhoneNo());
            ps.setString(3, businessCard.getCompanyName());

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BusinessCard selectBusinessCard(String selectedName) {
        BusinessCard businessCard = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM business_card WHERE name = ?";

        try (
                Connection con = DBConnector.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, selectedName);
            rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString(2);
                String phoneNo = rs.getString(3);
                String companyName = rs.getString(4);

                businessCard = new BusinessCard(name, phoneNo, companyName);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return businessCard;
    }
}
