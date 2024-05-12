package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import ssu.db.BookShop.entity.Warehouse;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {

    Warehouse warehouseDTOToWarehouse(WarehouseDTO warehouseDTO);
    WarehouseDTO warehouseToWarehouseDTO(Warehouse warehouse);
}
