package org.naammm.coffee.repository;

import org.naammm.coffee.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// CategoryRepo là một interface mở rộng JpaRepository, cho phép chúng ta truy cập và thao tác với dữ liệu Category trong cơ sở dữ liệu.
//chính thức vào thế giới Spring Data > Spring JPA/Hibernate
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    // JpaRepository đã có sẵn các phương thức CRUD cơ bản
    // NHƯNG BẠN VẪN CÓ THẺ ĐỘ CÂU QUẺY RIÊNG (JPQL, SQL NATIVE) ĐƯỢC LUÔN
}
