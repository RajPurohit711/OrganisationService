package com.quinstagram.organisationService.service;

import com.quinstagram.organisationService.entity.Organisation;

public interface OrganisationService {
    Organisation save(Organisation organisation);
    Organisation findById(Long id);


}
