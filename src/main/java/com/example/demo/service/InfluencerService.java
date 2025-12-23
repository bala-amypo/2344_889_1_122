package com.example.demo.service;

import com.example.demo.entity.Influencer;
import java.util.List;

public interface InfluencerService {

    Influencer createInfluencer(Influencer influencer);

    List<Influencer> getAllInfluencers();

    Influencer getInfluencerById(Long id);
    Influencer updateInfluencer(Long id, Influencer influencer);

    Influencer deactivateInfluencer(Long id);
}