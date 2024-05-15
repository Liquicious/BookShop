package ssu.db.BookShop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SupplierDTO {

    private Integer id;
    private String supplierName;
    private List<SupplyDTO> supplies;
}
