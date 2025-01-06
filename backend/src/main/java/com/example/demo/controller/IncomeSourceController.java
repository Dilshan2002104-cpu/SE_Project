package com.example.demo.controller;

import com.example.demo.model.IncomeSource;
import com.example.demo.service.IncomeSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
public class IncomeSourceController {

    @Autowired
    private final IncomeSourceService service;

    public IncomeSourceController(IncomeSourceService service) {
        this.service = service;
    }

    @GetMapping("/getAllIncome")
    public List<IncomeSource> getAllIncomes() {
        return service.findAll();
    }

    @PostMapping("/createIncome")
    public IncomeSource createIncomes(@RequestBody IncomeSource incomeSource) {
        return service.save(incomeSource);
    }

    @PutMapping("/updateIncome/{id}")
    public IncomeSource updateIncome(@PathVariable Long id,@RequestBody IncomeSource incomeSource) {
        return service.update(id,incomeSource);
    }

    @DeleteMapping("/deleteIncome/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
