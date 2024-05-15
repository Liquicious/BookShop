package ssu.db.BookShop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier", nullable = false)
    private Integer id;

    @Column(name = "supplier_name", nullable = false, length = 30)
    private String supplierName;

    @OneToMany(mappedBy = "idSupplier", cascade = CascadeType.ALL)
    private Set<Supply> supplies = new LinkedHashSet<>();

}