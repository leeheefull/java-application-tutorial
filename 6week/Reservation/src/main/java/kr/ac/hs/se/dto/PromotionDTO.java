package kr.ac.hs.se.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PromotionDTO {
    private long id;
    private long productId;
    private long categoryId;
    private String categoryName;
    private String description;
    private long fileId;
}
