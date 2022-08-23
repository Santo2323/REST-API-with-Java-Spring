package com.example.informatorio.PruebaNoticias.Controller;
import com.example.informatorio.PruebaNoticias.Converter.SourceConverter;
import com.example.informatorio.PruebaNoticias.DTO.SourceDTO;
import com.example.informatorio.PruebaNoticias.Domain.Source;
import com.example.informatorio.PruebaNoticias.Repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/source")
public class SourceController {
    @Autowired
    private final SourceConverter sourceConverter;
    @Autowired
    private final SourceRepository sourceRepository;

    @Autowired
    public SourceController(SourceConverter sourceConverter, SourceRepository sourceRepository) {
        this.sourceConverter = sourceConverter;
        this.sourceRepository = sourceRepository;
    }

    @PostMapping
    public ResponseEntity<?> createSource(@RequestBody SourceDTO sourceDTO) {
        return new ResponseEntity<>(sourceConverter.toDto(sourceRepository.save(sourceConverter.toEntity(sourceDTO))), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSourceByID(@PathVariable Long id)         {
        sourceRepository.deleteById(id);
        return new ResponseEntity<>("Source borrado con exito", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifySource(@PathVariable("id") Long id, @RequestBody SourceDTO sourceDTO) {
        Source sourceExistente = sourceRepository.findById(id).get();
        if (sourceDTO.getName() != null) {
            sourceExistente.setName(sourceDTO.getName());
        }
        if (sourceDTO.getCode() != null) {
            sourceExistente.setCode(sourceDTO.getCode());
        }
        sourceRepository.save(sourceExistente);
        return new ResponseEntity<>(sourceConverter.toDto(sourceExistente), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllAuthors(){
        List<Source> listSources = sourceRepository.findAll();
        List<SourceDTO> listSourcesDTO = listSources.stream().map(source -> sourceConverter.toDto(source)).toList();
        return new ResponseEntity<>(listSourcesDTO, HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> getSourcesByName(@RequestParam (defaultValue = "") String name){
        List<Source> listSources = sourceRepository.findBynameContaining(name);
        List<SourceDTO> listSourcesDTO = listSources.stream().map(source -> sourceConverter.toDto(source)).toList();
        return new  ResponseEntity<>(listSourcesDTO, HttpStatus.OK);
    }

}

// Done