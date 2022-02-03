package com.quinstagram.organisationService.service.Impl;

import com.quinstagram.organisationService.entity.Organisation;
import com.quinstagram.organisationService.repository.OrganisationRepository;
import com.quinstagram.organisationService.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    @Autowired
    OrganisationRepository organisationRepository;

    @Override
    public Organisation save(Organisation organisation){

        return organisationRepository.save(organisation);
    }

    @Override
    public Organisation findById(Long id){
        return organisationRepository.findById(id).get();
    }
}
