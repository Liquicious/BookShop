package ssu.db.BookShop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "books_in_supply")
public class BooksInSupply {
    @EmbeddedId
    private BooksInSupplyId id;

    @MapsId("idSupply")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_supply", nullable = false)
    private Supply idSupply;

    @MapsId("idBook")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_book", nullable = false)
    private Book idBook;

    @Column(name = "quantity_in_supply", nullable = false)
    private Integer quantityInSupply;

    @Column(name = "book_price", nullable = false)
    private Integer bookPrice;

}