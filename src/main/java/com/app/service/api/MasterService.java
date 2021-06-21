package com.app.service.api;

import java.util.List;

import com.app.model.Master;

public interface MasterService
{
	void addMaster(Master master);

	Master findMasterById(Long id);

	void deleteMaster(Master master);

	void deleteMasterById(Long masterId);

	List<Master> findAllMasters();

    List<Master> findFreeMasters();
}
