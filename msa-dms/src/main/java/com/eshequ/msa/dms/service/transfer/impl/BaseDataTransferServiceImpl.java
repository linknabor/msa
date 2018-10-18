package com.eshequ.msa.dms.service.transfer.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.dms.mapper.msa.MsaBaseAdLocateMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCarportMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCellMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCityMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCustCarFeeStartDateMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCustCarMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseCustMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseEnterpriseMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseHouseMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseProvinceMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseRegionMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseSectMapper;
import com.eshequ.msa.dms.mapper.msa.MsaBaseShopsMapper;
import com.eshequ.msa.dms.mapper.msa.MsaCellCustMapper;
import com.eshequ.msa.dms.mapper.msa.MsaCustCarMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseAdLocateMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseCatportMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseCityMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseCspMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseCustCarFeeStartDateMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseCustCarMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseCustMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseHouseMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseMngCellMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseProvinceMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseRegionMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseSectMapper;
import com.eshequ.msa.dms.mapper.servplat.SpBaseShopsMapper;
import com.eshequ.msa.dms.mapper.servplat.SpRelateCustMapper;
import com.eshequ.msa.dms.mapper.servplat.SpRelateParkCarMapper;
import com.eshequ.msa.dms.model.msa.MsaBaseAdLocate;
import com.eshequ.msa.dms.model.msa.MsaBaseCarport;
import com.eshequ.msa.dms.model.msa.MsaBaseCell;
import com.eshequ.msa.dms.model.msa.MsaBaseCity;
import com.eshequ.msa.dms.model.msa.MsaBaseCust;
import com.eshequ.msa.dms.model.msa.MsaBaseCustCar;
import com.eshequ.msa.dms.model.msa.MsaBaseCustCarFeeStartDate;
import com.eshequ.msa.dms.model.msa.MsaBaseEnterprise;
import com.eshequ.msa.dms.model.msa.MsaBaseHouse;
import com.eshequ.msa.dms.model.msa.MsaBaseProvince;
import com.eshequ.msa.dms.model.msa.MsaBaseRegion;
import com.eshequ.msa.dms.model.msa.MsaBaseSect;
import com.eshequ.msa.dms.model.msa.MsaBaseShops;
import com.eshequ.msa.dms.model.msa.MsaCellCust;
import com.eshequ.msa.dms.model.msa.MsaCustCar;
import com.eshequ.msa.dms.model.servplat.SpBaseAdLocate;
import com.eshequ.msa.dms.model.servplat.SpBaseCarport;
import com.eshequ.msa.dms.model.servplat.SpBaseCity;
import com.eshequ.msa.dms.model.servplat.SpBaseCsp;
import com.eshequ.msa.dms.model.servplat.SpBaseCust;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCar;
import com.eshequ.msa.dms.model.servplat.SpBaseCustCarFeeStartDate;
import com.eshequ.msa.dms.model.servplat.SpBaseHouse;
import com.eshequ.msa.dms.model.servplat.SpBaseMngCell;
import com.eshequ.msa.dms.model.servplat.SpBaseProvince;
import com.eshequ.msa.dms.model.servplat.SpBaseRegion;
import com.eshequ.msa.dms.model.servplat.SpBaseSect;
import com.eshequ.msa.dms.model.servplat.SpBaseShops;
import com.eshequ.msa.dms.model.servplat.SpRelateCust;
import com.eshequ.msa.dms.model.servplat.SpRelateParkCar;
import com.eshequ.msa.dms.service.transfer.BaseDataBatchTransferService;
import com.eshequ.msa.exception.BusinessException;
import com.eshequ.msa.util.SnowFlake;
import com.github.pagehelper.PageHelper;

@Service
public class BaseDataTransferServiceImpl implements BaseDataBatchTransferService {

	@Autowired
	private SnowFlake snowFlake;
	
	@Autowired
	private SpBaseProvinceMapper spBaseProvinceMapper;
	
	@Autowired
	private MsaBaseProvinceMapper msaBaseProvinceMapper;
	
	@Autowired
	private SpBaseCityMapper spBaseCityMapper;
	
	@Autowired
	private MsaBaseCityMapper msaBaseCityMapper;
	
