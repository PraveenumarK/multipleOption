package com.apexon.nest.multipleOption.service;

import com.apexon.nest.multipleOption.dto.QuestionRequest;
import com.apexon.nest.multipleOption.model.Question;
import com.apexon.nest.multipleOption.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByTopic(String topic) {
        return questionRepository.findByTopic(topic);
    }

    public Question addQuestion(QuestionRequest request) {
        Question question = new Question();
        question.setTopic(request.getTopic());
        question.setDescription(request.getDescription());
        question.setOptionA(request.getOptionA());
        question.setOptionB(request.getOptionB());
        question.setOptionC(request.getOptionC());
        question.setOptionD(request.getOptionD());
        question.setCorrectOption(request.getCorrectOption());
        question.setExplanation(request.getExplanation());
        question.setCorrect(request.isCorrect()); // default
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
