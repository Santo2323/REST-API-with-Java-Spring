package com.example.informatorio.PruebaNoticias.Services;

import com.example.informatorio.PruebaNoticias.DTO.AuthorDTO;
import com.example.informatorio.PruebaNoticias.DTO.SourceDTO;
import com.example.informatorio.PruebaNoticias.Domain.Author;
import com.example.informatorio.PruebaNoticias.Domain.Source;
import com.example.informatorio.PruebaNoticias.Repository.AuthorRepository;
import com.example.informatorio.PruebaNoticias.Repository.SourceRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class ArticleService {
    @Autowired
    private final SourceRepository sourceRepository;
    @Autowired
    private final AuthorRepository authorRepository;
    @Autowired

    public ArticleService(SourceRepository sourceRepository, AuthorRepository authorRepository) {
        this.sourceRepository = sourceRepository;
        this.authorRepository = authorRepository;
    }

    public Author addAuthorToArticle(@NotNull AuthorDTO authorDTO) {
           Author authorExistente = authorRepository.findById(authorDTO.getId()).get();

        return authorExistente;

    };

    public Source addSourceToArticle(@NotNull SourceDTO sourceDTO){
        Source sourceExistente = sourceRepository.findById(sourceDTO.getId()).get();
        return sourceExistente;
    };

}
