package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssu.db.BookShop.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
