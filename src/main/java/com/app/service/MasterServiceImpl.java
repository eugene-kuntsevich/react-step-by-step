package com.app.service;

import com.app.model.Master;
import com.app.service.api.MasterService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {

  public Master findMasterById(Long id) {
    return new Master();
  }

  public List<Master> findFreeMasters() {
    return new ArrayList<>();
  }

  public List<Master> findAllMasters() {
    return new ArrayList<>();
  }

  public Long addMaster(Master master) {
    return null;
  }

  @Override
  public void updateMaster(Master master) {

  }

  @Override
  public void deleteMasterById(Long masterId) {

  }
}
