package org.naammm.superapp.entity.unimany;

import jakarta.persistence.*;
//
//@Entity
//@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;


    //Nghĩ theo style TABLE/CSDL -> không đúng, tư duy opp
    //Nghĩ đúng, tư duy OP, các object có mối quan hệ
    //Tui student tham chiếu đến thông tin major - object
    //có cách đển convert từ oop thành table/fk, join column -> ORM MAPPING
    //CẦN 1 THẰNG GIÚP ÁNH XẠ 2 THẾ GIỚI ĐỂ CHO TƯƠNG THÍCH: JPA/HIBERNATE

    @ManyToOne
    @JoinColumn(name = "MajorId", referencedColumnName = "Id")
    private Major major; //làm sao biến này được set value để nói rằng
    // sinh viên này thuộc về chuyên ngành nào
    //câu hỏi này giống như bên major

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

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

