package com.quinstagram.organisationService.controller;

import com.quinstagram.organisationService.dto.OrganisationDto;
import com.quinstagram.organisationService.entity.Organisation;
import com.quinstagram.organisationService.entity.OrganisationAdmin;
import com.quinstagram.organisationService.service.OrganisationAdminService;
import com.quinstagram.organisationService.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/organisation")
public class OrganisationController {

    @Autowired
    OrganisationService organisationService;

    @Autowired
    OrganisationAdminService organisationAdminService;

    @RequestMapping(value = "/add",method = {RequestMethod.POST,RequestMethod.PUT})
    public void addOrganisation(@RequestBody OrganisationDto organisationDto){
        Organisation organisation=new Organisation();
        organisation.setName(organisationDto.getName());
        Organisation organisation1=organisationService.save(organisation);
        OrganisationAdmin organisationAdmin=new OrganisationAdmin();
        organisationAdmin.setOrganisationId(organisation1.getId());
        organisationAdmin.setOwner(true);
        organisationAdmin.setUserId(organisationDto.getUserId());
        organisationAdminService.save(organisationAdmin);

        }
}
