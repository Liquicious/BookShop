package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.dto.SupplyDTO;
import ssu.db.BookShop.dto.SupplyMapper;
import ssu.db.BookShop.entity.Supply;
import ssu.db.BookShop.repository.SupplyRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class SupplyServiceImpl implements SupplyService {

    private SupplyRepository supplyRepository;
    private SupplyMapper supplyMapper;

    @Override
    public List<SupplyDTO> getAllSupplies() {
        List<Supply> supplyList = supplyRepository.findAll();
        List<SupplyDTO> supplyDTOList = new ArrayList<>();
        for (Supply supply : supplyList) {
            supplyDTOList.add(supplyMapper.supplyToSupplyDTO(supply));
        }
        return supplyDTOList;
    }

    @Override
    public void createSupply(SupplyDTO supplyDTO) {
        Supply supply = supplyMapper.supplyDTOToSupply(supplyDTO);
        supplyRepository.save(supply);
    }
}
