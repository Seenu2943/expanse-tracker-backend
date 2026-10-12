package com.expansetracker.expanse_tracker.controller;
import com.expansetracker.expanse_tracker.dto.ExpanseDTO;
import com.expansetracker.expanse_tracker.entity.Expanse;
import com.expansetracker.expanse_tracker.service.ExpanseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/expanses")
public class ExpanseController {

    private final ExpanseService expanseService;

    public ExpanseController(ExpanseService expanseService) {
        this.expanseService = expanseService;
    }

    // POST - Add expense
    @PostMapping
    public ResponseEntity<Expanse> addExpanse(
            @Valid @RequestBody ExpanseDTO expanseDTO) {

        Expanse expanse = new Expanse();

        expanse.setTitle(expanseDTO.getTitle());
        expanse.setAmount(expanseDTO.getAmount());
        expanse.setCategory(expanseDTO.getCategory());
        expanse.setDate(expanseDTO.getDate());
        expanse.setDescription(expanseDTO.getDescription());

        Expanse savedExpanse = expanseService.addExpanse(expanse);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedExpanse);
    }
    @GetMapping
    public ResponseEntity<List<Expanse>> getAllExpanses() {
        return ResponseEntity.ok(
                expanseService.getAllExpanses()
        );
    }

    // GET - Get all expenses
    @GetMapping("/{id}")
    public ResponseEntity<Expanse> getExpanseById(
            @PathVariable Long id) {

        Expanse expanse = expanseService.getExpanseById(id);

        return ResponseEntity.ok(expanse);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Expanse>> getExpansesByCategory(
            @PathVariable String category) {

        return ResponseEntity.ok(
                expanseService.getExpansesByCategory(category)
        );
    }
    @GetMapping("/page")
    public ResponseEntity<Page<Expanse>> getExpanses(
            @PageableDefault(size = 5, sort = "amount",
                    direction = Sort.Direction.DESC)
            Pageable pageable) {

        return ResponseEntity.ok(
                expanseService.getAllExpanses(pageable)
        );
    }

    // PUT - Update expense
    @PutMapping("/{id}")
    public Expanse updateExpanse(
            @PathVariable Long id,
            @Valid @RequestBody ExpanseDTO expanseDTO) {

        Expanse expanse = new Expanse();

        expanse.setTitle(expanseDTO.getTitle());
        expanse.setAmount(expanseDTO.getAmount());
        expanse.setCategory(expanseDTO.getCategory());
        expanse.setDate(expanseDTO.getDate());
        expanse.setDescription(expanseDTO.getDescription());

        return expanseService.updateExpanse(id, expanse);
    }

    // DELETE - Delete expense
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpanse(@PathVariable Long id) {

        expanseService.deleteExpanse(id);

        return ResponseEntity.noContent().build();
    }
}
