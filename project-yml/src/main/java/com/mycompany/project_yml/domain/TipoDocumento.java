package com.mycompany.project_yml.domain;

import com.mycompany.project_yml.domain.enumeration.Estado;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;

@Document(collection = "tipo_documento") //esta anotacion indica que clase va a ser un documento de mongo
public class TipoDocumento {

    @Serial
    private static final long serialversionUID =1L;

    @Id // indica que este campo es el indicador del documento mongo
    private String id;

    @Nonnull
    @Indexed(unique =true, name = "idx_unique_sigla")// crea indice unico en mongo
    @Field("sigla")
    @Size(max =10)
    private String sigla;

    @Nonnull
    @Indexed(unique =true, name = "idx_unique_nombre_documento")
    @Field("nombreDocumento")
    @Size(max =100)
    private String nombreDocumento;

    @Nonnull
    @Field("estado")
    private Estado estado;

    public TipoDocumento(String id, @Nonnull String sigla, @Nonnull String nombreDocumento, @Nonnull Estado estado) {
        this.id = id;
        this.sigla = sigla;
        this.nombreDocumento = nombreDocumento;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Nonnull
    public String getSigla() {
        return sigla;
    }

    public void setSigla(@Nonnull String sigla) {
        this.sigla = sigla;
    }

    @Nonnull
    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(@Nonnull String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    @Nonnull
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(@Nonnull Estado estado) {
        this.estado = estado;
    }
}