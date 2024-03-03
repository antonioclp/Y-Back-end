package com.y.back.models.repository;

import com.y.back.models.entity.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Person repository.
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
  Optional<Person> findByUsername(String username);
}
