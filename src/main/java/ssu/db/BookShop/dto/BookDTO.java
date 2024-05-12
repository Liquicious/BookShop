package ssu.db.BookShop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    private Integer id;
    private String bookName;
    private String author;
    private Integer yearOfWriting;
    private String country;
}
