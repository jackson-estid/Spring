package com.mycompany.project_properties.domain;

public class Usuario {

    private String id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;


    public Usuario(String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido){
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }
    public String getId(){
        return id;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrimerApellido(String primerApellido){
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    @Override
    public String toString(){
        return "Usuario{" +
                "id=" + id + '\''+
                ", primerNombre'" + primerNombre + '\'' +
                ", segundoNombre'" + segundoNombre + '\'' +
                ", primerApelllido'" + primerApellido + '\'' +
                ", segundoApellido'" + segundoApellido + '\'' +
                '}';
    }
}




