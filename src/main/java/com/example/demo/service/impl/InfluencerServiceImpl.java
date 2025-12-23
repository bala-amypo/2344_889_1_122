package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
@Service


public class InfluencerServiceImpl implements InfluencerService {

    private final InfluencerRepository influencerRepository;

    public InfluencerServiceImpl(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    @Override
    public Influencer createInfluencer(Influencer influencer) {

        Optional<Influencer> existing =
                influencerRepository.findBySocialHandle(influencer.getSocialHandle());

        if (existing.isPresent()) {
            throw new RuntimeException("Duplicate social handle");
        }

        return influencerRepository.save(influencer);
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return influencerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Influencer not found"));
    }
    @Override
    public Influencer updateInfluencer(Long id, Influencer influencer) {

        Influencer existing = influencerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Influencer not found"));

        // Only update allowed fields (NO LOGIC CHANGE)
        if (influencer.getName() != null) {
            existing.setName(influencer.getName());
        }
        if (influencer.getEmail() != null) {
            existing.setEmail(influencer.getEmail());
        }
        if (influencer.getSocialHandle() != null) {
            existing.setSocialHandle(influencer.getSocialHandle());
        }

        return influencerRepository.save(existing);
    }

    @Override
    public Influencer deactivateInfluencer(Long id) {
         Influencer influencer = influencerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Influencer not found"));

        influencer.setActive(false);
        return influencerRepository.save(influencer);
    }
}