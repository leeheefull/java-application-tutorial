package kr.ac.hs.se.model.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductPriceDto {
    private long id;
    private long productId;
    private String priceTypeName;
    private long price;
    private double discountRate;
    private String createDate;
    private String modifyDate;
}