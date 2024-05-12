package ssu.db.BookShop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private Integer id;
    private String customerName;
    private String customerSex;
    private Integer customerAge;
}
