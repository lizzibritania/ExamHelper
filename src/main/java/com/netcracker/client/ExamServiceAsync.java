package main.java.com.netcracker.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import main.java.com.netcracker.shared.Exam;

import java.util.List;

public interface ExamServiceAsync {



    void addExam(String author, String text, AsyncCallback<Void> async);

    void updateExam(String author, String text, AsyncCallback<Void> async);

    void deleteExam(String text, AsyncCallback<Void> async);

    void getExams(AsyncCallback<List<Exam>> async);


}