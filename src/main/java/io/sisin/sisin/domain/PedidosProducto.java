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
@Table(name = "PedidosProducto")
@Getter
@Setter
public class PedidosProducto {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pptId;

    @Column(nullable = false)
    private Integer pptCantidad;

    @Column(nullable = false)
    private Integer pptPrecioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ppt_pca_id", nullable = false)
    private PedidosCompra pptPca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ppt_pro_id", nullable = false)
    private Producto pptPro;

}
