package kr.ac.hs.se.vo;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ProductImage {
    private long id;
    private long categoryId;
    private String description;
    private String content;
    private String event;
    private Date createDate;
    private Date modifyDate;
}
