package ru.daleshin.spring.service;

public class PropertyServiceImpl implements PropertyService {

    private String questionsFileName;
    
    public PropertyServiceImpl() {
    	questionsFileName = null;
    }
    
    public void setQuestionsFileName(String questionsFileName) {
        this.questionsFileName = questionsFileName;
    }
    
    public String getQuestionsFileName() {
        return questionsFileName;
    }
    
}
