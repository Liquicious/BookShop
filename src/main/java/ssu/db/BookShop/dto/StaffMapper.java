package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ssu.db.BookShop.entity.Staff;
import ssu.db.BookShop.service.WarehouseService;

@Mapper(componentModel = "spring")
public abstract class StaffMapper {

    @Autowired
    WarehouseService warehouseService;
    @Autowired
    WarehouseMapper warehouseMapper;

    @Mapping(target = "idWarehouse", expression = "java(warehouseMapper.warehouseDTOToWarehouse(warehouseService.getWarehouseById(staffDTO.getIdWarehouse())))")
    public abstract Staff StaffDTOToStaff(StaffDTO staffDTO);

    @Mapping(target = "idWarehouse", expression = "java(staff.getIdWarehouse().getId())")
    public abstract StaffDTO StaffToStaffDTO(Staff staff);
}
