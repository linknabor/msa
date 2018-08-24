package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**代码类型名：证件类型  */												 
public class CertType extends CodesItem {                                      
	private CertType(String code){super(CodesItem.certType,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.certType,code);                         
	}                                                                                   
	public static String getValue(CertType code){	                                
		return CodesItem.getValue(CodesItem.certType,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.certType);                           
	}                                                                                   
	public static final CertType getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.certType);                         
		return map==null?null:(CertType)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.certType);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new CertType(temp));                                        
		}                                                                                 
		mapCategoryCode.put(CodesItem.infoStatus, map);                                
		mapCodeObject.put(CodesItem.infoStatus, map2);		                              
	}                                                                                   
/////////////////////////////////////////////////////////////////////////////////		
	public int hashCode(){return super.hashCode();}
	public boolean equals(Object obj)
	{
		if( obj instanceof CodesItem)
			return (this == obj);
		else
			return super.equals(obj);
	}
/////////////////////////////////////////////////////////////////////////////////    




	/**身份证<ShenFenZheng>  */
	public static final CertType ShenFenZheng                            		= getObject("01");
	/**工作证<GongZuoZheng>  */
	public static final CertType GongZuoZheng                            		= getObject("02");
	/**护照<HuZhao>  */
	public static final CertType HuZhao                                  		= getObject("03");
	/**户口簿<HuKouPu>  */
	public static final CertType HuKouPu                                 		= getObject("04");
	/**学生证<QuanShengZheng>  */
	public static final CertType QuanShengZheng                          		= getObject("05");
	/**营业执照<YingYeZhiZhao>  */
	public static final CertType YingYeZhiZhao                           		= getObject("06");
	/**商业登记证<ShangYeDengJiZheng>  */
	public static final CertType ShangYeDengJiZheng                      		= getObject("07");
	/**回乡证<HuiXiangZheng>  */
	public static final CertType HuiXiangZheng                           		= getObject("08");
	/**绿卡<LvKa>  */
	public static final CertType LvKa                                    		= getObject("09");
	/**军官证<JunGuanZheng>  */
	public static final CertType JunGuanZheng                            		= getObject("10");
	/**旅行证<LvXingZheng>  */
	public static final CertType LvXingZheng                             		= getObject("11");
	/**大陆往来证<DaLuWangLaiZheng>  */
	public static final CertType DaLuWangLaiZheng                        		= getObject("12");
	/**法人代码证<FaRenDaiMaZheng>  */
	public static final CertType FaRenDaiMaZheng                         		= getObject("13");
	/**企业代码证<QiYeDaiMaZheng>  */
	public static final CertType QiYeDaiMaZheng                          		= getObject("14");
	/**登记证<DengJiZheng>  */
	public static final CertType DengJiZheng                             		= getObject("15");
	/**社团法人证<SheTuanFaRenZheng>  */
	public static final CertType SheTuanFaRenZheng                       		= getObject("16");
	/**兵役证<BingYiZheng>  */
	public static final CertType BingYiZheng                             		= getObject("17");
	/**组织机构代码证<ZuZhiJiGouDaiMaZheng>  */
	public static final CertType ZuZhiJiGouDaiMaZheng                    		= getObject("18");
	/**车辆行驶证<CheLiangXingShiZheng>  */
	public static final CertType CheLiangXingShiZheng                    		= getObject("19");
	/**车辆发动机号<CheLiangFaDongJiHao>  */
	public static final CertType CheLiangFaDongJiHao                     		= getObject("20");
	/**其他<QiTa>  */
	public static final CertType QiTa                                    		= getObject("99");
}

