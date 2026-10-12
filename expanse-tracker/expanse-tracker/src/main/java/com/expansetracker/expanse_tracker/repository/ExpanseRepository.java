package com.expansetracker.expanse_tracker.repository;

import com.expansetracker.expanse_tracker.entity.Expanse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpanseRepository extends JpaRepository<Expanse, Long> {

    List<Expanse> findByCategoryIgnoreCase(String category);
}
