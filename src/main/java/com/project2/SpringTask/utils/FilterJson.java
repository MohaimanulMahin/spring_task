package com.project2.SpringTask.utils;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FilterJson {
  public   <T extends List,L> MappingJacksonValue getMappingJacksonValue(T dataDto, L hash_Set) {
    SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept((Set<String>) hash_Set);
    FilterProvider filters=new SimpleFilterProvider().addFilter("EmployeeFilter", filter);
    MappingJacksonValue mapping = new MappingJacksonValue(dataDto);
    mapping.setFilters(filters);
    return mapping;
  }
}
