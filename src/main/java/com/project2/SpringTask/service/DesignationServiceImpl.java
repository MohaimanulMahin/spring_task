package com.project2.SpringTask.service;

import com.project2.SpringTask.dto.DesignationDto;
import com.project2.SpringTask.entity.Designation;
import com.project2.SpringTask.repository.DesignationReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignationServiceImpl implements DesignationService{

  private final DesignationReposetory designationReposetory;

  public DesignationServiceImpl(DesignationReposetory designationReposetory) {
    this.designationReposetory = designationReposetory;
  }

  @Override
  public Designation getDesignationById(Long id) {
    return designationReposetory.findById(id).get();
  }

  @Override
  public Designation saveDesignation(DesignationDto designationDto) {
    Designation designation=new Designation();
    designation.setDesignationName(designationDto.getDesignationName());
    return designationReposetory.save(designation);
  }
}
