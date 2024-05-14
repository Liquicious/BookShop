package ssu.db.BookShop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ssu.db.BookShop.dto.SupplierDTO;
import ssu.db.BookShop.service.SupplierService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/getAll")
    public List<SupplierDTO> getAll() {
        return supplierService.getAllSuppliers();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public void createSupplier(@RequestBody SupplierDTO supplier) {
        supplierService.createSupplier(supplier);
    }
}
