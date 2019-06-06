package com.n2017748038.main.repository;

import com.n2017748038.main.domain.Basic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasicRepository extends JpaRepository<Basic, Long> {

    Basic findByName(final String name);
}
