package org.naammm.superapp.service;


import jakarta.persistence.EntityManager;
import org.naammm.superapp.entity.Student;
import org.naammm.superapp.repository.StudentRepo;

import java.util.List;

public class StudentService {
    //phải khai báo biến repo để repo giúp
    //

    private StudentRepo studentRepo = new StudentRepo();


    public void createStudent(Student student) {
        //to do: check trùng key
        //bắt tr catch thông báo
        studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void updateStudent(Student student) {
        studentRepo.update(student);
    }
    public void deleteStudent(Student student) {
        studentRepo.delete(student);
    }

}
