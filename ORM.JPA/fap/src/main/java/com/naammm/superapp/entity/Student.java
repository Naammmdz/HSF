package com.naammm.superapp.entity;

import jakarta.persistence.*;
//import org.hibernate.annotations.Nationalized;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
@Table(name = "Student") //nếu không có khai báo này mặc định lấy tên class thành tên table!!!
public class Student {

    @Id
    @Column(name ="Id", columnDefinition = "CHAR(8)")// nếu không có khai báo này thì mặc định lấy tên biến thành tên cột
    private String id;//camelCase, id tự nhập

    @Column(name = "Name", nullable = false, length = 50, columnDefinition = "NVARCHAR(50)") //nullable = false nghĩa là không được null, length = 50 nghĩa là tối đa 50 ký tự
    public String name;
    //ta dùng nationnalize của hibernate sẽ mất đi tính khả chuyển khi code này không thể chơi được với nhà thầu eclipselink
    //độ varchar chơi với nhiều nhà cung cấp ORM/JPA qua columndefination
    //@Nationalized // Nationalized để hỗ trợ Unicode, nếu không có thì sẽ bị lỗi khi nhập tiếng Việt

    @Column(name = "YOB", nullable = false) // YOB: Year of Birth
    private int yob;

    @Column(name = "GPA", nullable = false) // GPA: Grade Point Average
    private double gpa;

    //Bắt buộc phải có constructor rỗng, constructor full tham số
    //GET()/SET()/TO STRING()
    //BOILER-PLATE, LOMBOK
    //THÊM DEPENDENCY LOMBOK SAU

    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
    }
}
