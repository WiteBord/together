package com.questions.dao;

import com.questions.entity.OptionsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OptionsDao {
    List<OptionsEntity> selectAll();
    List<OptionsEntity> selectOneQue(String questionsId);
}
