package com.quinstagram.organisationService.service;

import com.quinstagram.organisationService.entity.OrganisationAdmin;

public interface OrganisationAdminService {

    void save(OrganisationAdmin organisationAdmin);
    Iterable<OrganisationAdmin> findByUserId(String userId);
}
