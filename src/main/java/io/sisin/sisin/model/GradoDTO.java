package io.sisin.sisin.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GradoDTO {

    private Integer gdoId;

    @NotNull
    @Size(max = 45)
    @GradoGdoNombreUnique
    private String gdoNombre;

}
