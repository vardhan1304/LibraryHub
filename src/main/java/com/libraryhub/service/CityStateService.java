package com.libraryhub.service;

import com.libraryhub.dto.StateResponse;
import com.libraryhub.request.StateRequest;

public interface CityStateService {
    StateResponse getStateWithCities(Integer stateId);


    StateResponse createState(StateRequest request);
}
