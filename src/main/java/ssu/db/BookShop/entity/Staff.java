package ssu.db.BookShop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "id_employee", nullable = false)
    private Integer id;

    @Column(name = "employee_name", nullable = false, length = 30)
    private String employeeName;

    @Column(name = "employee_sex", nullable = false, length = 10)
    private String employeeSex;

    @Column(name = "job_title", nullable = false, length = 20)
    private String jobTitle;

    @Column(name = "experience", nullable = false)
    private Integer experience;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_warehouse", nullable = false)
    private Warehouse idWarehouse;

}