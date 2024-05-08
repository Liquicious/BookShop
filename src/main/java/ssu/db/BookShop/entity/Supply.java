package ssu.db.BookShop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "supplies")
public class Supply {
    @Id
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

}