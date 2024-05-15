package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ssu.db.BookShop.entity.Staff;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface StaffMapper {

    @Mapping(target = "idWarehouse.id", source = "idWarehouse")
    Staff StaffDTOToStaff(StaffDTO staffDTO);

    @Mapping(target = "idWarehouse", source = "staff.idWarehouse.id")
    StaffDTO StaffToStaffDTO(Staff staff);
}
