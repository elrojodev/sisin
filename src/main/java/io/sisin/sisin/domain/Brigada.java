package io.sisin.sisin.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Brigadas")
@Getter
@Setter
public class Brigada {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bgaId;

    @Column(nullable = false, length = 45)
    private String bgaNombre;

    @OneToMany(mappedBy = "undBga")
    private Set<Unidad> undBgaUnidades;

}
