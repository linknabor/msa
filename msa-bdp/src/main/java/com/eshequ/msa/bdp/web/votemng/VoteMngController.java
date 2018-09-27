package com.eshequ.msa.bdp.web.votemng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.bdp.service.projectstatusmng.ProjectStatusMngService;
import com.eshequ.msa.common.BaseResult;

@RestController
@RequestMapping("/voteMng")
public class VoteMngController {
	@Autowired
    private ProjectStatusMngService projectStatusMngService;
	@RequestMapping(value="/getAllRegion",method=RequestMethod.GET)
	public BaseResult<?> getAllRegion(){
		
		return projectStatusMngService.getAllRegion();
	}

}
