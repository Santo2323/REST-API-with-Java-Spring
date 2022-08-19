package com.example.informatorio.PruebaNoticias.Services;

import com.example.informatorio.PruebaNoticias.Converter.AuthorConverter;
import com.example.informatorio.PruebaNoticias.DTO.CustomPageDTO;
import com.example.informatorio.PruebaNoticias.Domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CustomPageService {

    @Autowired
    private final AuthorConverter authorConverter;


    public CustomPageService(CustomPageDTO customPageDTO, AuthorConverter authorConverter) {
        this.authorConverter = authorConverter;
    }

    public CustomPageDTO customizePage(Page<Author> pageAuthor){
        return new CustomPageDTO(
                pageAuthor.getNumber(),
                pageAuthor.getSize(),
                pageAuthor.getTotalPages(),
                pageAuthor.getNumberOfElements(),
                pageAuthor.getContent().stream()
                        .map(author -> authorConverter.toDto(author))
                        .toList()
        );
    }
}
