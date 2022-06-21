package com.project2.SpringTask.service;

import com.project2.SpringTask.dto.DesignationDto;
import com.project2.SpringTask.entity.Designation;

import com.project2.SpringTask.repository.DesignationReposetory;
import org.springframework.beans.factory.annotation.Autowired;

public interface DesignationService {

  public Designation getDesignationById(Long id);

  Designation saveDesignation(DesignationDto designationDto);
}
