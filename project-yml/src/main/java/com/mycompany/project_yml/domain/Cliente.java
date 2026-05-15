package com.mycompany.project_yml.domain;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    @JsonIgnoreProperties(value = {"clientes"}, allowSetters = true)
    private TipoDocumento tipoDocumento;

    @DocumentReference
    @Field("cuenta")
    private Cuenta cuenta;

    @DBRef
    @Field("facturas")
    @JsonIgnoreProperties(value = { "cliente" }, allowSetters = true)
    private Set<Factura> facturaSet = new HashSet<>();

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

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Cliente cliente)) return false;

        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    public Set<Factura> getFacturaSet() {
        return facturaSet;
    }

    public void setFacturaSet(Set<Factura> facturaSet) {
        this.facturaSet = facturaSet;
    }
}
