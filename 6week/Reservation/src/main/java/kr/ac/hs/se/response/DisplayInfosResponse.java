package kr.ac.hs.se.response;

import kr.ac.hs.se.model.DisplayInfoDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class DisplayInfosResponse {
    private final long totalCount;
    private final long productCount;
    private final List<DisplayInfoDto> products;
}
