package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EquationController {

    @CrossOrigin
    @PostMapping("/getEquation")
    public ResponseEntity<?> getEquation(@RequestBody EquationProperties e){
        CodeImplementation implementation = new CodeImplementation();
        Solution sol = implementation.solve(e);

        return new ResponseEntity<>(sol, HttpStatus.OK);
    }

}
