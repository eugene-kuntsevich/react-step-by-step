package com.app.service.api;

import java.util.List;

import com.app.model.Master;

public interface MasterService
{
	Master findMasterById(Long id);

	List<Master> findFreeMasters();

	List<Master> findAllMasters();

	Long addMaster(Master master);

	void updateMaster(Master master);

	void deleteMasterById(Long masterId);
}
