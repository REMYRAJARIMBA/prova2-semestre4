package com.uniamerica.prova2.repository;

import com.uniamerica.prova2.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    @Query("select q from Carro q left join Reserva r on q.id=r.carro.id where r.data_retirada >= :data_retirada " +
            "and r.data_devolucao <= :data_devolucao and r.status like 'finalizado' ")
    List<Carro> searchByDate(
            @Param("data_retirada") LocalDate data_retirada,
            @Param("data_devolucao") LocalDate data_devolucao);
}