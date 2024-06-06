package com.questions.dao;

import com.questions.dto.QuestionsDto;
import com.questions.entity.QuesClassEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuesClassDao {
    List<QuesClassEntity> getQuesClass();
}
