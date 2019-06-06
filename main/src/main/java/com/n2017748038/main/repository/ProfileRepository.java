package com.n2017748038.main.repository;

import com.n2017748038.main.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile findByNetwork(final String network);
}
