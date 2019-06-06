package com.n2017748038.main.service;

import com.n2017748038.main.domain.Basic;
import com.n2017748038.main.repository.BasicRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BasicService {

    private final BasicRepository basicRepository;

    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    public List<Basic> findBasicList() {
        return basicRepository.findAll();
    }

    public Basic findBasicByIdx(Long idx) {
        return basicRepository.findById(idx).orElse(new Basic());
    }

    public Basic savedBasic(Basic basic){

        return basicRepository.save(basic);
    }

    public Basic getOne(Long idx) {
        return basicRepository.getOne(idx);
    }

    public void deleteById(Long idx) {

        basicRepository.deleteById(idx);
    }


}
