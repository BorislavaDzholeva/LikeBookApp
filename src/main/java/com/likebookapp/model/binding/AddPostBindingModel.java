package com.likebookapp.model.binding;

import com.likebookapp.model.entity.MoodNameEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddPostBindingModel {
    private Long id;
    @NotNull
    @Size(min = 2, max = 150, message = "Content length must be between 2 and 150 characters!")
    private String content;
    @NotNull(message = "You must select a mood!")
    private MoodNameEnum mood;

    public AddPostBindingModel() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodNameEnum getMood() {
        return mood;
    }

    public void setMood(MoodNameEnum mood) {
        this.mood = mood;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
