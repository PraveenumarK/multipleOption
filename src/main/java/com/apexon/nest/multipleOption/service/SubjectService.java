package com.apexon.nest.multipleOption.service;

import com.apexon.nest.multipleOption.model.Subject;
import com.apexon.nest.multipleOption.vo.SubjectTopicVO;
import org.springframework.stereotype.Service;

@Service
public interface SubjectService {

    public Subject saveSubject(Subject vo);
    public Subject getSubjectWithTopics(Long id);
}
