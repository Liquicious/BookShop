package ssu.db.BookShop.service;

import ssu.db.BookShop.entity.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> getAllStaff();

    void createStaff(Staff staff);
}
