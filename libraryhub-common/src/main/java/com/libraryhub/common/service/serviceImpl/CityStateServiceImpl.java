package com.libraryhub.common.service.serviceImpl;

import com.libraryhub.common.entity.State;
import com.libraryhub.common.repository.StateRepository;
import com.libraryhub.common.request.StateRequest;
import com.libraryhub.common.response.CityResponse;
import com.libraryhub.common.response.StateResponse;
import com.libraryhub.common.service.CityStateService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityStateServiceImpl implements CityStateService {
    private final StateRepository stateRepository;


    @Override
    @Transactional(readOnly = true)
    public StateResponse getStateWithCities(Integer stateId) {

        State state = stateRepository.findByIdWithCities(stateId)
                .orElseThrow(() -> new RuntimeException("State not found"));

        return StateResponse.builder()
                .stateId(state.getStateId())
                .name(state.getName())
                .code(state.getCode())
                .status(state.getStatus())
                .cities(
                        state.getCities()
                                .stream()
                                .map(city -> CityResponse.builder()
                                        .cityId(city.getCityId())
                                        .name(city.getName())
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
    }


    @Override
    @Transactional
    public StateResponse createState(StateRequest request) {

        State state = State.builder()
                .name(request.getName())
                .code(request.getCode())
                .status(request.getStatus())
                .build();

        State savedState = stateRepository.save(state);

        return StateResponse.builder()
                .stateId(savedState.getStateId())
                .name(savedState.getName())
                .code(savedState.getCode())
                .status(savedState.getStatus())
                .cities(null)
                .build();
    }
}
