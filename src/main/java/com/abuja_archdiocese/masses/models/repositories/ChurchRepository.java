package com.abuja_archdiocese.masses.models.repositories;

import com.abuja_archdiocese.masses.models.entities.Church;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChurchRepository extends CrudRepository<Church, Long> {
}
