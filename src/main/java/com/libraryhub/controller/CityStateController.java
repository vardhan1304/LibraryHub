package com.libraryhub.controller;


import com.libraryhub.dto.StateResponse;
import com.libraryhub.request.StateRequest;
import com.libraryhub.service.CityStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/city-state")
@RequiredArgsConstructor
public class CityStateController {

    private final CityStateService cityStateService;

    @GetMapping("/{id}")
    public StateResponse getStateWithCities(@PathVariable Integer id) {
        return cityStateService.getStateWithCities(id);
    }

    @PostMapping
    public ResponseEntity<StateResponse> createState(@RequestBody StateRequest request) {

        StateResponse response = cityStateService.createState(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
