package kr.ac.hs.se.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
public class ListAllResponse<T> {

    private final long size;
    private final List<T> items;
}
