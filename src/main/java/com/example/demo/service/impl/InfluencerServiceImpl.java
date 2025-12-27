package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final InfluencerRepository influencerRepository;

    public InfluencerServiceImpl(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        return influencerRepository.save(influencer);
    }

    @Override
    public Influencer updateInfluencer(Long id, Influencer influencer) {
        Influencer existing = influencerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Influencer not found"));
        existing.setName(influencer.getName());
        existing.setEmail(influencer.getEmail());
        return influencerRepository.save(existing);
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return influencerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Influencer not found"));
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    @Override
    public void deactivateInfluencer(Long id) {
        Influencer inf = getInfluencerById(id);
        inf.setActive(false);
        influencerRepository.save(inf);
    }
}
