package com.questions.controller;

import com.questions.dao.OptionsDao;
import com.questions.dto.QuestionsDto;
import com.questions.entity.OptionsEntity;
import com.questions.entity.QuesClassEntity;
import com.questions.service.QueService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    OptionsDao optionsDao;

    @Autowired
    QueService queService;


    @GetMapping("/searchQues")//搜索
    public List<QuestionsDto> searchQues(String word,String queClassId,Integer pageSize,Integer pageNum){
        List<QuestionsDto> questionsList=new ArrayList<>();
        questionsList=queService.searchQuestion(word,queClassId,pageSize,pageNum);
        return questionsList;
    }

    @GetMapping("/searchQuesNum")//搜索
    public Integer searchQuesNum(String word,String queClassId){
        Integer QuesNum=queService.searchQuesNum(word,queClassId);
        return QuesNum;
    }


    @GetMapping("/getQuesClass")
    public List<QuesClassEntity> getQuesClass(){
        return queService.getQuesClass();
    }

    @PostMapping("/addQuesClass")
    public void addQuesClass(@RequestBody QuesClassEntity quesClassEntity){
        queService.addQuesClass(quesClassEntity.getText());
    }
    @PostMapping("/updateQuesClass")
    public String updateQuesClass(@RequestBody QuesClassEntity quesClassEntity){
        if(StringUtils.isEmpty(quesClassEntity.getText()))
        {
            return "无法设置为空";
        }
        queService.updateQuesClass(quesClassEntity);
        return "success";
    }
    @PostMapping("/deleteQuesClass")
    public void deleteQuesClass(@RequestBody QuesClassEntity quesClassEntity){
        queService.deleteQuesClass(quesClassEntity);
    }

    @PostMapping("/addQuestion")
    public String  addQuestion(@RequestBody QuestionsDto questionsDto){
        return queService.addQuestion(questionsDto);
    }

    @PostMapping("/addOptions")
    public void addOptions(@RequestBody List<OptionsEntity> optionsEntityList){
        queService.addOptions(optionsEntityList);
    }

    @PostMapping("/deleteOptions")
    public void deleteOptions(@RequestBody OptionsEntity optionsEntity){
        queService.deleteOptions(optionsEntity);
    }

    @PostMapping("/deleteQuestion")
    public void deleteQuestion(@RequestBody QuestionsDto questionsDto){
        queService.deleteQuestion(questionsDto);
    }
}
