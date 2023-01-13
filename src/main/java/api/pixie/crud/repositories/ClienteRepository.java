package api.pixie.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.pixie.crud.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
