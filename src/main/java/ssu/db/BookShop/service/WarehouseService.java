package ssu.db.BookShop.service;

import ssu.db.BookShop.entity.Warehouse;

import java.util.List;

public interface WarehouseService {

    List<Warehouse> getAllWarehouses();

    void createWarehouse(Warehouse warehouse);
}
