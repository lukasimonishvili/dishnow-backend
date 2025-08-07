package com.dishNow.dishNow.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dishNow.dishNow.Models.TestModel;
import com.dishNow.dishNow.Services.TestService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("/add")
    public ResponseEntity<?> addTest(@RequestBody TestDTO test) {
        testService.addTestInDB(test);
        return ResponseEntity.ok("created");
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getMethodName() {
        List<TestModel> result = testService.getAllTests();
        return ResponseEntity.ok(result);
    }
    
}
