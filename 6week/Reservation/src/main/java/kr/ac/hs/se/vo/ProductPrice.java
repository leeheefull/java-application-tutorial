package kr.ac.hs.se.vo;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ProductPrice {
    private long id;
    private long productId;
    private String priceTypeName;
    private long price;
    private double discountRate;
    private Date createDate;
    private Date modifyDate;
}