	@Autowired
	private SpBaseRegionMapper spBaseRegionMapper;
	
	@Autowired
	private MsaBaseRegionMapper msaBaseRegionMapper;
	
	@Autowired
	private SpBaseCspMapper spBaseCspMapper;
	
	@Autowired
	private MsaBaseEnterpriseMapper msaBaseEnterpriseMapper;
	
	@Autowired
	private MsaBaseSectMapper msaBaseSectMapper;
	
	@Autowired
	private SpBaseSectMapper spBaseSectMapper;
	
	@Autowired
	private MsaBaseCellMapper msaBaseCellMapper;
	
	@Autowired
	private SpBaseMngCellMapper spBaseMngCellMapper;
	
	@Autowired
	private MsaBaseHouseMapper msaBaseHouseMapper;
	
	@Autowired
	private SpBaseHouseMapper spBaseHouseMapper;
	
	@Autowired
	private MsaBaseShopsMapper msaBaseShopsMapper;
	
	@Autowired
	private SpBaseShopsMapper spBaseShopsMapper;
	
	@Autowired
	private MsaBaseCarportMapper msaBaseCarportMapper;
	
	@Autowired
	private SpBaseCatportMapper spBaseCatportMapper;
	
	@Autowired
	private MsaBaseAdLocateMapper msaBaseAdLocateMapper;
	
	@Autowired
	private SpBaseAdLocateMapper spBaseAdLocateMapper;
	
	@Autowired
	private MsaBaseCustCarMapper msaBaseCustCarMapper;
	
	@Autowired
	private SpBaseCustCarMapper spBaseCustCarMapper;
	
	@Autowired
	private MsaBaseCustMapper msaBaseCustMapper;
	
	@Autowired
	private SpBaseCustMapper spBaseCustMapper;
	
	@Autowired
	private MsaCustCarMapper msaCustCarMapper;
	
	@Autowired
	private SpRelateParkCarMapper spRelateParkCarMapper;
	
	@Autowired
	private MsaBaseCustCarFeeStartDateMapper msaBaseCustCarFeeStartDateMapper;
	
	@Autowired
	private SpBaseCustCarFeeStartDateMapper spBaseCustCarFeeStartDateMapper;
	
	@Autowired
	private MsaCellCustMapper msaCellCustMapper;
	
	@Autowired
	private SpRelateCustMapper spRelateCustMapper;
	
	/**
	 * 基础数据迁移
	 */
	@Override
	public BaseResult<String> migrateBaseData() {

		migrateProvince();
		migrateCity();
		migrateRegion();
		migrateEnterprise();
		migrateSect();
		migrateParkRelate();
		
		
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	
	}
	
	public BaseResult<String> migrateCellData(){
		List<MsaBaseSect> sectList = msaBaseSectMapper.selectAll();
		Map<String,Long>sectMap = new HashMap<String, Long>();
		for (MsaBaseSect msaBaseSect :sectList) {
			sectMap.put(msaBaseSect.getRelatedSectNo(), msaBaseSect.getSectId());
		}
		for(int i = 0; i <= 270; i++) {
//			if(i == 3) throw new BusinessException("roll back");
//			migrateCell(i +1, sectMap);
//			migrateHouse(i + 1);
//			migrateShops(i + 1);
//			migrateCarport(i + 1);
//			migrateAdLocate(i + 1);
//			migrateCust(i + 1);
			migrateCellCust(i + 1);
		}
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}
	
	@Override
	public BaseResult<String> migrateCarData() {
//		migrateCar();
		migrateFeeStartDate();
		BaseResult<String> baseResult = new BaseResult<String>();
		baseResult.setResult("0");
		return baseResult;
	}

	@Transactional
	public void migrateProvince() {
		
		
		List<SpBaseProvince> list = spBaseProvinceMapper.selectAll();
		
		for (SpBaseProvince spBaseProvince : list) {
			
			MsaBaseProvince province = new MsaBaseProvince();
			BeanUtils.copyProperties(spBaseProvince, province);
			province.setRemark(spBaseProvince.getProvinceId().toString());
			province.setProvinceId(snowFlake.nextId());
			msaBaseProvinceMapper.insertSelective(province);
		}
		
		
	}
	
