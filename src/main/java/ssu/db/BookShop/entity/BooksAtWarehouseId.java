package ssu.db.BookShop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class BooksAtWarehouseId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = -528202428434847089L;
    @Column(name = "id_warehouse", nullable = false)
    private Integer idWarehouse;

    @Column(name = "id_book", nullable = false)
    private Integer idBook;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BooksAtWarehouseId entity = (BooksAtWarehouseId) o;
        return Objects.equals(this.idWarehouse, entity.idWarehouse) &&
                Objects.equals(this.idBook, entity.idBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWarehouse, idBook);
    }

}