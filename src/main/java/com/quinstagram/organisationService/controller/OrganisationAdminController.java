package com.quinstagram.organisationService.controller;

import com.quinstagram.organisationService.dto.OrganisationAdminDto;
import com.quinstagram.organisationService.entity.Organisation;
import com.quinstagram.organisationService.entity.OrganisationAdmin;
import com.quinstagram.organisationService.service.OrganisationAdminService;
import com.quinstagram.organisationService.service.OrganisationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/organisationAdmin")
public class OrganisationAdminController {

    @Autowired
    OrganisationAdminService organisationAdminService;

    @Autowired
    OrganisationService organisationService;

    @RequestMapping(value = "/add",method = {RequestMethod.POST,RequestMethod.PUT})
    public void addOrganisation(@RequestBody OrganisationAdminDto organisationAdminDto){
        OrganisationAdmin organisationAdmin=new OrganisationAdmin();
        BeanUtils.copyProperties(organisationAdminDto,organisationAdmin);
        organisationAdminService.save(organisationAdmin);
    }

    @GetMapping(value = "find/{id}")
    public Iterable<OrganisationAdminDto> findByUserId(@PathVariable("id") String userId){
        Iterable<OrganisationAdmin> admins=organisationAdminService.findByUserId(userId);
        Iterable<OrganisationAdminDto> organisationAdminDtos=new ArrayList<>();
        for (OrganisationAdmin organisationAdmin:admins){
            Organisation organisation=organisationService.findById(organisationAdmin.getOrganisationId());
            OrganisationAdminDto organisationAdminDto=new OrganisationAdminDto();
            organisationAdminDto.setOrganisationName(organisation.getName());
            BeanUtils.copyProperties(organisationAdmin,organisationAdminDto);
            ((ArrayList<OrganisationAdminDto>) organisationAdminDtos).add(organisationAdminDto);
            }
            return organisationAdminDtos;
        }
}
