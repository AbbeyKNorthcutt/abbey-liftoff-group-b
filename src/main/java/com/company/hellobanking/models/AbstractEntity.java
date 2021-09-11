package com.company.hellobanking.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


/*Id generated for each user*/
@MappedSuperclass
@Table(name = "user")
public abstract class AbstractEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id);}

}
