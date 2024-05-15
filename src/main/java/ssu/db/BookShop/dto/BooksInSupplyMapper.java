package ssu.db.BookShop.dto;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ssu.db.BookShop.entity.BooksInSupply;
import ssu.db.BookShop.entity.BooksInSupplyId;

@Mapper(componentModel = "spring",
        imports = BooksInSupplyId.class,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface BooksInSupplyMapper {

    @Mapping(target = "id", expression = "java(new BooksInSupplyId(booksInSupplyDTO.getIdSupply(), booksInSupplyDTO.getIdBook()))")
    @Mapping(target = "idSupply.id", source = "idSupply")
    @Mapping(target = "idBook.id", source = "idBook")
    BooksInSupply booksInSupplyDTOToBooksInSupply(BooksInSupplyDTO booksInSupplyDTO);

    @BeanMapping(ignoreUnmappedSourceProperties = "id")
    @Mapping(target = "idSupply", source = "booksInSupply.idSupply.id")
    @Mapping(target = "idBook", source = "booksInSupply.idBook.id")
    BooksInSupplyDTO booksInSupplyToBooksInSupplyDTO(BooksInSupply booksInSupply);
}
