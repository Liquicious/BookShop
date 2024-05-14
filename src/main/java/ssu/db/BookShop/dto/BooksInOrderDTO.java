package ssu.db.BookShop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooksInOrderDTO {

    private Integer idOrder;
    private Integer idBook;
    private Integer quantityInOrder;
    private Integer idSupply;
}
