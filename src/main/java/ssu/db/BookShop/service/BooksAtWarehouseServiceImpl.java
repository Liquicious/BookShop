package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.dto.BooksAtWarehouseDTO;
import ssu.db.BookShop.dto.BooksAtWarehouseMapper;
import ssu.db.BookShop.entity.BooksAtWarehouse;
import ssu.db.BookShop.repository.BooksAtWarehouseRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BooksAtWarehouseServiceImpl implements BooksAtWarehouseService {

    private BooksAtWarehouseRepository booksAtWarehouseRepository;
    private BooksAtWarehouseMapper booksAtWarehouseMapper;

    @Override
    public List<BooksAtWarehouseDTO> getAllBooksAtWarehouse() {
        List<BooksAtWarehouse> booksAtWarehouseList = booksAtWarehouseRepository.findAll();
        List<BooksAtWarehouseDTO> booksAtWarehouseDTOList = new ArrayList<>();
        for (BooksAtWarehouse bookAtWarehouse : booksAtWarehouseList) {
            booksAtWarehouseDTOList.add(booksAtWarehouseMapper.booksAtWarehouseToBooksAtWarehouseDTO(bookAtWarehouse));
        }
        return booksAtWarehouseDTOList;
    }

    @Override
    public void createBooksAtWarehouse(BooksAtWarehouseDTO booksAtWarehouseDTO) {
        BooksAtWarehouse booksAtWarehouse = booksAtWarehouseMapper.booksAtWarehouseDTOToBooksAtWarehouse(booksAtWarehouseDTO);
        booksAtWarehouseRepository.save(booksAtWarehouse);
    }
}
