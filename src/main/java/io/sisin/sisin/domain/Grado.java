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
@Table(name = "Gradoes")
@Getter
@Setter
public class Grado {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gdoId;

    @Column(nullable = false, unique = true, length = 45)
    private String gdoNombre;

    @OneToMany(mappedBy = "usrGdo")
    private Set<Usuario> usrGdoUsuarios;

}
