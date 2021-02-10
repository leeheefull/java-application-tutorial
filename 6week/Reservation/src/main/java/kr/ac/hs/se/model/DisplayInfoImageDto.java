package kr.ac.hs.se.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class DisplayInfoImageDto {
    private long id;
    private long displayInfoId;
    private long fileId;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private boolean deleteFlag;
    private Date createDate;
    private Date modifyDate;
}
