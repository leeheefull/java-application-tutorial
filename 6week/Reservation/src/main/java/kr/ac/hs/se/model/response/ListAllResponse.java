package kr.ac.hs.se.model.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ListAllResponse<T> {

    private final long size;
    private final List<T> items;

    public ListAllResponse(List<T> items) {
        this.items = items;
        this.size = items.size();
    }
}
