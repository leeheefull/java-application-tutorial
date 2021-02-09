package kr.ac.hs.se.vo;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ReservationInfo {
    private int id;
    private int productId;
    private int displayInfoId;
    private int userId;
    private Date reservationDate;
    private boolean cancelFlag;
    private Date createDate;
    private Date modifyDate;
}
