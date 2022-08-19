package com.example.informatorio.PruebaNoticias.DTO;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomPageDTO {

    private int page;

    private int size;

    private int totalPage;

    private int totalElements;

    private List<AuthorDTO> content;


    public CustomPageDTO() {
    }

    public CustomPageDTO(int page, int size, int totalPage, int totalElements, List<AuthorDTO> content) {
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.totalElements = totalElements;
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public List<AuthorDTO> getContent() {
        return content;
    }

    public void setContent(List<AuthorDTO> content) {
        this.content = content;
    }
}
