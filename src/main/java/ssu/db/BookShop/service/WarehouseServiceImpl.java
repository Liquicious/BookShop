package ssu.db.BookShop.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.entity.Warehouse;
import ssu.db.BookShop.repository.WarehouseRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public void createWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }
}
