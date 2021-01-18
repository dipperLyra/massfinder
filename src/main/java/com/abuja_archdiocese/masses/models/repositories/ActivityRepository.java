package com.abuja_archdiocese.masses.models.repositories;

import com.abuja_archdiocese.masses.models.entities.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
