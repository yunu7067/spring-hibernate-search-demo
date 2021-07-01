package io.github.yunu7067.hibernatesearchdemo.post.dto;

public class UploadPostDto {
    String title;
    String content;

    public UploadPostDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "UploadPostDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
