package com.spring_boot_crud_app.demo.dao;

import com.spring_boot_crud_app.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
// @Component is an annotation that allows us to us create an instance of FakeStudentDaoImpl
// but this annotation can be used anywhere

// spring allows us to distinguish between the classes that we have
// this class serves as a data access point for our database
// @Repository lets any client for this database know that this is a repository
// if we have multiple implementations of StudentDao, we distinguish between them by passing a value to @Repository
//
public class FakeStudentDaoImpl implements StudentDao {

    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl() {
        database = new HashMap<>();
        UUID studentId = UUID.randomUUID();
        database.put(studentId, new Student(studentId, 24, "Alex", "Montana", "Comp Sci")
        );
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId, student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        database.put(studentId, studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }
}
