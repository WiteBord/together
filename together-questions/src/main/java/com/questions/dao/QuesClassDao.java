package com.questions.dao;

import com.questions.dto.QuestionsDto;
import com.questions.entity.QuesClassEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuesClassDao {
    /*
    查
     */
    List<QuesClassEntity> getQuesClass();
    /*
    增
     */
    void addQuesClass(String className);
    void updateQuesClass(QuesClassEntity quesClassEntity);
    void deleteQuesClass(QuesClassEntity quesClassEntity);

}
