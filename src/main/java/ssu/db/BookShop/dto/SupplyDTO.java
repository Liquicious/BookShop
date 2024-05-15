package ssu.db.BookShop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SupplyDTO {

    private Integer id;
    private Integer idSupplier;
    private Integer idWarehouse;
    private LocalDate dateOfDelivery;
    private List<BooksInSupplyDTO> booksInSupplies;
}
