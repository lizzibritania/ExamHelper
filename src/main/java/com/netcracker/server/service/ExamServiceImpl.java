package main.java.com.netcracker.server.service;


import main.java.com.netcracker.client.ExamService;
import main.java.com.netcracker.server.persistence.ExamMapper;
import main.java.com.netcracker.shared.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ExamService")
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper ExamMapper;


    @Override
    public void addExam(String author, String text) {
        ExamMapper.addExam(author, text);
    }

    @Override
    public void updateExam(String author, String text) {
        ExamMapper.updateExam(author, text);
    }

    @Override
    public void deleteExam(String text) {
        ExamMapper.deleteExam(text);
    }

    @Override
    public List<Exam> getExams() {
        return ExamMapper.getExams();
    }
}