package com.appprenotazione.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;

public class UtenteDTO {

    @NotNull
    @Size(min = 1, max = 45)
    private String nome;

    @NotNull
    @Size(min = 1, max = 45)
    private String cognome;

    @NotNull
    @Size(min = 5, max = 45)
    private String email;

    @NotNull
    @Size(min = 1, max = 64)
    private String password;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String telefono;

    @NotNull
    private String tipoUtente;

    @NotNull
    private Integer idSede;


    public UtenteDTO(String nome, String cognome, String email, String password, String telefono, String tipoUtente, Integer idSede) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.tipoUtente = tipoUtente;
        this.idSede = idSede;
    }

    public UtenteDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoUtente() {
        return tipoUtente;
    }

    public void setTipoUtente(String tipoUtente) {
        this.tipoUtente = tipoUtente;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }
}
