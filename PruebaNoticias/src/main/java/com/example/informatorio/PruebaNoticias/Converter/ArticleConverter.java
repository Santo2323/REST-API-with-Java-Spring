package com.example.informatorio.PruebaNoticias.Converter;

import com.example.informatorio.PruebaNoticias.DTO.ArticleDTO;
import com.example.informatorio.PruebaNoticias.Domain.Article;
import com.example.informatorio.PruebaNoticias.Repository.AuthorRepository;
import com.example.informatorio.PruebaNoticias.Repository.SourceRepository;
import com.example.informatorio.PruebaNoticias.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleConverter {
    @Autowired
    private final ArticleService articleService;
    @Autowired
    private final AuthorConverter authorConverter;
    @Autowired
    private final SourceConverter sourceConverter;
    @Autowired
    private final AuthorRepository authorRepository;
    @Autowired
    private final SourceRepository sourceRepository;

    @Autowired
    public ArticleConverter(ArticleService articleService, AuthorConverter authorConverter, SourceConverter sourceConverter, AuthorRepository authorRepository, SourceRepository sourceRepository) {
        this.articleService = articleService;
        this.authorConverter = authorConverter;
        this.sourceConverter = sourceConverter;
        this.authorRepository = authorRepository;
        this.sourceRepository = sourceRepository;
    }

    public ArticleDTO toDto(Article article){
        return new ArticleDTO(article.getId(),
                article.getTitle(),
                article.getDescription(),
                article.getUrl(),
                article.getUrlToImage(),
                article.getPublishedAt(),
                article.getContent(),
                article.getStatusPublished(),
                authorConverter.toDto(article.getAuthor()),
                sourceConverter.toDto(article.getSource())
        );
    };

    public Article toEntity(ArticleDTO articleDTO){
        return new Article(
                articleDTO.getId(),
                articleDTO.getTitle(),
                articleDTO.getDescription(),
                articleDTO.getUrl(),
                articleDTO.getUrlToImage(),
                articleDTO.getPublishedAt(),
                articleDTO.getContent(),
                articleDTO.getStatusPublished(),
                articleService.addAuthorToArticle(articleDTO.getAuthorDTO()),
                articleService.addSourceToArticle(articleDTO.getSourceDTO())
        );
    }

}