	/**
	 * must have data in msa_base_province
	 */
	@Transactional
	public void migrateCity() {
		
		List<MsaBaseProvince> proList = msaBaseProvinceMapper.selectAll();
		Map<String, Long> proMap = new HashMap<String, Long>();
		
		for (MsaBaseProvince msaBaseProvince : proList) {
			proMap.put(msaBaseProvince.getRemark(), msaBaseProvince.getProvinceId());
		}
		
		List<SpBaseCity> cityList = spBaseCityMapper.selectAll();
		for (SpBaseCity spBaseCity : cityList) {
			MsaBaseCity msaBaseCity = new MsaBaseCity();
			BeanUtils.copyProperties(spBaseCity, msaBaseCity);
			msaBaseCity.setRemark(spBaseCity.getCityId().toString());
			msaBaseCity.setProvinceId(proMap.get(spBaseCity.getProvinceId().toString()));
			msaBaseCity.setCityId(snowFlake.nextId());
			msaBaseCityMapper.insertSelective(msaBaseCity);
		}
		
	}

	/**
	 * must have data in msa_base_city
	 * @return
	 */
	@Transactional(rollbackFor={BusinessException.class})
	public void migrateRegion() {

		List<MsaBaseCity> cityList = msaBaseCityMapper.selectAll();
		Map<String, Long> cityMap = new HashMap<String, Long>();
		for (MsaBaseCity msaBaseCity : cityList) {
			cityMap.put(msaBaseCity.getRemark(), msaBaseCity.getCityId());
		}
		
		List<SpBaseRegion> regionList = spBaseRegionMapper.selectAll();
		for (SpBaseRegion spBaseRegion : regionList) {
			MsaBaseRegion msaBaseRegion = new MsaBaseRegion();
			BeanUtils.copyProperties(spBaseRegion, msaBaseRegion);
			msaBaseRegion.setRemark(spBaseRegion.getRegionId().toString());
			msaBaseRegion.setCityId(cityMap.get(spBaseRegion.getCityId().toString()));
			msaBaseRegion.setRegionId(snowFlake.nextId());
			msaBaseRegionMapper.insertSelective(msaBaseRegion);
		}
//		
//		if(true) {
//			throw new BusinessException("test transaction rollback !");
//		}
		
	}
	
	@Transactional(rollbackFor={BusinessException.class})
	//迁移公司客户
	public void migrateEnterprise() {
		
		List<MsaBaseEnterprise> enterpriseList = msaBaseEnterpriseMapper.selectAll();
		Map<String,String> enterpriseMap = new HashMap<String, String>();
		for (MsaBaseEnterprise msaBaseEnterprise : enterpriseList) {
			enterpriseMap.put(msaBaseEnterprise.getRemark(), msaBaseEnterprise.getOriginId());
		}
		
		List<SpBaseCsp> cspList = spBaseCspMapper.selectAll();
		for (SpBaseCsp spBaseCsp : cspList) {
			MsaBaseEnterprise msaBaseEnterprise = new MsaBaseEnterprise();
			BeanUtils.copyProperties(spBaseCsp, msaBaseEnterprise);
			msaBaseEnterprise.setRemark(spBaseCsp.getCspId().toString());
			msaBaseEnterprise.setEnterpriseId(snowFlake.nextId()+"");
			msaBaseEnterprise.setEnterpriseName(spBaseCsp.getCspName());
			msaBaseEnterprise.setEnterpriseAddr(spBaseCsp.getOrgAddr());
			msaBaseEnterprise.setEnterpriseState(spBaseCsp.getCspStatus());
			msaBaseEnterprise.setEnterpriseTel(spBaseCsp.getOrgTel());
			msaBaseEnterpriseMapper.insertSelective(msaBaseEnterprise);
		}
	}

