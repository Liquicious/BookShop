package ssu.db.BookShop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffDTO {

    private Integer id;
    private String employeeName;
    private String employeeSex;
    private String jobTitle;
    private Integer experience;
    private Integer idWarehouse;
}
