package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Master;
import com.app.service.api.MasterService;

@RestController
@RequestMapping("/master")
public class MasterController
{
	private MasterService masterService;

	@PostMapping("/save-master")
	public void addMaster(@RequestBody Master master)
	{
		masterService.addMaster(master);
	}

	@DeleteMapping("/delete-master")
	public void deleteMaster(@RequestBody Master master)
	{
		masterService.deleteMaster(master);
	}

	@GetMapping("/find-master-by-id/{id}")
	public Master findMasterById(@PathVariable Long id)
	{
		return masterService.findMasterById(id);
	}

	@GetMapping("/find-all-master")
	public List<Master> findAllMasters()
	{
		return masterService.findAllMasters();
	}

	 @DeleteMapping("/delete-master/{id}")
    public void deleteMaster(@PathVariable Long id) {
        masterService.deleteMasterById(id);
    }

	@GetMapping("/find-free-masters")
	public List<Master> findAllFreeMasters()
	{
		return masterService.findFreeMasters();
	}

	@Autowired
	public void setMasterService(MasterService masterService)
	{
		this.masterService = masterService;
	}
}
