package ssu.db.BookShop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ssu.db.BookShop.entity.Staff;
import ssu.db.BookShop.service.StaffService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/getAll")
    public List<Staff> getAllStaff(){
        return staffService.getAllStaff();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public void createStaff(@RequestBody Staff staff){
        staffService.createStaff(staff);
    }
}
