package ssu.db.BookShop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_warehouse", nullable = false)
    private Integer id;

    @Column(name = "adress_warehouse", nullable = false, length = 100)
    private String adressWarehouse;

    @OneToMany(mappedBy = "idWarehouse", cascade = CascadeType.ALL)
    private Set<BooksAtWarehouse> booksAtWarehouses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idWarehouse", cascade = CascadeType.ALL)
    private Set<Staff> staff = new LinkedHashSet<>();

}