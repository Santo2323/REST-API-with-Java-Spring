package com.example.informatorio.PruebaNoticias.Repository;

import com.example.informatorio.PruebaNoticias.Domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findBystatusPublishedAndDescriptionContainingOrTitleContaining(Boolean statusPublished, String Description, String title);
}
