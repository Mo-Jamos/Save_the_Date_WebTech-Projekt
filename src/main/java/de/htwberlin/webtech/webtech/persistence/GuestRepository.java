package de.htwberlin.webtech.webtech.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {

    List<GuestRepository> findAllByFirstName(String firstName);

}

