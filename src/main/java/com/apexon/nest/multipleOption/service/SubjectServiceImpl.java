package com.apexon.nest.multipleOption.service;

import com.apexon.nest.multipleOption.model.Subject;
import com.apexon.nest.multipleOption.model.Topic;
import com.apexon.nest.multipleOption.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {


    private final SubjectRepository repo;

    @Autowired
    public SubjectServiceImpl(SubjectRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Subject saveSubject(Subject vo) {
        List<Topic> topics = vo.getTopics();
        if (!topics.isEmpty()) {
            for (Topic topic : topics) {
                topic.setSubject(vo);
            }
        }
       /* List<Subject> subjects = repo.findAll();
        boolean isExisted = subjects.stream().filter(subject ->  {
            if (subject.getSubjectName().equals(vo.getSubjectName())) {
                return true;
            }
        return false;}).isParallel();*/
       // if (!isExisted) {
            return repo.save(vo);
       // }
       // return new Subject();
    }
    @Override
    public Subject getSubjectWithTopics(Long id) {
        Optional<Subject> subject = repo.findById(id);
        if (subject.isPresent()) {
            return subject.get();
        }
        return null;
    }
}
