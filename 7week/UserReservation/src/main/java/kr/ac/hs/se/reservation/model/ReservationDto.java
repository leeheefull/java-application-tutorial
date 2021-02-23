package kr.ac.hs.se.reservation.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ReservationDto {

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
