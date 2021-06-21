package com.app.service;

import com.app.model.Master;
import com.app.service.api.MasterService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {

  public void addMaster(Master master) {
  }

  public Master findMasterById(Long id) {
    return new Master();
  }

  public void deleteMaster(Master master) {
  }

  @Override
  public void deleteMasterById(Long masterId) {

  }

  public List<Master> findAllMasters() {
    return new ArrayList<>();
  }

  public List<Master> findFreeMasters() {
    return new ArrayList<>();
  }
}
