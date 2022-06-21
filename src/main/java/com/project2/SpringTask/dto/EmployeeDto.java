package com.project2.SpringTask.dto;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.project2.SpringTask.entity.Designation;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Size;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter("EmployeeFilter")
public class EmployeeDto {
  private String firstName;

  private String lastName;
  private String email;
  @Size(max = 12,message = "Phone no should be 12digit")
  @ApiModelProperty(notes = "Phone NO must be 12 digits")
  private String phone;
  private String address;
  private Long designationId;

}
