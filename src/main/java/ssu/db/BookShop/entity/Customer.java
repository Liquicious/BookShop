package ssu.db.BookShop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id_customer", nullable = false)
    private Integer id;

    @Column(name = "customer_name", nullable = false, length = 30)
    private String customerName;

    @Column(name = "customer_sex", nullable = false, length = 10)
    private String customerSex;

    @Column(name = "customer_age", nullable = false)
    private Integer customerAge;

}