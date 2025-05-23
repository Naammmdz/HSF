package com.naammm.fap.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String id;
    private String name;
    private int yob; // year of birth
    private double gpa;

    //TA KHÔNG LÀM THEO CÁCH TRUYỀN, NHƯNG VẪN PHẢI LÀM THEO CÁCH NÀO ĐÓ -> TA DÙNG THÊM 1 THƯ VIỆN TRÊN MẠNG GIÚP TA GENERATE 1 CÁCH TỰ ĐỘNG
    //LOMBOK DEPENDENCY
    //LÊN KHO TỔNG MNVREPOSITOR.COM -> TÌM THƯ VIỆN, TÌM HỒ SƠ, ADD VÒ POM.XML -> CLICK CTRL - SHIFT - 0 ĐỂ TẢI VÀ ADD
    //ĐI THI PE, XIN KHẢO THÍ VÀO INTERNET TẢI
}
