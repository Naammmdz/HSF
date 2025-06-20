package org.naammm.superapp.entity.bidirectional;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String name;

    //1 chuyên ngành có nhiều sinh viên, tức là major phải chứa 1 arraylist student
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "major")
    private List<Student> stuList = new ArrayList<>();
    //stuList.add(đưa 1 sinh vien vào major)
    //stiList.remove(1 sinh viên đổi chuyên ngành)
    //Viết code ở đâu với 2 lệnh này??? nguyên lí solid
    //                                            SRP
    //Single responsibilit priciple
    //thêm xóa sv khỏi chuên ngành, là việc của Major
    //2 hàm thêm xóa sinh viên thuộc class này
    public void addStudent(Student student) {
        stuList.add(student);
        // nhưng chưa nói được sv đang có thực sự trỏ về, lưu info chuyên ngành hay không, info major của sinh vien chưa được set giá trị
        // ta cần 2 câu: major có sinh viên gia nhập -> done qua lệnh stuList.add
        //student thuộc về major này (this) -> done
        student.setMajor(this); //đặt major cho sinh viên, để biết major này là của ai
    }

    public void removeStudent(Student student) {
        stuList.remove(student);
        student.setMajor(null);
    }

    //có câu query trong db: chuyên ngàng se có bao nhiêu student
    //select * from student where majorid = 'SE'
    //OOP; Major nà đang có list student, mình return là xong
    //Hàm GET() truyền thống;


    //mapped by giúp kết nối ngược với bạn Student, để biết cái major bạn ấ đang
    //giữ có cái major, id khớp với id đang đứng hay không
    //Major nối với Student qua đặc điểm Major major bên student
    //object quan hệ với nhau, đúng chuẩn oop:

    public List<Student> getStudents() {
        return stuList;
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
        return String.format("|%2s|%-40s|", id, name);
    }
}
