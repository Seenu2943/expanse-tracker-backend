package com.expansetracker.expanse_tracker.service;

import com.expansetracker. expanse_tracker.entity.Expanse;
import com.expansetracker. expanse_tracker.repository.ExpanseRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


//import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Pageable;

@Service
public class ExpanseService {

    private final ExpanseRepository expanseRepository;

    public ExpanseService(ExpanseRepository expanseRepository) {
        this.expanseRepository = expanseRepository;
    }

    public Expanse addExpanse(Expanse expanse) {
        return expanseRepository.save(expanse);
    }

    public List<Expanse> getAllExpanses() {
        return expanseRepository.findAll();
    }
    public Expanse getExpanseById(Long id) {
        return expanseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Expanse not found with id: " + id));
    }
    public List<Expanse> getExpansesByCategory(String category) {
        return expanseRepository.findByCategoryIgnoreCase(category);
    }
    public Page<Expanse> getAllExpanses(Pageable pageable) {
        return expanseRepository.findAll(pageable);
    }

    public Expanse updateExpanse(Long id, Expanse newExpanse) {

        Expanse existingExpanse = expanseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Expanse not found with id: " + id
                ));

        existingExpanse.setTitle(newExpanse.getTitle());
        existingExpanse.setAmount(newExpanse.getAmount());
        existingExpanse.setCategory(newExpanse.getCategory());
        existingExpanse.setDate(newExpanse.getDate());
        existingExpanse.setDescription(newExpanse.getDescription());

        return expanseRepository.save(existingExpanse);
    }

    // DELETE
    public void deleteExpanse(Long id) {

        expanseRepository.deleteById(id);
    }
}