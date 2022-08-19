package com.example.informatorio.PruebaNoticias.DTO;

import java.time.LocalDateTime;
import java.util.Objects;

public class ArticleDTO {

    private Long id;

    private String title;

    private String description;

    private String url;

    private String urlToImage;

    private LocalDateTime publishedAt;

    private String content;

    private Boolean statusPublished;
    private AuthorDTO authorDTO;

    private SourceDTO sourceDTO;


    public ArticleDTO(Long id, String title, String description, String url, String urlToImage, LocalDateTime publishedAt, String content, Boolean statusPublished, AuthorDTO authorDTO, SourceDTO sourceDTO) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.statusPublished = statusPublished;
        this.authorDTO = authorDTO;
        this.sourceDTO = sourceDTO;
    }

    public Boolean getStatusPublished() {
        return statusPublished;
    }

    public void setStatusPublished(Boolean statusPublished) {
        this.statusPublished = statusPublished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

    public SourceDTO getSourceDTO() {
        return sourceDTO;
    }

    public void setSourceDTO(SourceDTO sourceDTO) {
        this.sourceDTO = sourceDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleDTO that = (ArticleDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(url, that.url) && Objects.equals(urlToImage, that.urlToImage) && Objects.equals(publishedAt, that.publishedAt) && Objects.equals(content, that.content) && Objects.equals(statusPublished, that.statusPublished) && Objects.equals(authorDTO, that.authorDTO) && Objects.equals(sourceDTO, that.sourceDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, url, urlToImage, publishedAt, content, statusPublished, authorDTO, sourceDTO);
    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                ", statusPublished=" + statusPublished +
                ", authorDTO=" + authorDTO +
                ", sourceDTO=" + sourceDTO +
                '}';
    }
}
