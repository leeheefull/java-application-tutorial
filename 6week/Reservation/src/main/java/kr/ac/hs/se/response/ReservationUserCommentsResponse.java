package kr.ac.hs.se.response;

import kr.ac.hs.se.model.ReservationUserCommentDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class ReservationUserCommentsResponse {
    private final long totalCount;
    private final long commentCount;
    private final List<ReservationUserCommentDto> reservationUserComments;
}
