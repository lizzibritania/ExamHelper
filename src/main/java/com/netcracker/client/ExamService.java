package main.java.com.netcracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import main.java.com.netcracker.shared.Exam;

import java.util.List;

@RemoteServiceRelativePath("springGwtServices/ExamService")
public interface ExamService extends RemoteService  {




    void addExam(String author, String text);

    void updateExam(String author, String text);

    void deleteExam(String text);


    List <Exam> getExams();


}