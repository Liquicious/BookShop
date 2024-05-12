package ssu.db.BookShop.service;

import ssu.db.BookShop.dto.SupplyDTO;

import java.util.List;

public interface SupplyService {

    List<SupplyDTO> getAllSupplies();

    void createSupply(SupplyDTO supplyDTO);
}
