package com.example.demo.Repository;

import com.example.demo.model.IncomeSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeSourceRepository  extends JpaRepository <IncomeSource, Long>{

}
