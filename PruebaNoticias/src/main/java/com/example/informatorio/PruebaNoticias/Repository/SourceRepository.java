package com.example.informatorio.PruebaNoticias.Repository;

import com.example.informatorio.PruebaNoticias.Domain.Author;
import com.example.informatorio.PruebaNoticias.Domain.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {
    List<Source> findBynameContaining(String name);
}
