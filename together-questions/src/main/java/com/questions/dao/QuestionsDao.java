package com.questions.dao;

import com.questions.dto.QuestionsDto;
import com.questions.entity.QuestionsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionsDao {
    //搜索题目
    List<QuestionsDto> searchQuestion(String word,String queClassId,Integer pageSize,Integer pageNum);
    //搜索题目梳理（分页）
    Integer searchQuesNum(String word,String queClassId);
    void addQuestion(QuestionsDto questionsDto);
    void deleteQuestion(QuestionsDto questionsDto);
}
