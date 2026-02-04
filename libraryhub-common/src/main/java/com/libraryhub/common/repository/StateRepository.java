package com.libraryhub.common.repository;

import com.libraryhub.common.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    // Fetch state along with cities using JOIN FETCH
    @Query("SELECT s FROM State s LEFT JOIN FETCH s.cities WHERE s.stateId = :id")
    Optional<State> findByIdWithCities(@Param("id") Integer id);
}
