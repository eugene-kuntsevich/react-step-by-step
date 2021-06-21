package com.app.service.api;

import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import java.util.List;

import com.app.model.Master;

public interface MasterService
{
	Master findMasterById(Long id) throws ObjectNotExistException;

	List<Master> findFreeMasters();

	List<Master> findAllMasters();

	Long addMaster(Master master);

	void updateMaster(Master master) throws ObjectNotExistException, NullableObjectIdentityException;

	void deleteMasterById(Long masterId) throws NullableObjectIdentityException;
}
