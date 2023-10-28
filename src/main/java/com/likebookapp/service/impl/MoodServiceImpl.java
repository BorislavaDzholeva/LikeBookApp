package com.likebookapp.service.impl;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.MoodNameEnum;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.service.MoodService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodServiceImpl implements MoodService {
    private final MoodRepository moodRepository;
    private final ModelMapper modelMapper;

    public MoodServiceImpl(MoodRepository moodRepository, ModelMapper modelMapper) {
        this.moodRepository = moodRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initMoods() {
        if (moodRepository.count() != 0) {
            return;
        }
        Arrays.stream(MoodNameEnum.values()).forEach(moodNameEnum -> {
            Mood mood = new Mood();
            mood.setMoodName(moodNameEnum);
            moodRepository.save(mood);
        });
    }

    @Override
    public Mood findByMoodNameEnum(MoodNameEnum mood) {
        return moodRepository.findByMoodName(mood).orElse(null);

    }
}
