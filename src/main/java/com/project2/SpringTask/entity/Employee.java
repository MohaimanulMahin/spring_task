package com.project2.SpringTask.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//@JsonIgnoreProperties(value = {"designationId","empId"})
@Table(name = "employees")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @JsonIgnore
  private long empId;
  @JsonProperty("FIRST NAME")
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String address;

  @Transient
//  @JsonIgnore
  private long designationId;
  @ManyToOne(
          cascade = CascadeType.ALL
  )
  @JoinColumn(name = "designation_desg_id",referencedColumnName = "desgId")
  private Designation designation;

  public void addDesignation(Designation designation){
    this.designation=designation;
  }
}
