package com.example.gticslab5_20210751.Repository;

import com.example.gticslab5_20210751.DTO.TicektPorSitioDTO;
import com.example.gticslab5_20210751.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {


    @Query(nativeQuery = true, value = "select COUNT(t.TicketID) as cantidad, s.SiteName as site from ticket t \n" +
            "inner join site s on s.SiteID = t.SiteID\n" +
            "group by s.SiteName")
    List<TicektPorSitioDTO> listarTicketsPorSitio();



}
