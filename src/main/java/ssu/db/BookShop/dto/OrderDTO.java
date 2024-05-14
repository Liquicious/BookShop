package ssu.db.BookShop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class OrderDTO {

    private Integer id;
    private Instant dateOfOrder;
    private Double orderCost;
    private Integer idCustomer;
    private Integer idWarehouse;
}
