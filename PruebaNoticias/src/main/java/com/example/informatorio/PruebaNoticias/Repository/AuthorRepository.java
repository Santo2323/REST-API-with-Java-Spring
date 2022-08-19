package com.example.informatorio.PruebaNoticias.Repository;

import com.example.informatorio.PruebaNoticias.Domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

        List<Author> findByfullnameContaining(String fullname);
        List<Author> findBycreatedAtAfter(LocalDateTime createdAt);
}
