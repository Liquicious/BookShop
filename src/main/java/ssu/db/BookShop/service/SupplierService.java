package ssu.db.BookShop.service;

import ssu.db.BookShop.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {

    List<SupplierDTO> getAllSuppliers();

    void createSupplier(SupplierDTO supplier);

    SupplierDTO getSupplierById(int id);
}
