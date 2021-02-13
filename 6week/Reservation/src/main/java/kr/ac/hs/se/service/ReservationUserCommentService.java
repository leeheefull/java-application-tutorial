package kr.ac.hs.se.service;

import kr.ac.hs.se.model.ReservationUserCommentDto;
import kr.ac.hs.se.repository.ReservationUserCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationUserCommentService {

    private final ReservationUserCommentRepository reservationUserCommentRepository;

    @Autowired
    public ReservationUserCommentService(ReservationUserCommentRepository reservationUserCommentRepository) {
        this.reservationUserCommentRepository = reservationUserCommentRepository;
    }

    public long getReservationUserCommentsSize() {
        return reservationUserCommentRepository.countAll();
    }

    @Transactional(readOnly = true)
    public List<ReservationUserCommentDto> getReservationUserComments(long commentCount) {
        return reservationUserCommentRepository.select(commentCount);
    }
}
