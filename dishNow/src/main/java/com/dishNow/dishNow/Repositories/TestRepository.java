package com.dishNow.dishNow.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dishNow.dishNow.Models.TestModel;

public interface TestRepository extends JpaRepository<TestModel, Long>{
    
}
