package com.project2.SpringTask.modelView;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModelView {
  private String firstName;

  private String lastName;
  private String email;
  private String phone;
  private String address;
  private String designationName;

  @Override
  public String toString() {
    return "EmployeeModelView{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", designationName='" + designationName + '\'' +
            '}';
  }
}
