package kr.ac.hs.se.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PromotionDto {
    private long id;
    private long productId;
    private long categoryId;
    private String categoryName;
    private String description;
    private long fileId;
}
