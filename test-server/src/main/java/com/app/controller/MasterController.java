package com.app.controller;

import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import com.app.model.Master;
import com.app.service.api.MasterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/master")
public class MasterController {

  private MasterService masterService;

  @GetMapping("/find-by-id/{id}")
  public Master findMasterById(@PathVariable Long id) throws ObjectNotExistException {
    return masterService.findMasterById(id);
  }

  @GetMapping("/find-free-masters")
  public List<Master> findAllFreeMasters() {
    return masterService.findFreeMasters();
  }

  @GetMapping("/find-all")
  public List<Master> findAllMasters() {
    return masterService.findAllMasters();
  }

  @PostMapping("/add")
  public Long addMaster(@RequestBody Master master) {
    return masterService.addMaster(master);
  }

  @PutMapping("/update")
  public void updateMaster(@RequestBody Master master)
      throws ObjectNotExistException, NullableObjectIdentityException {
    masterService.updateMaster(master);
  }

  @DeleteMapping("/delete-by-id/{id}")
  public void deleteMasterById(@PathVariable Long id) throws NullableObjectIdentityException {
    masterService.deleteMasterById(id);
  }

  @Autowired
  public void setMasterService(MasterService masterService) {
    this.masterService = masterService;
  }
}
