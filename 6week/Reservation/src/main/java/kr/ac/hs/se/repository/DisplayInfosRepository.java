package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.Dto.DisplayInfoDto;
import kr.ac.hs.se.model.Dto.DisplayInfoImageDto;
import kr.ac.hs.se.model.Dto.ProductImageDto;
import kr.ac.hs.se.model.Dto.ProductPriceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.ac.hs.se.sql.DisplayInfosSql.*;

@RequiredArgsConstructor
@Repository
public class DisplayInfosRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public List<DisplayInfoDto> selectDisplayInfos(String productImageType) {
        return jdbc.query(SELECT_DISPLAY_INFO_BY_PRODUCT_IMAGE_TYPE,
                Collections.singletonMap("productImageType", productImageType),
                BeanPropertyRowMapper.newInstance(DisplayInfoDto.class));
    }

    public List<DisplayInfoDto> selectDisplayInfos(String productImageType, long categoryId) {
        Map<String, Object> params = new HashMap<>();
        params.put("productImageType", productImageType);
        params.put("categoryId", categoryId);

        return jdbc.query(SELECT_DISPLAY_INFO_BY_PRODUCT_IMAGE_TYPE_AND_CATEGORY_ID,
                params,
                BeanPropertyRowMapper.newInstance(DisplayInfoDto.class));
    }

    public List<DisplayInfoDto> selectDisplayInfos(String productImageType, long categoryId, long pageSize, long pageNo) {
        Map<String, Object> params = new HashMap<>();
        params.put("productImageType", productImageType);
        params.put("categoryId", categoryId);
        params.put("pageSize", pageSize);
        params.put("offset", pageSize * (pageNo - 1));

        return jdbc.query(SELECT_DISPLAY_INFO_BY_PRODUCT_IMAGE_TYPE_AND_CATEGORY_ID_AND_PAGE,
                params,
                BeanPropertyRowMapper.newInstance(DisplayInfoDto.class));
    }

    public DisplayInfoDto selectDisplayInfo(String productImageType, long displayInfoId) {
        Map<String, Object> params = new HashMap<>();
        params.put("productImageType", productImageType);
        params.put("displayInfoId", displayInfoId);

        return jdbc.queryForObject(SELECT_DISPLAY_INFO_BY_PRODUCT_IMAGE_TYPE_AND_DISPLAY_ID,
                params,
                BeanPropertyRowMapper.newInstance(DisplayInfoDto.class));
    }

    public List<ProductImageDto> selectProductImages(long productId, String productImageType) {
        Map<String, Object> params = new HashMap<>();
        params.put("productId", productId);
        params.put("productImageType", productImageType);

        return jdbc.query(SELECT_PRODUCT_IMAGE_BY_PRODUCT_ID_AND_PRODUCT_IMAGE_TYPE,
                params,
                BeanPropertyRowMapper.newInstance(ProductImageDto.class));
    }

    public List<DisplayInfoImageDto> selectDisplayInfoImages(long productId) {
        return jdbc.query(SELECT_DISPLAY_INFO_IMAGE_BY_PRODUCT_ID,
                Collections.singletonMap("productId", productId),
                BeanPropertyRowMapper.newInstance(DisplayInfoImageDto.class));
    }

    public List<ProductPriceDto> selectProductPrices(long productId) {
        return jdbc.query(SELECT_PRODUCT_PRICE_BY_PRODUCT_ID,
                Collections.singletonMap("productId", productId),
                BeanPropertyRowMapper.newInstance(ProductPriceDto.class));
    }
}
