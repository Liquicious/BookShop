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
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @Column(name = "id_warehouse", nullable = false)
    private Integer id;

    @Column(name = "adress_warehouse", nullable = false, length = 100)
    private String adressWarehouse;

}