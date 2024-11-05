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
    public List<QuestionsDto> searchQuestion(String word,String queClassId,Integer pageSize,Integer pageNum) {
        List<QuestionsDto> questionsList=questionsDao.searchQuestion(word,queClassId,pageSize,pageNum);//关键词搜题


        for(QuestionsDto que : questionsList){
            String id=que.getId();//题目id
            List<OptionsEntity> optionsEntityList=optionsDao.selectOneQue(id);//单个题目对应选项
            que.setOptionsEntityList(optionsEntityList);//塞进去
        }

        return questionsList;
    }

    public Integer searchQuesNum(String word,String queClassId){
        Integer quesNum=questionsDao.searchQuesNum(word,queClassId);
        return quesNum;
    }


    @Override
    public List<QuesClassEntity> getQuesClass() {
        return quesClassDao.getQuesClass();
    }

    @Override
    public void addQuesClass(String className) {
        quesClassDao.addQuesClass(className);
    }

    @Override
    public void updateQuesClass(QuesClassEntity quesClassEntity) {
        quesClassDao.updateQuesClass(quesClassEntity);
    }

    @Override
    public void deleteQuesClass(QuesClassEntity quesClassEntity) {
        List<QuestionsDto> questionsList=questionsDao.searchQuestion("",quesClassEntity.getId(),null,null);//关键词搜题
        questionsList.forEach(this::deleteQuestion);
        quesClassDao.deleteQuesClass(quesClassEntity);
    }

    @Override
    public void addOptions(List<OptionsEntity> optionsEntityList) {
        optionsEntityList.forEach(opt -> optionsDao.addOption(opt));
    }

    @Override
    public String addQuestion(QuestionsDto questionsDto) {
        questionsDao.addQuestion(questionsDto);
        return questionsDto.getId();
    }

    @Override
    public void deleteQuestion(QuestionsDto questionsDto) {
        OptionsEntity optionsEntity=new OptionsEntity();
        optionsEntity.setQuestionsId(questionsDto.getId());
        optionsDao.deleteOptions(optionsEntity);

        questionsDao.deleteQuestion(questionsDto);
    }

    @Override
    public void deleteOptions(OptionsEntity optionsEntity) {
        optionsDao.deleteOptions(optionsEntity);
    }
}
