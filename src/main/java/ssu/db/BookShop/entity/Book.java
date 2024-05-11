package ssu.db.BookShop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book", nullable = false)
    private Integer id;

    @Column(name = "book_name", nullable = false, length = 30)
    private String bookName;

    @Column(name = "author", nullable = false, length = 30)
    private String author;

    @Column(name = "year_of_writing", nullable = false)
    private Integer yearOfWriting;

    @Column(name = "country", nullable = false, length = 30)
    private String country;

}