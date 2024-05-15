package ssu.db.BookShop.dto;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ssu.db.BookShop.entity.BooksAtWarehouse;
import ssu.db.BookShop.entity.BooksAtWarehouseId;

@Mapper(componentModel = "spring",
        imports = BooksAtWarehouseId.class,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface BooksAtWarehouseMapper {

    @Mapping(target = "id", expression = "java(new BooksAtWarehouseId(booksAtWarehouseDTO.getIdWarehouse(), booksAtWarehouseDTO.getIdBook()))")
    @Mapping(target = "idWarehouse.id", source = "idWarehouse")
    @Mapping(target = "idBook.id", source = "idBook")
    BooksAtWarehouse booksAtWarehouseDTOToBooksAtWarehouse(BooksAtWarehouseDTO booksAtWarehouseDTO);

    @BeanMapping(ignoreUnmappedSourceProperties = "id")
    @Mapping(target = "idWarehouse", source = "booksAtWarehouse.idWarehouse.id")
    @Mapping(target = "idBook", source = "booksAtWarehouse.idBook.id")
    BooksAtWarehouseDTO booksAtWarehouseToBooksAtWarehouseDTO(BooksAtWarehouse booksAtWarehouse);
}
