package kr.ac.hs.se.service;

import kr.ac.hs.se.model.ReservationUserCommentDto;

import java.util.List;

public interface ReservationUserCommentService {

    long getReservationUserCommentsSize();

    List<ReservationUserCommentDto> getReservationUserComments(long commentCount);
}
