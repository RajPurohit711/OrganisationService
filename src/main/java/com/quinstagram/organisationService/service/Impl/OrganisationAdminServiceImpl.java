package com.quinstagram.organisationService.service.Impl;

import com.quinstagram.organisationService.entity.OrganisationAdmin;
import com.quinstagram.organisationService.repository.OrganisationAdminRepository;
import com.quinstagram.organisationService.service.OrganisationAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganisationAdminServiceImpl implements OrganisationAdminService {

    @Autowired
    OrganisationAdminRepository organisationAdminRepository;

    @Override
    public void save(OrganisationAdmin organisationAdmin){

      organisationAdminRepository.save(organisationAdmin);
    }

    @Override
    public Iterable<OrganisationAdmin> findByUserId(String userId){
        return organisationAdminRepository.findByUserId(userId);
    }
}
