package com.example.demo.repository;

import com.example.demo.model.Influencer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfluencerRepository extends JpaRepository<Influencer, Long> {

    Optional<Influencer> findBySocialHandle(String socialHandle);
    
}