package com.eshequ.msa.dms.model.servplat;

import com.eshequ.msa.common.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SpBaseSect extends BaseModel {
	@JsonProperty("sect_id")
    private Long sectId;

	@JsonProperty("sect_status")
    private String sectStatus;

	@JsonProperty("sect_type")
    private String sectType;

	@JsonProperty("pro_type")
    private String proType;

	@JsonProperty("sect_name_frst")
    private String sectNameFrst;

	@JsonProperty("sect_addr_frst")
    private String sectAddrFrst;

	@JsonProperty("sect_road_frst")
    private String sectRoadFrst;

	@JsonProperty("sect_street_frst")
    private String sectStreetFrst;

	@JsonProperty("sect_sub_street_frst")
    private String sectSubStreetFrst;

	@JsonProperty("sect_no_frst")
    private String sectNoFrst;

	@JsonProperty("remark")
    private String remark;

	@JsonProperty("province_id")
    private Long provinceId;

	@JsonProperty("city_id")
    private Long cityId;

	@JsonProperty("region_id")
    private Long regionId;

	@JsonProperty("loop_id")
    private Long loopId;

	@JsonProperty("block_id")
    private Long blockId;

	@JsonProperty("street_id")
    private Long streetId;

	@JsonProperty("commi_id")
    private Long commiId;

	@JsonProperty("zip_code")
    private String zipCode;

	@JsonProperty("sect_east")
    private String sectEast;

	@JsonProperty("sect_south")
    private String sectSouth;

	@JsonProperty("sect_west")
    private String sectWest;

	@JsonProperty("sect_north")
    private String sectNorth;

	@JsonProperty("cnst_area")
    private String cnstArea;

	@JsonProperty("land_area")
    private String landArea;

	@JsonProperty("shops_area")
    private String shopsArea;

	@JsonProperty("public_area")
    private String publicArea;

	@JsonProperty("waters_area")
    private String watersArea;

	@JsonProperty("green_area")
    private String greenArea;

	@JsonProperty("tot_builds")
    private String totBuilds;

	@JsonProperty("tot_units")
    private String totUnits;

	@JsonProperty("tot_hous")
    private String totHous;

	@JsonProperty("tot_shops")
    private String totShops;

	@JsonProperty("tot_lifts")
    private String totLifts;

	@JsonProperty("tot_ong_parks")
    private String totOngParks;

	@JsonProperty("tot_ung_parks")
    private String totUngParks;

	@JsonProperty("tot_tanks")
    private String totTanks;

	@JsonProperty("tot_reservoirs")
    private String totReservoirs;

	@JsonProperty("tot_pumps")
    private String totPumps;

	@JsonProperty("tot_electrooms")
    private String totElectrooms;

	@JsonProperty("sect_name_scnd")
    private String sectNameScnd;

	@JsonProperty("sect_addr_scnd")
    private String sectAddrScnd;

	@JsonProperty("sect_road_scnd")
    private String sectRoadScnd;

	@JsonProperty("sect_street_scnd")
    private String sectStreetScnd;

	@JsonProperty("sect_sub_street_scnd")
    private String sectSubStreetScnd;

	@JsonProperty("sect_no_scnd")
    private String sectNoScnd;

	@JsonProperty("office_addr")
    private String officeAddr;

	@JsonProperty("office_tel")
    private String officeTel;

	@JsonProperty("")
    private String relatedSectId;

	@JsonProperty("related_sect_no")
    private String relatedSectNo;

	@JsonProperty("house_manager")
    private String houseManager;

	@JsonProperty("house_manager_person")
    private String houseManagerPerson;

	private String sectTel;

    public Long getSectId() {
        return sectId;
    }

    public void setSectId(Long sectId) {
        this.sectId = sectId;
    }

    public String getSectStatus() {
        return sectStatus;
    }

    public void setSectStatus(String sectStatus) {
        this.sectStatus = sectStatus;
    }

    public String getSectType() {
        return sectType;
    }

    public void setSectType(String sectType) {
        this.sectType = sectType;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getSectNameFrst() {
        return sectNameFrst;
    }

    public void setSectNameFrst(String sectNameFrst) {
        this.sectNameFrst = sectNameFrst;
    }

    public String getSectAddrFrst() {
        return sectAddrFrst;
    }

    public void setSectAddrFrst(String sectAddrFrst) {
        this.sectAddrFrst = sectAddrFrst;
    }

    public String getSectRoadFrst() {
        return sectRoadFrst;
    }

    public void setSectRoadFrst(String sectRoadFrst) {
        this.sectRoadFrst = sectRoadFrst;
    }

    public String getSectStreetFrst() {
        return sectStreetFrst;
    }

    public void setSectStreetFrst(String sectStreetFrst) {
        this.sectStreetFrst = sectStreetFrst;
    }

    public String getSectSubStreetFrst() {
        return sectSubStreetFrst;
    }

    public void setSectSubStreetFrst(String sectSubStreetFrst) {
        this.sectSubStreetFrst = sectSubStreetFrst;
    }

    public String getSectNoFrst() {
        return sectNoFrst;
    }

    public void setSectNoFrst(String sectNoFrst) {
        this.sectNoFrst = sectNoFrst;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getLoopId() {
        return loopId;
    }

    public void setLoopId(Long loopId) {
        this.loopId = loopId;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public Long getCommiId() {
        return commiId;
    }

    public void setCommiId(Long commiId) {
        this.commiId = commiId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getSectEast() {
        return sectEast;
    }

    public void setSectEast(String sectEast) {
        this.sectEast = sectEast;
    }

    public String getSectSouth() {
        return sectSouth;
    }

    public void setSectSouth(String sectSouth) {
        this.sectSouth = sectSouth;
    }

    public String getSectWest() {
        return sectWest;
    }

    public void setSectWest(String sectWest) {
        this.sectWest = sectWest;
    }

    public String getSectNorth() {
        return sectNorth;
    }

    public void setSectNorth(String sectNorth) {
        this.sectNorth = sectNorth;
    }

    public String getCnstArea() {
        return cnstArea;
    }

    public void setCnstArea(String cnstArea) {
        this.cnstArea = cnstArea;
    }

    public String getLandArea() {
        return landArea;
    }

    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    public String getShopsArea() {
        return shopsArea;
    }

    public void setShopsArea(String shopsArea) {
        this.shopsArea = shopsArea;
    }

    public String getPublicArea() {
        return publicArea;
    }

    public void setPublicArea(String publicArea) {
        this.publicArea = publicArea;
    }

    public String getWatersArea() {
        return watersArea;
    }

    public void setWatersArea(String watersArea) {
        this.watersArea = watersArea;
    }

    public String getGreenArea() {
        return greenArea;
    }

    public void setGreenArea(String greenArea) {
        this.greenArea = greenArea;
    }

    public String getTotBuilds() {
        return totBuilds;
    }

    public void setTotBuilds(String totBuilds) {
        this.totBuilds = totBuilds;
    }

    public String getTotUnits() {
        return totUnits;
    }

    public void setTotUnits(String totUnits) {
        this.totUnits = totUnits;
    }

    public String getTotHous() {
        return totHous;
    }

    public void setTotHous(String totHous) {
        this.totHous = totHous;
    }

    public String getTotShops() {
        return totShops;
    }

    public void setTotShops(String totShops) {
        this.totShops = totShops;
    }

    public String getTotLifts() {
        return totLifts;
    }

    public void setTotLifts(String totLifts) {
        this.totLifts = totLifts;
    }

    public String getTotOngParks() {
        return totOngParks;
    }

    public void setTotOngParks(String totOngParks) {
        this.totOngParks = totOngParks;
    }

    public String getTotUngParks() {
        return totUngParks;
    }

    public void setTotUngParks(String totUngParks) {
        this.totUngParks = totUngParks;
    }

    public String getTotTanks() {
        return totTanks;
    }

    public void setTotTanks(String totTanks) {
        this.totTanks = totTanks;
    }

    public String getTotReservoirs() {
        return totReservoirs;
    }

    public void setTotReservoirs(String totReservoirs) {
        this.totReservoirs = totReservoirs;
    }

    public String getTotPumps() {
        return totPumps;
    }

    public void setTotPumps(String totPumps) {
        this.totPumps = totPumps;
    }

    public String getTotElectrooms() {
        return totElectrooms;
    }

    public void setTotElectrooms(String totElectrooms) {
        this.totElectrooms = totElectrooms;
    }

    public String getSectNameScnd() {
        return sectNameScnd;
    }

    public void setSectNameScnd(String sectNameScnd) {
        this.sectNameScnd = sectNameScnd;
    }

    public String getSectAddrScnd() {
        return sectAddrScnd;
    }

    public void setSectAddrScnd(String sectAddrScnd) {
        this.sectAddrScnd = sectAddrScnd;
    }

    public String getSectRoadScnd() {
        return sectRoadScnd;
    }

    public void setSectRoadScnd(String sectRoadScnd) {
        this.sectRoadScnd = sectRoadScnd;
    }

    public String getSectStreetScnd() {
        return sectStreetScnd;
    }

    public void setSectStreetScnd(String sectStreetScnd) {
        this.sectStreetScnd = sectStreetScnd;
    }

    public String getSectSubStreetScnd() {
        return sectSubStreetScnd;
    }

    public void setSectSubStreetScnd(String sectSubStreetScnd) {
        this.sectSubStreetScnd = sectSubStreetScnd;
    }

    public String getSectNoScnd() {
        return sectNoScnd;
    }

    public void setSectNoScnd(String sectNoScnd) {
        this.sectNoScnd = sectNoScnd;
    }

    public String getOfficeAddr() {
        return officeAddr;
    }

    public void setOfficeAddr(String officeAddr) {
        this.officeAddr = officeAddr;
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getRelatedSectId() {
        return relatedSectId;
    }

    public void setRelatedSectId(String relatedSectId) {
        this.relatedSectId = relatedSectId;
    }

    public String getRelatedSectNo() {
        return relatedSectNo;
    }

    public void setRelatedSectNo(String relatedSectNo) {
        this.relatedSectNo = relatedSectNo;
    }

    public String getHouseManager() {
        return houseManager;
    }

    public void setHouseManager(String houseManager) {
        this.houseManager = houseManager;
    }

    public String getHouseManagerPerson() {
        return houseManagerPerson;
    }

    public void setHouseManagerPerson(String houseManagerPerson) {
        this.houseManagerPerson = houseManagerPerson;
    }

    public String getSectTel() {
        return sectTel;
    }

    public void setSectTel(String sectTel) {
        this.sectTel = sectTel;
    }
}