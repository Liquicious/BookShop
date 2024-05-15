package ssu.db.BookShop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "supplies")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supply", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_supplier", nullable = false)
    private Supplier idSupplier;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_warehouse", nullable = false)
    private Warehouse idWarehouse;

    @Column(name = "date_of_delivery", nullable = false)
    private LocalDate dateOfDelivery;

    @OneToMany(mappedBy = "idSupply", cascade = CascadeType.ALL)
    private Set<BooksInSupply> booksInSupplies = new LinkedHashSet<>();

}