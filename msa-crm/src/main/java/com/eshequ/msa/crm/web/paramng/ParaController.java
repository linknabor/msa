package com.eshequ.msa.crm.web.paramng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.crm.model.sysmodel.MsaCfgSysPara;
import com.eshequ.msa.crm.service.ParaService;
import com.eshequ.msa.crm.vo.para.ParaVo;
import com.eshequ.msa.crm.web.BaseController;
@RestController
public class ParaController extends BaseController{

	@Autowired
	private ParaService paraService;
	
	@RequestMapping(value = "/paraQueryAll", method = RequestMethod.POST)
	public List<MsaCfgSysPara> paraQueryAll(){
		List<MsaCfgSysPara> list = paraService.paraQueryAll();
		return list;
	}
	
	@RequestMapping(value = "/paraEdit", method = RequestMethod.POST)
	public void paraEdit(@RequestBody ParaVo vo){
		paraService.paraEdit(vo);
	}
}
