package ssu.db.BookShop.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.dto.WarehouseDTO;
import ssu.db.BookShop.dto.WarehouseMapper;
import ssu.db.BookShop.entity.Warehouse;
import ssu.db.BookShop.repository.WarehouseRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;
    private WarehouseMapper warehouseMapper;

    @Override
    public List<WarehouseDTO> getAllWarehouses() {
        List<Warehouse> warehouseList = warehouseRepository.findAll();
        List<WarehouseDTO> warehouseDTOList = new ArrayList<>();
        for (Warehouse warehouse : warehouseList) {
            warehouseDTOList.add(warehouseMapper.warehouseToWarehouseDTO(warehouse));
        }
        return warehouseDTOList;
    }

    @Override
    public void createWarehouse(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = warehouseMapper.warehouseDTOToWarehouse(warehouseDTO);
        warehouseRepository.save(warehouse);
    }

    @Override
    public WarehouseDTO getWarehouseById(int id) {
        return warehouseMapper.warehouseToWarehouseDTO(warehouseRepository.findById(id).get());
    }
}
