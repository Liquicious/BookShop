package ssu.db.BookShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssu.db.BookShop.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
