package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.Dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.ac.hs.se.sql.CommentsSql.*;

@RequiredArgsConstructor
@Repository
public class CommentsRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public int selectCommentsAvg(long productId) {
        return jdbc.queryForObject(AVG_COMMENT_SCORE_BY_PRODUCT_ID,
                Collections.singletonMap("productId", productId),
                int.class);
    }

    public List<CommentDto> selectComments() {
        return jdbc.query(SELECT_COMMENTS,
                Collections.EMPTY_MAP,
                BeanPropertyRowMapper.newInstance(CommentDto.class));
    }

    public List<CommentDto> selectComments(long productId) {
        return jdbc.query(SELECT_COMMENTS_BY_PRODUCT_ID,
                Collections.singletonMap("productId", productId),
                BeanPropertyRowMapper.newInstance(CommentDto.class));
    }

    public List<CommentDto> selectComments(long productId, long pageSize, long pageNo) {
        Map<String, Long> params = new HashMap<>();
        params.put("productId", productId);
        params.put("pageSize", pageSize);
        params.put("offset", pageSize * (pageNo - 1));

        return jdbc.query(SELECT_COMMENTS_BY_PRODUCT_ID_AND_PAGE,
                params,
                BeanPropertyRowMapper.newInstance(CommentDto.class));
    }
}
