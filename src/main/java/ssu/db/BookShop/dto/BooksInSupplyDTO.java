package ssu.db.BookShop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooksInSupplyDTO {

    private Integer idSupply;
    private Integer idBook;
    private Integer quantityInSupply;
    private Integer bookPrice;
}
