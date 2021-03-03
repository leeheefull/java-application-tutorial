package kr.ac.hs.se.reservation.controller;

import kr.ac.hs.se.reservation.model.Dto.ReservationDetail;
import kr.ac.hs.se.reservation.model.request.ReservationRequest;
import kr.ac.hs.se.reservation.model.response.ReservationResponse;
import kr.ac.hs.se.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reservationinfos")
public class ReservationApiController {

    private final ReservationService reservationService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public List<ReservationDetail> getReservations(Principal principal) {
        return reservationService.getReservations(principal.getName());
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ReservationResponse postReservation(@RequestBody ReservationRequest request) {
        return reservationService.createReservation(request);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping
    public String putReservationCancelFlag(@RequestBody Map<String, Integer> requestBody) {
        reservationService.updateReservationCancelFlag(requestBody.get("id"));
        return "success";
    }
}
