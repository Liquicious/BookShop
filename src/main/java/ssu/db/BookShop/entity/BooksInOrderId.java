package ssu.db.BookShop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class BooksInOrderId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 8200473521795881925L;
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(name = "id_book", nullable = false)
    private Integer idBook;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BooksInOrderId entity = (BooksInOrderId) o;
        return Objects.equals(this.idOrder, entity.idOrder) &&
                Objects.equals(this.idBook, entity.idBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idBook);
    }

}