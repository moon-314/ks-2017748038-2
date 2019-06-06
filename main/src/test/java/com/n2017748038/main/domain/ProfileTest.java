package com.n2017748038.main.domain;

import com.n2017748038.main.repository.ProfileRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfileTest {

    @Autowired
    private ProfileRepository profileRepository;

    private Profile savedProfile;

    @Before
    public void init(){
        savedProfile = profileRepository.save(Profile.builder()
                .network("Twitter")
                .username("홍길동")
                .url("http://www.twitter.com/홍길동")
                .createdAt(LocalDateTime.now())
                .updateDate(LocalDateTime.now()).build());
    }

    @Test
    public void testFindProfile(){
        Profile foundProfile = profileRepository.findById(savedProfile.getIdx()).orElse(null);
        assertThat(foundProfile.getIdx()).isEqualTo(savedProfile.getIdx());
    }

    @Test
    public void testFindNetworkProfile(){
        Profile foundProfile = profileRepository.findByNetwork("Twitter");
        assertThat(foundProfile.getNetwork()).isEqualTo(savedProfile.getNetwork());
    }

    @Test
    public void testUpdateNetworkProfile() {
        Profile updateNetworkProfile= profileRepository.findByNetwork("Twitter");
        updateNetworkProfile.setNetwork("Twitter-수정");
        updateNetworkProfile = profileRepository.save(updateNetworkProfile);

        assertThat(updateNetworkProfile.getNetwork()).isEqualTo("Twitter-수정");
    }

    @Test
    public void testDeleteNetworkProfile() {
        Profile deleteNatworkProfile = profileRepository.findByNetwork("Twitter");
        profileRepository.delete(deleteNatworkProfile);

        Profile findNetworkProfile= profileRepository.findByNetwork("Twitter");

        assertThat(findNetworkProfile).isNull();
    }
}