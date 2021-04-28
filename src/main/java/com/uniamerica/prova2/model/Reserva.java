package com.uniamerica.prova2.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reserva {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate data_retirada;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate data_devolucao;

    @ManyToOne
    private Carro carro;

    private Status status;

    public Reserva(Long id, LocalDate data_retirada, LocalDate data_devolucao, Carro carro, Status status) {
        this.id = id;
        this.data_retirada = data_retirada;
        this.data_devolucao = data_devolucao;
        this.carro = carro;
        this.status = status;
    }

    public Reserva() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData_retirada() {
        return data_retirada;
    }

    public void setData_retirada(LocalDate data_retirada) {
        this.data_retirada = data_retirada;
    }

    public LocalDate getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

