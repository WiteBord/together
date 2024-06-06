package com.questions.dto;

import com.questions.entity.OptionsEntity;
import lombok.Data;

import java.util.List;

@Data
public class QuestionsDto {
    private String quesClasstext;
    private String text;
    private String quesClassId;
    private String id;
    private String queType;
    private String isright;
    private List<OptionsEntity> optionsEntityList;
}
