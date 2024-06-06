package com.questions.dao;

import com.questions.dto.QuestionsDto;
import com.questions.entity.QuestionsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionsDao {
    List<QuestionsDto> searchQuestion(String word,String queClassId);
}
