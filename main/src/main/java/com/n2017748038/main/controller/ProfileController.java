package com.n2017748038.main.controller;

import com.n2017748038.main.domain.Profile;
import com.n2017748038.main.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping({"/{idx}"})
    public String read(@PathVariable Long idx, Model model){
        model.addAttribute("profile", profileService.findProfileByIdx(idx));
        return "profile/profileItem";
    }

    @PostMapping("/add")
    public ResponseEntity<?> postProfile(@RequestBody Profile profile) {
        profile.setCreatedAt();
        profileService.savedProfile(profile);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @GetMapping("/new")
    public String profileNew(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
        model.addAttribute("profile", profileService.findProfileByIdx(idx));
        return "profile/profileItem";
    }

    @PutMapping("/{idx}")
    public ResponseEntity<?> putProfile(@PathVariable("idx")Long idx, @RequestBody Profile profile){
        Profile persistProfile = profileService.getOne(idx);
        persistProfile.update(profile);
        profileService.savedProfile(persistProfile);
        return new ResponseEntity<>("{}",HttpStatus.OK);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteProfile(@PathVariable("idx")Long idx){
        profileService.deleteById(idx);
        return new ResponseEntity<>("{}",HttpStatus.OK);
    }
}
