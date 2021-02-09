package kr.ac.hs.se.vo;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class FileInfo {
    private long id;
    private String fileName;
    private String saveFileName;
    private String contentType;
    private boolean deleteFlag;
    private Date createDate;
    private Date modifyDate;
}
