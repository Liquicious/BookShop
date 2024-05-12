package ssu.db.BookShop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssu.db.BookShop.dto.StaffDTO;
import ssu.db.BookShop.dto.StaffMapper;
import ssu.db.BookShop.entity.Staff;
import ssu.db.BookShop.repository.StaffRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {

    private StaffRepository staffRepository;
    private StaffMapper staffMapper;

    @Override
    public List<StaffDTO> getAllStaff() {
        List<Staff> staffList = staffRepository.findAll();
        List<StaffDTO> staffDTOList = new ArrayList<>();
        for (Staff staff : staffList) {
            staffDTOList.add(staffMapper.StaffToStaffDTO(staff));
        }
        return staffDTOList;
    }

    @Override
    public void createStaff(StaffDTO staffDTO) {
        Staff staff = staffMapper.StaffDTOToStaff(staffDTO);
        staffRepository.save(staff);
    }
}
