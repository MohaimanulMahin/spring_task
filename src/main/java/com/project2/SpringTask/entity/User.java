package com.project2.SpringTask.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;


@ApiModel(description = "all Details about user")
@Entity
public class User {
  @Id
  private Integer id;
@Size(min=2,message = "Name should have least 2 characters")
@ApiModelProperty(notes = "Name should have at least 2 characters")
  private String name;
@Past
@ApiModelProperty(notes = "Birth date should be in the past")
  private Date birthDate;

}
