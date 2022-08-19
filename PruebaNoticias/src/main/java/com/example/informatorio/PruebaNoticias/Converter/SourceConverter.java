package com.example.informatorio.PruebaNoticias.Converter;

import com.example.informatorio.PruebaNoticias.DTO.AuthorDTO;
import com.example.informatorio.PruebaNoticias.DTO.SourceDTO;
import com.example.informatorio.PruebaNoticias.Domain.Author;
import com.example.informatorio.PruebaNoticias.Domain.Source;
import org.springframework.stereotype.Component;

@Component
public class SourceConverter {

        public SourceDTO toDto(Source source){
            return new SourceDTO(source.getId(),
                    source.getName(),
                    source.getCode(),
                    source.getCreatedAt());
        }
        public Source toEntity(SourceDTO sourceDTO){
        return new Source(
                sourceDTO.getName(),
                sourceDTO.getCode(),
                sourceDTO.getCreatedAt()
        );
    }
}
