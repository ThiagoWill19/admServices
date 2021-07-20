package com.thiagowill.admServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiagowill.admServices.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
