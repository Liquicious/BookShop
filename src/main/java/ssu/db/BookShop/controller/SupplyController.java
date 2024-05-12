package ssu.db.BookShop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ssu.db.BookShop.dto.SupplyDTO;
import ssu.db.BookShop.service.SupplyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supply")
public class SupplyController {

    private final SupplyService supplyService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/getAll")
    public List<SupplyDTO> getAll() {
        return supplyService.getAllSupplies();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public void create(@RequestBody SupplyDTO supply) {
        supplyService.createSupply(supply);
    }
}
