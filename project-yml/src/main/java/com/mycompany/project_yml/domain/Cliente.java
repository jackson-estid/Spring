package com.mycompany.project_yml.domain;



import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;

@Document(collection = "cliente")
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID =1L;

    @Id
    private String id;

    @NonNull
    @Size
    @Field("numero_documento")
    private String numerodocumento;


    @NonNull
    @Size
    @Field("primerNombre")
    private String primerNombre;

    @Size
    @Field("segundoNombre")
    private String segundoNombre;

    @NonNull
    @Size
    @Field("primerApellido")
    private String primerApellido;

    @Size
    @Field("segundoApellido")
    private String segundoApellido;

    @DBRef
    @Field("tipo_documento")
    private TipoDocumento tipoDocumento;


    public Cliente(String id, @NonNull String numerodocumento,@NonNull String primerNombre, String segundoNombre,@NonNull  String primerApellido, String segundoApellido) {
        this.id = id;
        this.numerodocumento = numerodocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(@NonNull String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
