package kr.ac.hs.se.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ProductPriceDto {
    private long id;
    private long productId;
    private String priceTypeName;
    private long price;
    private double discountRate;
    private Date createDate;
    private Date modifyDate;
}