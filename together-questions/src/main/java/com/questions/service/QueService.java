package com.questions.service;


import com.questions.dto.QuestionsDto;
import com.questions.entity.OptionsEntity;
import com.questions.entity.QuesClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QueService {
    List<QuestionsDto> searchQuestion(String word,String queType,String queClassId,Integer pageSize,Integer pageNum);
    Integer searchQuesNum(String word,String queType,String queClassId);
    List<QuesClassEntity> getQuesClass();
    void addQuesClass(String className);
    void updateQuesClass(QuesClassEntity quesClassEntity);
    void deleteQuesClass(QuesClassEntity quesClassEntity);
    void addOptions(List<OptionsEntity> optionsEntityList);
    void deleteOptions(OptionsEntity optionsEntity);
    String addQuestion(QuestionsDto questionsDto);
    void  deleteQuestion(QuestionsDto questionsDto);

}
