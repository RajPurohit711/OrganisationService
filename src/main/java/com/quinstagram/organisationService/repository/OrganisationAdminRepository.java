package com.quinstagram.organisationService.repository;

import com.quinstagram.organisationService.entity.OrganisationAdmin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationAdminRepository extends CrudRepository<OrganisationAdmin,Long> {

    Iterable<OrganisationAdmin> findByUserId(String userId);

}