	@Transactional(rollbackFor={BusinessException.class})
	//迁移小区
	public void migrateSect() {
		List<MsaBaseSect> sectList = msaBaseSectMapper.selectAll();
		Map<String,String> sectMap = new HashMap<String, String>();
		for (MsaBaseSect msaBaseSect :sectList) {
			sectMap.put(msaBaseSect.getRemark(), msaBaseSect.getRelatedSectNo());
		}
		
		List<SpBaseSect>spsectList = spBaseSectMapper.selectAll();
		for (SpBaseSect spBaseSect : spsectList) {
			MsaBaseSect msaBaseSect = new MsaBaseSect();
			BeanUtils.copyProperties(spBaseSect, msaBaseSect);
			msaBaseSect.setRemark(spBaseSect.getSectId().toString());
			msaBaseSect.setStatus(spBaseSect.getSectStatus());
			msaBaseSect.setSectName(spBaseSect.getSectNameFrst());
			msaBaseSect.setSectAddr(spBaseSect.getSectAddrFrst());
			msaBaseSect.setOriginalId(spBaseSect.getSectId()+"");
			msaBaseSect.setSectId(snowFlake.nextId());
			msaBaseSectMapper.insertSelective(msaBaseSect);
		}
	}
	
	@Transactional(rollbackFor={BusinessException.class})
	//迁移车辆
	public void migrateCustCar() {
		List<SpBaseCustCar> spbasecustcarList = spBaseCustCarMapper.selectAll();
		for(SpBaseCustCar spBaseCustCar : spbasecustcarList) {
			MsaBaseCustCar msaBaseCustCar = new MsaBaseCustCar();
			BeanUtils.copyProperties(spBaseCustCar, msaBaseCustCar);
			msaBaseCustCar.setOriginalId(spBaseCustCar.getCarId()+"");
			msaBaseCustCar.setCarId(snowFlake.nextId());
			msaBaseCustCarMapper.insertSelective(msaBaseCustCar);
		}
	}
	
	@Transactional(rollbackFor={BusinessException.class})
	//迁移业主
	public void migrateCust(int page) {
		PageHelper.startPage(page, 1000, false);
		List<SpBaseCust> spcustList = spBaseCustMapper.selectAll();
		for (SpBaseCust spBaseCust : spcustList) {
			MsaBaseCust msaBaseCust = new MsaBaseCust();
			BeanUtils.copyProperties(spBaseCust, msaBaseCust);
			msaBaseCust.setOriginalId(spBaseCust.getCustId()+"");
			msaBaseCust.setCustId(snowFlake.nextId());
			msaBaseCustMapper.insertSelective(msaBaseCust);
		}
	}
	
	
	@Transactional(rollbackFor={BusinessException.class})
	//迁移室
	public void migrateCell(int page, Map<String, Long> sectMap) {

			PageHelper.startPage(page, 1000, false);
			List<SpBaseMngCell>spcellList = spBaseMngCellMapper.selectAll();
			for (SpBaseMngCell spBaseCell : spcellList) {
				MsaBaseCell msaBaseCell = new MsaBaseCell();
				BeanUtils.copyProperties(spBaseCell, msaBaseCell);
				msaBaseCell.setRemark(spBaseCell.getSectId().toString());
				msaBaseCell.setStatus(spBaseCell.getCellStatus());
				msaBaseCell.setSectId(sectMap.get(spBaseCell.getSectId()+""));
				msaBaseCell.setOriginalId(spBaseCell.getMngCellId()+"");
				msaBaseCell.setMngCellId(snowFlake.nextId());
				msaBaseCellMapper.insertSelective(msaBaseCell);
			}
	}

	@Transactional(rollbackFor={BusinessException.class})
	//迁移住宅
	public void migrateHouse(int page) {

			PageHelper.startPage(page, 1000, false);
			List<SpBaseHouse> sphouseList = spBaseHouseMapper.selectAll();
			for (SpBaseHouse spBaseHouse : sphouseList) {
				MsaBaseHouse msaBaseHouse = new MsaBaseHouse();
				BeanUtils.copyProperties(spBaseHouse, msaBaseHouse);
				msaBaseHouseMapper.insertSelective(msaBaseHouse);
			}
	}		

