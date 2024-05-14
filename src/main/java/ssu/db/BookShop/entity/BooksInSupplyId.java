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
public class BooksInSupplyId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 2270881351121126743L;
    @Column(name = "id_supply", nullable = false)
    private Integer idSupply;

    @Column(name = "id_book", nullable = false)
    private Integer idBook;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BooksInSupplyId entity = (BooksInSupplyId) o;
        return Objects.equals(this.idSupply, entity.idSupply) &&
                Objects.equals(this.idBook, entity.idBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSupply, idBook);
    }

}