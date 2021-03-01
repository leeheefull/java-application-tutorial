package kr.ac.hs.se.model.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ListPageResponse<T> {

    private final long totalCount;
    private final long itemCount;
    private final List<T> items;
}
