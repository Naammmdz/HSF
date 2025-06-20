package org.naammm.superapp.entity.unione;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)") // thiếu coloumnDefinition sẽ thành varchar255
    private String id; // Id của Major

    @Column(name = "Name", columnDefinition = "NVARCHAR(255)", nullable = false) // nullable = false là bắt buộc nhập
    private String name; // Tên của Major


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //nhờ câu này thì bảng table Student xuất hiện và nó sẽ đòi fk
    @JoinColumn(name = "MajorId", referencedColumnName = "Id") // tên cột trong bảng Student sẽ là MajorId
    private List<Student> students = new ArrayList<>();
    //để có cụ thể sv nào, ta gọi students.add
    // add 1 phần tử vào trong ArrayList

    //HÀM ADD SINH VIÊN VÀO LIST, PUBLIC
    public void addStudent(Student student) {
        //IF ELSE LOGIC KIỂM SOÁT INFO BÊN NGOÀI ĐI VÀ TRONG OBJECT
        students.add(student);
    }

    public Major() {
    }
    public Major(String id, String name) {
        this.id = id;
        this.name = name;
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
    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
