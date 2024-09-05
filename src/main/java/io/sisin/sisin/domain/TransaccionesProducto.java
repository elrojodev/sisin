package io.sisin.sisin.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "TransaccionesProducto")
@Getter
@Setter
public class TransaccionesProducto {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tcoId;

    @Column(nullable = false)
    private Integer tcoUnidades;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tco_tce_id", nullable = false)
    private Transaccion tcoTce;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tco_pro_id", nullable = false)
    private Producto tcoPro;

}
