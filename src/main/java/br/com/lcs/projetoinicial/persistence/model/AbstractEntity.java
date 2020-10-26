package br.com.lcs.projetoinicial.persistence.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean equals(Object object) {
        if (object instanceof AbstractEntity) {
            if (object.getClass() == this.getClass()) {
                if (getId() != null && ((AbstractEntity) object).getId().equals(getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
