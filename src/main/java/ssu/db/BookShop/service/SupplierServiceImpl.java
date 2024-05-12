package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.dto.SupplierDTO;
import ssu.db.BookShop.dto.SupplierMapper;
import ssu.db.BookShop.entity.Supplier;
import ssu.db.BookShop.repository.SupplierRepostiory;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class SupplierServiceImpl implements  SupplierService{

    private SupplierRepostiory supplierRepostiory;
    private SupplierMapper supplierMapper;

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        List<Supplier> supplierList = supplierRepostiory.findAll();
        List<SupplierDTO> supplierDTOList = new ArrayList<>();
        for (Supplier supplier : supplierList) {
            supplierDTOList.add(supplierMapper.supplierToSupplierDTO(supplier));
        }
        return supplierDTOList;
    }

    @Override
    public void createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = supplierMapper.supplierDTOToSupplier(supplierDTO);
        supplierRepostiory.save(supplier);
    }

    @Override
    public SupplierDTO getSupplierById(int id) {
        return supplierMapper.supplierToSupplierDTO(supplierRepostiory.findById(id).get());
    }
}
