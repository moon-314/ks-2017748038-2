package com.n2017748038.main.service;

import com.n2017748038.main.domain.Profile;
import com.n2017748038.main.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> findProfileList() {
        return profileRepository.findAll();
    }

    public Profile findProfileByIdx(Long idx){
        return profileRepository.findById(idx).orElse(new Profile());
    }

    public Profile savedProfile(Profile profile){
        return profileRepository.save(profile);
    }

    public Profile getOne(Long idx) {
        return profileRepository.getOne(idx);
    }


    public void deleteById(Long idx) {
        profileRepository.deleteById(idx);
    }
}
