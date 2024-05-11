package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.entity.Staff;
import ssu.db.BookShop.repository.StaffRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {

    private StaffRepository staffRepository;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public void createStaff(Staff staff) {
        staffRepository.save(staff);
    }
}
