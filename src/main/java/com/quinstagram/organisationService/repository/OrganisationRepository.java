package com.quinstagram.organisationService.repository;

import com.quinstagram.organisationService.entity.Organisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends CrudRepository<Organisation,Long> {
}
