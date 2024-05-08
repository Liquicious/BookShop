package ssu.db.BookShop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "books_at_warehouse")
public class BooksAtWarehouse {
    @EmbeddedId
    private BooksAtWarehouseId id;

    @MapsId("idWarehouse")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_warehouse", nullable = false)
    private Warehouse idWarehouse;

    @MapsId("idBook")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_book", nullable = false)
    private Book idBook;

    @Column(name = "quantity_in_stock", nullable = false)
    private Integer quantityInStock;

}