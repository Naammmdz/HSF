package org.naammm.superapp;

import org.naammm.superapp.entity.Student;
import org.naammm.superapp.service.StudentService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Student an = new Student("SE10", "AN NGUYỄN", 2005, 8.6);
        studentService.createStudent(an);
        studentService.createStudent(new Student("SE11", "HEHEHEHE", 2004, 6.0));


        System.out.println("The list student");
        studentService.getAllStudents().forEach(
                x -> System.out.println(x)
        );



    }
}