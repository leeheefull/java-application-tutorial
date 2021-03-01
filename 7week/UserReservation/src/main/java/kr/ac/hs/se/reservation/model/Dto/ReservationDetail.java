package kr.ac.hs.se.reservation.model.Dto;

import lombok.*;

@Getter
@Setter
public class ReservationDetail {

    private long id;
    private long productId;
    private long displayInfoId;
    private long cancelFlag;
    private String productDescription;
    private String productContent;
    private long userId;
    private long sumPrice;
    private String reservationDate;
    private String createDate;
    private String modifyDate;
}
