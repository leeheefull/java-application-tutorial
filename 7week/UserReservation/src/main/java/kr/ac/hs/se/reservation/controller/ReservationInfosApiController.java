package kr.ac.hs.se.reservation.controller;

import kr.ac.hs.se.reservation.model.ReservationDto;
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
public class ReservationInfosApiController {

    private final ReservationService reservationService;

    @GetMapping
    public List<ReservationDto> getReservationInfos(Principal principal) {
        return reservationService.getReservationInfos(principal.getName());
    }

    @PutMapping
    public Map<String, String> updateReservationCancelFlag(@RequestBody Map<String, Integer> requestBody) {
        long cancelFlag = reservationService.updateReservationCancelFlag(requestBody.get("id"));
        return Collections.singletonMap("result", cancelFlag > 0 ? "success" : "fail");
    }
}
