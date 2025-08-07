package com.dishNow.dishNow.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dishNow.dishNow.Controllers.TestDTO;
import com.dishNow.dishNow.Models.TestModel;
import com.dishNow.dishNow.Repositories.TestRepository;

@Service
public class TestService {
    @Autowired 
    private TestRepository testRepository;

    public void addTestInDB(TestDTO test) {
        TestModel model = new TestModel(test.name);
        testRepository.save(model);
    }

    public List<TestModel> getAllTests() {
        return testRepository.findAll();
    }
}
