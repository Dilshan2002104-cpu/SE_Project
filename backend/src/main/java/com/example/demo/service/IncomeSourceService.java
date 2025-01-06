package com.example.demo.service;

import com.example.demo.Repository.IncomeSourceRepository;
import com.example.demo.model.IncomeSource;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class IncomeSourceService {

    @Autowired
    private final IncomeSourceRepository repository;

    public IncomeSourceService(IncomeSourceRepository repository) {
        this.repository = repository;
    }

    public List<IncomeSource> findAll() {
        return repository.findAll();
    }

    public IncomeSource save(IncomeSource incomeSource) {
        return repository.save(incomeSource);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public IncomeSource update(Long id,IncomeSource incomeSource) {
        incomeSource.setId(id);
        return repository.save(incomeSource);
    }
}
