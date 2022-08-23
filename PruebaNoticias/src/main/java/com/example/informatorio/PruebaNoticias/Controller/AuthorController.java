package com.example.informatorio.PruebaNoticias.Controller;
import com.example.informatorio.PruebaNoticias.Converter.AuthorConverter;
import com.example.informatorio.PruebaNoticias.DTO.AuthorDTO;
import com.example.informatorio.PruebaNoticias.Domain.Author;
import com.example.informatorio.PruebaNoticias.Repository.AuthorRepository;
import com.example.informatorio.PruebaNoticias.Services.CustomPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    private final AuthorRepository authorRepository;
    @Autowired
    private final AuthorConverter authorConverter;

    @Autowired
    private final CustomPageService customPageService;


    @Autowired
    public AuthorController(AuthorRepository authorRepository, AuthorConverter authorConverter, CustomPageService customPageService){
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
        this.customPageService = customPageService;
    }

    @GetMapping
    public ResponseEntity<?> findByAll(@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 5);
        Page<Author> pageResult = authorRepository.findAll(pageable);
        return new ResponseEntity<>(customPageService.customizePage(pageResult), HttpStatus.OK);
    }

    @GetMapping("/getAfter/{createdAt}")
    public ResponseEntity<?> getAuthorsAfterCreatedAT(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime createdAt)
    {
        List<Author> listAuthors = authorRepository.findBycreatedAtAfter(createdAt);
        List<AuthorDTO> listAuthorsDTO = listAuthors.stream().map(author -> authorConverter.toDto(author)).toList();
        return new ResponseEntity<>(listAuthorsDTO, HttpStatus.OK);
    }


    @GetMapping("/{fullname}")
    public ResponseEntity<?> getAuthorsByfullname(@PathVariable String fullname){
        List<Author> listAuthors = authorRepository.findByfullnameContaining(fullname);
        List<AuthorDTO> listAuthorsDTO = listAuthors.stream().map(author -> authorConverter.toDto(author)).toList();

        return new ResponseEntity<>(listAuthorsDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody AuthorDTO authorDTO) {
        return new ResponseEntity<>(authorConverter.toDto(authorRepository.save(authorConverter.toEntity(authorDTO))), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthorByID(@PathVariable Long id)         {
        authorRepository.deleteById(id);
        return new ResponseEntity<String>("Author borrado con exito", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyAuthor(@PathVariable("id") Long id, @RequestBody AuthorDTO authorDTO) {
        Author authorExistente = authorRepository.findById(id).get();
        if (authorDTO.getFirstname() != null){
            authorExistente.setFirstname(authorDTO.getFirstname());
        }
        if (authorDTO.getLastname() != null){
            authorExistente.setLastname(authorDTO.getLastname());
        }
        if (authorDTO.getFullname() != null){
            authorExistente.setFullname(authorDTO.getFullname());
        }
        authorRepository.save(authorExistente);
        return new ResponseEntity<>(authorConverter.toDto(authorExistente), HttpStatus.CREATED);
    }
}

// Done