package kr.ac.hs.se.reservation.controller;

import kr.ac.hs.se.reservation.model.ReservationDetail;
import kr.ac.hs.se.reservation.model.request.ReservationRequest;
import kr.ac.hs.se.reservation.model.response.ReservationResponse;
import kr.ac.hs.se.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reservationinfos")
public class ReservationApiController {

    private final ReservationService reservationService;

    @GetMapping
    public List<ReservationDetail> getReservations(Principal principal) {
        return reservationService.getReservations(principal.getName());
    }

    @PostMapping
    public ReservationResponse postReservation(@RequestBody ReservationRequest request) {
        return reservationService.createReservation(request);
    }

    @PutMapping
    public Map<String, String> putReservationCancelFlag(@RequestBody Map<String, Integer> requestBody) {
        long cancelFlag = reservationService.updateReservationCancelFlag(requestBody.get("id"));
        return Collections.singletonMap("result", cancelFlag > 0 ? "success" : "fail");
    }
}
