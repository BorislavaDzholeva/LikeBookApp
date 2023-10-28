package com.likebookapp.model.service;

import com.likebookapp.model.entity.MoodNameEnum;


public class AddPostServiceModel {
    private Long id;
    private String content;
    private MoodNameEnum mood;

    public AddPostServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
