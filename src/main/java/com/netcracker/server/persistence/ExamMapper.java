package main.java.com.netcracker.server.persistence;


import main.java.com.netcracker.shared.Exam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExamMapper {

    @Select("SELECT * FROM Exam")
    Exam getExam(@Param("text") String text);

    @Select("INSERT INTO Exam (author, text) VALUES (#{author}, #{text})")
    void addExam(@Param("author") String author, @Param("text") String text);

    @Select("UPDATE Exam SET author = #{author} WHERE text = #{text}")
    void updateExam(@Param("author") String author, @Param("text") String text);

    @Select("DELETE FROM Exam WHERE text = #{text}")
    void deleteExam(@Param("text") String text);

    @Select("SELECT * FROM Exam")
    List<Exam> getExams();
}