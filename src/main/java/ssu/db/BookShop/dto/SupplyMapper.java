package ssu.db.BookShop.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ssu.db.BookShop.entity.Supply;
import ssu.db.BookShop.service.SupplierService;
import ssu.db.BookShop.service.WarehouseService;

@Mapper(componentModel = "spring")
public abstract class SupplyMapper {

    @Autowired
    WarehouseService warehouseService;
    @Autowired
    WarehouseMapper warehouseMapper;
    @Autowired
    SupplierService supplierService;
    @Autowired
    SupplierMapper supplierMapper;

    @Mapping(target = "idSupplier", expression = "java(supplierMapper.supplierDTOToSupplier(supplierService.getSupplierById(supplyDTO.getIdWarehouse())))")
    @Mapping(target = "idWarehouse", expression = "java(warehouseMapper.warehouseDTOToWarehouse(warehouseService.getWarehouseById(supplyDTO.getIdWarehouse())))")
    public abstract Supply supplyDTOToSupply(SupplyDTO supplyDTO);

    @Mapping(target = "idSupplier", expression = "java(supply.getIdSupplier().getId())")
    @Mapping(target = "idWarehouse", expression = "java(supply.getIdWarehouse().getId())")
    public abstract SupplyDTO supplyToSupplyDTO(Supply supply);
}
