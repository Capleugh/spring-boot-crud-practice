package com.spring_boot_crud_app.demo.service;

import com.spring_boot_crud_app.demo.dao.StudentDao;
import com.spring_boot_crud_app.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
//    this annotation allows us to wire our @Repository to our service layer
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
//        the @Qualifier annotation allows us to wire up the specific @Repository we want to use
//        only necessary if there are multiple implementations of our Dao interface, so we could get away with
//        not using it here.
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID studentId, Student student) {
        UUID studentUid = studentId == null ? UUID.randomUUID() : studentId;
        return studentDao.insertNewStudent(studentUid, student);
    }

    public Student getStudentById(UUID studentId) {
        return studentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public int updateStudentById(UUID studentId, Student studentUpdate) {
        return studentDao.updateStudentById(studentId, studentUpdate);
    }

    public int deleteStudentById(UUID studentId) {
        return studentDao.deleteStudentById(studentId);
    }
}
