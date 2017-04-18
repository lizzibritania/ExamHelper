package main.java.com.netcracker.server.service;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import main.java.com.netcracker.client.ExamService;
import main.java.com.netcracker.server.persistence.ExamMapper;
import main.java.com.netcracker.shared.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ExamService")
public class ExamServiceImpl  extends RemoteServiceServlet implements ExamService {

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
        Exam exam=new Exam("","","","","","");
        ArrayList<Exam> arrayList=new ArrayList<Exam>();
        arrayList.add(exam);
        if (ExamMapper.getExams() == null )
            return arrayList;
       else  return ExamMapper.getExams();
    }
}