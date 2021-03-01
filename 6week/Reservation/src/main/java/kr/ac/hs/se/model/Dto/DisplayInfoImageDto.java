package kr.ac.hs.se.model.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String createDate;
    private String modifyDate;
}
