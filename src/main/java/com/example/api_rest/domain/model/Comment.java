package com.example.api_rest.domain.model;

import jakarta.persistence.Entity;

@Entity(name = "tb_comment")
public class Comment extends BaseInteraction
{
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
