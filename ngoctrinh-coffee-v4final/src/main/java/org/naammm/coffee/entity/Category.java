package org.naammm.coffee.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id; //key tự tăng phải là Long wrapper (long)

    @Column(name = "Name", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String name;

    @Column(name = "Description", columnDefinition = "NVARCHAR(255)")
    private String description;

    @OneToMany(mappedBy = "cate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productList = new ArrayList<>();

    //các hàm để bổ sung sản phẩm vào cate, hay cho sản phaẩm ra khỏi cate
    //list product của cate nà ban dàu là rỗng, từ từ vào / ra
    public void addProduct(Product o){
        productList.add(o);
        o.setCate(this);
    }

    public void removeProduct(Product o){
        productList.remove(o);
        o.setCate(null); //xóa liên kết với cate
    }

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
