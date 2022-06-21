package com.project2.SpringTask.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Designation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
private long desgId;
  @JsonProperty("Designation Name")
private String designationName;

}
