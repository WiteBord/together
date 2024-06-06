package com.questions.serviceImpl;

import com.questions.dao.OptionsDao;
import com.questions.dao.QuesClassDao;
import com.questions.dao.QuestionsDao;
import com.questions.dto.QuestionsDto;
import com.questions.entity.OptionsEntity;
import com.questions.entity.QuesClassEntity;
import com.questions.service.QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class QueServiceImpl implements QueService {

    @Autowired
    QuestionsDao questionsDao;
    @Autowired
    OptionsDao optionsDao;
    @Autowired
    QuesClassDao quesClassDao;



    @Override
    //TODO: 一瞬千击，数据库爆破隐患
    public List<QuestionsDto> searchQuestion(String word,String queClassId) {
        List<QuestionsDto> questionsList=questionsDao.searchQuestion(word,queClassId);//关键词搜题


        for(QuestionsDto que : questionsList){
            String id=que.getId();//题目id
            List<OptionsEntity> optionsEntityList=optionsDao.selectOneQue(id);//单个题目对应选项
            que.setOptionsEntityList(optionsEntityList);//塞进去
        }

        return questionsList;
    }

    @Override
    public List<QuesClassEntity> getQuesClass() {
        return quesClassDao.getQuesClass();
    }
}
