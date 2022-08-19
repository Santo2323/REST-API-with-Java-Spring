package com.example.informatorio.PruebaNoticias.Controller;
import com.example.informatorio.PruebaNoticias.Converter.ArticleConverter;
import com.example.informatorio.PruebaNoticias.Converter.AuthorConverter;
import com.example.informatorio.PruebaNoticias.Converter.SourceConverter;
import com.example.informatorio.PruebaNoticias.DTO.ArticleDTO;
import com.example.informatorio.PruebaNoticias.DTO.AuthorDTO;
import com.example.informatorio.PruebaNoticias.Domain.Article;
import com.example.informatorio.PruebaNoticias.Domain.Author;
import com.example.informatorio.PruebaNoticias.Repository.ArticleRepository;
import com.example.informatorio.PruebaNoticias.Repository.AuthorRepository;
import com.example.informatorio.PruebaNoticias.Repository.SourceRepository;
import com.example.informatorio.PruebaNoticias.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/v1/article")
public class ArticleController {
    @Autowired
    private final ArticleRepository articleRepository;
    @Autowired
    private final SourceRepository sourceRepository;

    @Autowired
     private final AuthorRepository authorRepository;

    @Autowired
    private final SourceConverter sourceConverter;

    @Autowired
    private final AuthorConverter authorConverter;
    @Autowired
    private final ArticleConverter articleConverter;
    @Autowired
    private final ArticleService articleservice;
    @Autowired
    public ArticleController(ArticleRepository articleRepository, SourceRepository sourceRepository, AuthorRepository authorRepository, SourceConverter sourceConverter, AuthorConverter authorConverter, ArticleConverter articleConverter, ArticleService articleservice) {
        this.articleRepository = articleRepository;
        this.sourceRepository = sourceRepository;
        this.authorRepository = authorRepository;
        this.sourceConverter = sourceConverter;
        this.authorConverter = authorConverter;
        this.articleConverter = articleConverter;
        this.articleservice = articleservice;
    }

    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody ArticleDTO articleDTO) {
        articleRepository.save(articleConverter.toEntity(articleDTO));

        return new ResponseEntity<>("Article creado con exito", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticleByID(@PathVariable Long id)       {
        articleRepository.deleteById(id);
        return new ResponseEntity<>("Article borrado con exito", HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> modifyAuthor(@PathVariable("id") Long id, @RequestBody ArticleDTO articleDTO) {
        Article articleExistente = articleRepository.findById(id).get();
        if (articleDTO.getTitle() != null) {
            articleExistente.setTitle(articleDTO.getTitle());
        }
        if (articleDTO.getDescription() != null) {
            articleExistente.setDescription(articleDTO.getDescription());
        }
        if (articleDTO.getUrl() != null) {
            articleExistente.setUrl(articleDTO.getUrl());
        }
        if (articleDTO.getUrlToImage() != null) {
            articleExistente.setUrlToImage(articleDTO.getUrlToImage());
        }
        if (articleDTO.getPublishedAt() != null) {
            articleExistente.setPublishedAt(articleDTO.getPublishedAt());
        }
        if (articleDTO.getContent() != null) {
            articleExistente.setContent(articleDTO.getContent());
        }
        if (articleDTO.getStatusPublished() != null) {
            articleExistente.setStatusPublished(articleDTO.getStatusPublished());
        }
        if (articleDTO.getAuthorDTO() != null) {
            articleExistente.setAuthor(articleservice.addAuthorToArticle(articleDTO.getAuthorDTO()));
        }
        if (articleDTO.getSourceDTO() != null) {
            articleExistente.setSource(articleservice.addSourceToArticle(articleDTO.getSourceDTO()));
        }
        articleRepository.save(articleExistente);
        return new ResponseEntity<>(articleConverter.toDto(articleExistente), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{word}")
    public ResponseEntity<?> SearchByWord(@PathVariable @Validated @Size(min = 4) String word) {
        List<Article> listArticles = articleRepository.findBystatusPublishedAndDescriptionContainingOrTitleContaining(true, word, word);
        List<ArticleDTO> listArticlesDTO = listArticles.stream().map(article -> articleConverter.toDto(article)).toList();
      return new ResponseEntity<>(listArticlesDTO, HttpStatus.OK);
    }

}

// Ready for Review