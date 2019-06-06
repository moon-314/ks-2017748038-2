package com.n2017748038.main.controller;

import com.n2017748038.main.domain.Basic;
import com.n2017748038.main.service.BasicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/basic")
public class BasicController {

    private BasicService basicService;

    public BasicController(BasicService basicService) {
        this.basicService = basicService;
    }

    @GetMapping("/{idx}")
    public String read(@PathVariable Long idx, Model model){
        model.addAttribute("basic", basicService.findBasicByIdx(idx));
        return "basic/basicItem";
    }

    @PostMapping("/add")
    public ResponseEntity<?> postBasic(@RequestBody Basic basic) {
        basicService.savedBasic(basic);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @GetMapping("/new")
    public String basicNew(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
 //       model.addAttribute("basic", basicService.findBasicByIdx(idx));
        return "basic/basicItem";
    }

    @PutMapping("/{idx}")
    public ResponseEntity<?> putBasic(@PathVariable("idx")Long idx, @RequestBody Basic basic){
        Basic persistBasic = basicService.getOne(idx);
        persistBasic.update(basic);
        basicService.savedBasic(persistBasic);
        return new ResponseEntity<>("{}",HttpStatus.OK);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteBasic(@PathVariable("idx")Long idx){
        basicService.deleteById(idx);
        return new ResponseEntity<>("{}",HttpStatus.OK);
    }

}
