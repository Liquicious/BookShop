package ssu.db.BookShop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WarehouseDTO {

    private Integer id;
    private String adressWarehouse;
    private List<BooksAtWarehouseDTO> booksAtWarehouses;
    private List<StaffDTO> staff;
}
