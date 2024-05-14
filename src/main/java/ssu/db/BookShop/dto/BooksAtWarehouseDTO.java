package ssu.db.BookShop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooksAtWarehouseDTO {

    private Integer idWarehouse;
    private Integer idBook;
    private Integer quantityInStock;
}
