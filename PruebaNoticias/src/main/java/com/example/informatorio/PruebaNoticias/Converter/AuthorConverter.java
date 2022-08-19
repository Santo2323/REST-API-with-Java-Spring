package com.example.informatorio.PruebaNoticias.Converter;

import com.example.informatorio.PruebaNoticias.DTO.AuthorDTO;
import com.example.informatorio.PruebaNoticias.Domain.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {

    public AuthorDTO toDto(Author author){
        return new AuthorDTO(author.getId(), author.getFirstname(), author.getLastname(), author.getFullname(), author.getCreatedAt());
    }

    public Author toEntity(AuthorDTO authorDTO){
        return new Author(authorDTO.getFirstname(), authorDTO.getLastname(), authorDTO.getFullname(), authorDTO.getCreatedAt());
    }
}
