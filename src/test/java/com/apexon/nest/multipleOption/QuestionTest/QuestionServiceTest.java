package com.apexon.nest.multipleOption.QuestionTest;

import com.apexon.nest.multipleOption.dto.CreateOption;
import com.apexon.nest.multipleOption.dto.CreateQuestionRequest;
import com.apexon.nest.multipleOption.model.Question;
import com.apexon.nest.multipleOption.model.Topic;
import com.apexon.nest.multipleOption.repository.QuestionRepository;
import com.apexon.nest.multipleOption.repository.TopicRepository;
import com.apexon.nest.multipleOption.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class QuestionServiceTest {

    @Mock
    private TopicRepository topicRepository;

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveQuestion_WithThreadTopic_Success() {
        // Step 1: Prepare input
        CreateQuestionRequest request = new CreateQuestionRequest();
        request.setTopicName("Thread");
        request.setDescription("What is the main purpose of the synchronized keyword in Java?");
        request.setExplanation("The synchronized keyword is used to prevent thread interference and memory consistency errors by allowing only one thread to access a block of code or method at a time.");

        List<CreateOption> options = Arrays.asList(
                new CreateOption("To pause the execution of a thread", "Incorrect - 'wait()' or 'sleep()' is used for pausing, not 'synchronized'.", false),
                new CreateOption("To start multiple threads", "Incorrect - Threads are started using the 'start()' method.", false),
                new CreateOption("To restrict access to critical sections", "Correct - It ensures only one thread accesses the synchronized code at a time.", true),
                new CreateOption("To terminate threads safely", "Incorrect - Java provides other mechanisms for stopping threads gracefully.", false)
        );
        request.setOptions(options);

        // Step 2: Mock topic
        Topic threadTopic = new Topic();
        threadTopic.setId(1L);
        threadTopic.setTopicName("Thread");

        // Step 3: Mock saved question
        Question savedQuestion = new Question();
        savedQuestion.setId(101L);
        savedQuestion.setTopic(threadTopic);
        savedQuestion.setDescription(request.getDescription());
        savedQuestion.setExplanation(request.getExplanation());

        // Step 4: Define mock behavior
        when(topicRepository.findByTopicName("Thread")).thenReturn(Optional.of(threadTopic));
        when(questionRepository.save(any(Question.class))).thenReturn(savedQuestion);

        // Step 5: Call service method
        Question result = questionService.saveQuestion(request);

        // Step 6: Assertions
        assertNotNull(result);
        assertEquals("Thread", result.getTopic().getTopicName());
        assertEquals("What is the main purpose of the synchronized keyword in Java?", result.getDescription());

        // Step 7: Verify interactions
        verify(topicRepository, times(1)).findByTopicName("Thread");
        verify(questionRepository, times(1)).save(any(Question.class));
    }
}
