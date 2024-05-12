package ssu.db.BookShop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ssu.db.BookShop.dto.WarehouseDTO;
import ssu.db.BookShop.service.WarehouseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/getAll")
    public List<WarehouseDTO> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public void createWarehouse(@RequestBody WarehouseDTO warehouse) {
        warehouseService.createWarehouse(warehouse);
    }
}
