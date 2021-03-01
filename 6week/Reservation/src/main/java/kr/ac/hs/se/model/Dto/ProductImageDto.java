package kr.ac.hs.se.model.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductImageDto {
    private long productId;
    private long productImageId;
    private String type;
    private long fileInfoId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private boolean deleteFlag;
    private String createDate;
    private String modifyDate;
}
