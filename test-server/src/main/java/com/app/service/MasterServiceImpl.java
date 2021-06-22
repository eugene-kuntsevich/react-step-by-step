package com.app.service;

import static com.app.AppStorage.masterIdGenerator;
import static com.app.AppStorage.masters;
import static com.app.util.ValidatorUtil.checkNullableIdentity;
import static com.app.util.ValidatorUtil.checkNullableObject;

import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import com.app.model.Master;
import com.app.service.api.MasterService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {

  public Master findMasterById(Long id) throws ObjectNotExistException {
    Master master = masters.get(id);
    checkNullableObject(master);
    return master;
  }

  public List<Master> findFreeMasters() {
    return masters.values().stream().filter(master -> master.getOrder() == null)
        .collect(Collectors.toList());
  }

  public List<Master> findAllMasters() {
    return new ArrayList<>(masters.values());
  }

  public Long addMaster(Master master) {
    Long newId = ++masterIdGenerator;
    master.setId(newId);
    masters.put(newId, master);
    return newId;
  }

  @Override
  public void updateMaster(Master master)
      throws ObjectNotExistException, NullableObjectIdentityException {
    Long masterId = master.getId();
    checkNullableIdentity(masterId);
    Master masterFromStorage = masters.get(masterId);
    checkNullableObject(masterFromStorage);
    masters.put(masterId, master);
  }

  @Override
  public void deleteMasterById(Long masterId) throws NullableObjectIdentityException {
    checkNullableIdentity(masterId);
    masters.remove(masterId);
  }
}
