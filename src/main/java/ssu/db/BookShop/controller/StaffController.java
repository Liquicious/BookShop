package ssu.db.BookShop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ssu.db.BookShop.dto.StaffDTO;
import ssu.db.BookShop.service.StaffService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    //@Secured("ROLE_ADMIN")
    @GetMapping("/getAll")
    public List<StaffDTO> getAllStaff(){
        return staffService.getAllStaff();
    }

    //@Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public void createStaff(@RequestBody StaffDTO staff){
        staffService.createStaff(staff);
    }
}
