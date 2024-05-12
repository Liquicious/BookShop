package ssu.db.BookShop.service;

import ssu.db.BookShop.dto.StaffDTO;

import java.util.List;

public interface StaffService {

    List<StaffDTO> getAllStaff();

    void createStaff(StaffDTO staff);
}