	@Transactional(rollbackFor={BusinessException.class})
	//迁移商铺
	public void migrateShops(int page) {
		PageHelper.startPage(page, 1000, false);
		List<SpBaseShops> spshopsList = spBaseShopsMapper.selectAll();
		for(SpBaseShops spBaseShops : spshopsList) {
			MsaBaseShops msaBaseShops = new MsaBaseShops();
			BeanUtils.copyProperties(spBaseShops, msaBaseShops);
			msaBaseShopsMapper.insertSelective(msaBaseShops);
		}
	}

	@Transactional(rollbackFor={BusinessException.class})
	//迁移车位
	public void migrateCarport(int page) {
		PageHelper.startPage(page, 1000, false);
		List<SpBaseCarport> spcarportList = spBaseCatportMapper.selectAll();
		for(SpBaseCarport spBaseCarport : spcarportList) {
			MsaBaseCarport msaBaseCarport = new MsaBaseCarport();
			BeanUtils.copyProperties(spBaseCarport, msaBaseCarport);
			msaBaseCarportMapper.insertSelective(msaBaseCarport);
		}
	}
	
	@Transactional(rollbackFor={BusinessException.class})
	//迁移广告位
	public void migrateAdLocate(int page) {
		PageHelper.startPage(page, 1000, false);
		List<SpBaseAdLocate> spadlocateList = spBaseAdLocateMapper.selectAll();
		for(SpBaseAdLocate spBaseAdLocate : spadlocateList) {
			MsaBaseAdLocate msaBaseAdLocate = new MsaBaseAdLocate();
			BeanUtils.copyProperties(spBaseAdLocate, msaBaseAdLocate);
			msaBaseAdLocateMapper.insertSelective(msaBaseAdLocate);
		}
	}
	
	@Transactional(rollbackFor={BusinessException.class})
	//迁移车辆
		public void migrateCar() {
			
			List<SpBaseCustCar> spcarList = spBaseCustCarMapper.selectAll();
			for (SpBaseCustCar spBaseCustCar : spcarList) {
				MsaBaseCustCar msaBaseCustCar = new MsaBaseCustCar();
				BeanUtils.copyProperties(spBaseCustCar, msaBaseCustCar);
				msaBaseCustCar.setOriginalId(spBaseCustCar.getCarId()+"");
				msaBaseCustCar.setCarId(snowFlake.nextId());
				msaBaseCustCarMapper.insertSelective(msaBaseCustCar);
			}
		}
	
	@Transactional(rollbackFor={BusinessException.class})
	//迁移车辆关系
	public void migrateParkRelate() {
		List<SpRelateParkCar> sprelateparkList = spRelateParkCarMapper.selectAll();
		for(SpRelateParkCar spRelateParkCarKey : sprelateparkList) {
			MsaCustCar msaCustCarKey = new MsaCustCar();
			BeanUtils.copyProperties(spRelateParkCarKey, msaCustCarKey);
			msaCustCarMapper.insertSelective(msaCustCarKey);
		}
	}
	
	@Transactional(rollbackFor={BusinessException.class})
	//迁移客户车辆初始缴费日期表
	public void migrateFeeStartDate() {
		List<SpBaseCustCarFeeStartDate> spbasecustcarfeestartdateList = spBaseCustCarFeeStartDateMapper.selectAll();
		for(SpBaseCustCarFeeStartDate spBaseCustCarFeeStartDate : spbasecustcarfeestartdateList) {
			MsaBaseCustCarFeeStartDate msaBaseCustCarFeeStartDate = new MsaBaseCustCarFeeStartDate();
			BeanUtils.copyProperties(spBaseCustCarFeeStartDate, msaBaseCustCarFeeStartDate);
			msaBaseCustCarFeeStartDateMapper.insertSelective(msaBaseCustCarFeeStartDate);
		}
	}
	
	@Transactional(rollbackFor={BusinessException.class})
	//迁移客户关系表
	public void migrateCellCust(int page) {
		PageHelper.startPage(page, 1000, false);
		List<SpRelateCust> spRelateCustList = spRelateCustMapper.selectAll();
		for(SpRelateCust spRelateCust : spRelateCustList) {
			MsaCellCust msaCellCust = new MsaCellCust();
			BeanUtils.copyProperties(spRelateCust, msaCellCust);
			msaCellCustMapper.insertSelective(msaCellCust);
		}
	}

}
