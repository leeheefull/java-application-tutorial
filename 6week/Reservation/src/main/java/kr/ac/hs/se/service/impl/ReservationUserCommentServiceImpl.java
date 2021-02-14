package kr.ac.hs.se.service.impl;

import kr.ac.hs.se.model.ReservationUserCommentDto;
import kr.ac.hs.se.repository.ReservationUserCommentRepository;
import kr.ac.hs.se.service.ReservationUserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationUserCommentServiceImpl implements ReservationUserCommentService {

    private final ReservationUserCommentRepository reservationUserCommentRepository;

    @Autowired
    public ReservationUserCommentServiceImpl(ReservationUserCommentRepository reservationUserCommentRepository) {
        this.reservationUserCommentRepository = reservationUserCommentRepository;
    }

    @Override
    public long getReservationUserCommentsSize() {
        return reservationUserCommentRepository.countAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationUserCommentDto> getReservationUserComments(long commentCount) {
        return reservationUserCommentRepository.select(commentCount);
    }
}

