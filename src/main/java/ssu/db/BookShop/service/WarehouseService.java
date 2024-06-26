package ssu.db.BookShop.service;

import ssu.db.BookShop.dto.WarehouseDTO;

import java.util.List;

public interface WarehouseService {

    List<WarehouseDTO> getAllWarehouses();

    void createWarehouse(WarehouseDTO warehouseDTO);

    WarehouseDTO getWarehouseById(int id);
}
