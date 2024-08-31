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
@Table(name = "ContactoProveedors")
@Getter
@Setter
public class ContactoProveedor {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cveId;

    @Column(nullable = false, length = 45)
    private String cveNombre;

    @Column(nullable = false, length = 45)
    private String cpeTelefono;

    @Column(nullable = false, unique = true, length = 45)
    private String cpeEmail;

    @Column(nullable = false, length = 200)
    private String cpeUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpe_pve_id", nullable = false)
    private Proveedor cpePve;

}
