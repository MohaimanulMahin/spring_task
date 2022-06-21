package com.project2.SpringTask.controller;

import com.project2.SpringTask.dto.DesignationDto;
import com.project2.SpringTask.entity.Designation;
import com.project2.SpringTask.service.DesignationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;


@RestController
@RequiredArgsConstructor
@Slf4j
public class DesignationController {
  private final DesignationService designationService;

  private final MessageSource messageSource;

  @PostMapping("/designation-create")
  public ResponseEntity<?> addEmployee(@RequestBody DesignationDto designationDto){
    try{
      Designation designation= designationService.saveDesignation(designationDto);

      return  ResponseEntity.ok().body(List.of("msg:Designation is created",designation));
    }catch (Exception e){
      log.error("Error message: {}",String.valueOf(e));
      return  ResponseEntity.badRequest().body(List.of("Something went Wrong.Error: ",e));
    }
  }

@GetMapping(path = "/hello-world/internationl")
  public  String helloWorldInternationl(@RequestHeader(name="Accept-language",required = false) Locale locale){
    return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
}
}
