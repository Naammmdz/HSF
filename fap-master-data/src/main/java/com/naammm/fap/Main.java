package com.naammm.fap;

//import com.naammm.fap.entity.Subject;
//import com.naammm.fap.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naammm.fap.entity.*;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        //TẠO MỚI MÔN HỌC
        Subject swt = new Subject("SWT301", "Software Testing", 3, 45);
        Subject hsf = new Subject("HSF302", "HIBERNATE & SPRING FRAMEWORK", 3, 45);
        System.out.println(hsf);
        System.out.println(swt);

        //TẠO MỚI SINH VIÊN
        Student sv1 = new Student("PH22101", "Nguyen Van A", 2001, 8.5);
        Student sv2 = new Student("PH22102", "Nguyen Van B", 2002, 9.0);
        System.out.println(sv1.toString());
        System.out.println(sv2);

        //Chơi với Json, từ object thành json và ngược lại
        //Tạo object để quản lí json từ thư viện jackson
        ObjectMapper mapper = new ObjectMapper();
        String svJson = mapper.writeValueAsString(sv1);
        System.out.println("Json từ object mà ra: " + svJson);

        //Từ json thành object
        String svvJson = """
                {"id":"PH22101","name":"Nguyen Van A","yob":2001,"gpa":8.5}"""; //Rawstring có sao lưu vậy
        Student sv3 = mapper.readValue(svvJson, Student.class);
        System.out.println("Object từ json mà ra: " + sv3.toString());
    }
}

//Json: Javascript Object Notation
// Kĩ thuật biểu diễn của 1 object theo cú pháp ngôn ngữ javascript
// Code trên là 1 môn học, 1 sv cụ thể, nhưng nhìn text không dễ hiểu, không tự mô tả - self explanation
//Javascript thì more self explanation
//{"code": "SWT301", "name": "Software Testing", "credit": 3, "hours": 45}
//{"id": "PH22101", "name": "Nguyen Van A", "yob": 2001, "gpa": 8.5}

//-> Trở thành chuẩn truyền thông tin, đặc biệt được ưa thích trong web api
//Trong mô hình làm web app 2 cục fe be
//Front-end --- Json --- Back-end
//Cần 1 thư viện giúp convert qua lại Json -- Object
//Jackson, gson xuất hiện