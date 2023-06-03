package com.USMBA.restau.Ticket.repositories;

import com.USMBA.restau.Ticket.entities.Ticket;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface TicektRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByUserName (String userName);
    List<Ticket> findByDateConsomation (Date date);
}
