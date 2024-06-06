package com.questions.service;


import com.questions.dto.QuestionsDto;
import com.questions.entity.QuesClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QueService {

    List<QuestionsDto> searchQuestion(String word, String queClassId);
    List<QuesClassEntity> getQuesClass();
}
