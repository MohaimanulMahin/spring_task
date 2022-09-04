package com.project2.SpringTask.repository;

import com.project2.SpringTask.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@Repository
@RepositoryRestResource
public interface DesignationReposetory extends MyBaseRepository<Designation, Long>  {

}
