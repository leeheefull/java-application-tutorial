package kr.ac.hs.se.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ProductImageDTO {
    private long productId;
    private long productImageId;
    private String type;
    private long fileInfoId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private boolean deleteFlag;
    private Date createDate;
    private Date modifyDate;
}
