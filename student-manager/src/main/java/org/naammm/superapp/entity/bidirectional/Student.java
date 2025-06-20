package org.naammm.superapp.entity.bidirectional;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
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

    //SV THUỘC VỀ 1 MAJOR TẠI 1 THỜI ĐIỂM, 1 BIẾN MAJOR MÀ THOY, KHÔNG PHẢI LÀ LIST NHƯ BÊN KIA

    //cả Major và Student đều có quyền khai báo
    //JoinColumn, nếu dùng uni-directional relationship
    @ManyToOne
    @JoinColumn(name = "MajorId", referencedColumnName = "Id")
    private Major major;

    public Major getMajor() {
        return major;
    }
    public void setMajor(Major major) {
        this.major = major;
    }

    public Student() {}
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
        return String.format("|%2s|%-40s|%4d|%4.1f|", id, name, yob, gpa);
    }

}
