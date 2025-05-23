package com.naammm.fap.entity;

public class Subject {
    private  String code;
    private String name;
    private int credit;
    private double hours;

    //KHI CHƠI VỚI TABLE, TỨC LÀ
    //- CLASS SẼ MAP THÀNH CẤU TRÚC TABLE
    //- NEW SUBJECT("SWT301", "Software Testing", 3, 45);
    //- TƯƠNG ỨNG VỚI CÁC

    //TOÀN BỘ CODE NÀY RẤT QUAN TRỌNG VÌ GIÚP TA TẠO RA OBJECT
    //1 CÁCH LINH HOẠT (TẠO - NEW, CHỈNH SỬA - SET, HỎI INFO - GET, SHOW INFO - TOSTRING)
    //NHƯNG NHÀM CHÁN, KO THÊM TƯ DUY GÌ THÊM
    //ĐOẠN CODE NHÀM CHÁN, NHUNG VẪN PHẢI LÀM, KO THỂ THIẾU -> GỌI LÀ BOILER PLATE
    public Subject() {
    }

    public Subject(String code, String name, int credit, double hours) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.hours = hours;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", credit='" + credit + '\'' +
                ", hours=" + hours +
                '}';
    }
}
