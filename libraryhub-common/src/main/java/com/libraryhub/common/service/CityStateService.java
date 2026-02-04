package com.libraryhub.common.service;


import com.libraryhub.common.request.StateRequest;
import com.libraryhub.common.response.StateResponse;

public interface CityStateService {
    StateResponse getStateWithCities(Integer stateId);


    StateResponse createState(StateRequest request);
}
