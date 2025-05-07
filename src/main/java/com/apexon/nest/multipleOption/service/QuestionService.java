package com.apexon.nest.multipleOption.service;

import com.apexon.nest.multipleOption.dto.CreateQuestionRequest;
import com.apexon.nest.multipleOption.model.Option;
import com.apexon.nest.multipleOption.model.Question;
import com.apexon.nest.multipleOption.model.Topic;
import com.apexon.nest.multipleOption.repository.QuestionRepository;
import com.apexon.nest.multipleOption.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TopicRepository topicRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question saveQuestion(CreateQuestionRequest request) {
        Question question = new Question();

        // Ensure request.getTopic() is not null
        String topicName = request.getTopicName();
        if (topicName == null || topicName.isEmpty()) {
            throw new RuntimeException("Topic name cannot be null or empty");
        }

        Topic topic = topicRepository.findByTopicName(topicName)
                .orElseThrow(() -> new RuntimeException("Topic not found: " + topicName));

        question.setTopic(topic);
        question.setDescription(request.getDescription());
        question.setExplanation(request.getExplanation());

        // Process the options
        List<Option> optionList = request.getOptions().stream().map(opt -> {
            Option option = new Option();
            option.setCorrect(opt.isCorrect());
            option.setExplanation(opt.getExplanation());
            option.setDescription(opt.getDescription());
            option.setQuestion(question);
            return option;
        }).collect(Collectors.toList());

        question.setOptions(optionList);

        return questionRepository.save(question);
    }
}

