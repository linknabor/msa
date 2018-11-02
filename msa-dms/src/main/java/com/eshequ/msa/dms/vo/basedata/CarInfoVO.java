package com.eshequ.msa.dms.vo.basedata;

import java.io.Serializable;

import com.eshequ.msa.dms.model.servplat.SpBaseCustCar;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCarFeeStartDate;

public class CarInfoVO implements Serializable{

	private static final long serialVersionUID = 1956397627147183609L;
	private SpBaseCustCar spBaseCustCar;
	private SpBaseCustCarFeeStartDate spBaseCustCarFeeStartDate;
	public SpBaseCustCar getSpBaseCustCar() {
		return spBaseCustCar;
	}
	public void setSpBaseCustCar(SpBaseCustCar spBaseCustCar) {
		this.spBaseCustCar = spBaseCustCar;
	}
	public SpBaseCustCarFeeStartDate getSpBaseCustCarFeeStartDate() {
		return spBaseCustCarFeeStartDate;
	}
	public void setSpBaseCustCarFeeStartDate(SpBaseCustCarFeeStartDate spBaseCustCarFeeStartDate) {
		this.spBaseCustCarFeeStartDate = spBaseCustCarFeeStartDate;
	}
	
}
