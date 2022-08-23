package com.example.informatorio.PruebaNoticias.Converter;

import com.example.informatorio.PruebaNoticias.DTO.SourceDTO;
import com.example.informatorio.PruebaNoticias.Domain.Source;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SourceConverterTest {

    private SourceConverter sourceConverter;


    @Test
    void ToDto() {
        sourceConverter = new SourceConverter();

        SourceDTO dtoExpected = new SourceDTO(1L, "La Nacion", "la-nacion", LocalDateTime.parse("2019-12-15T15:14:21.629"));

        Source source = new Source();
        source.setId(1L);
        source.setCode("la-nacion");
        source.setName("La Nacion");
        source.setCreatedAt(LocalDateTime.parse("2019-12-15T15:14:21.629"));

        SourceDTO dtoActual = sourceConverter.toDto(source);

        assertEquals(dtoExpected, dtoActual);

    }

}