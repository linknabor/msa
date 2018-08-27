package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**������������֤������  */												 
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
		mapCategoryCode.put(CodesItem.certType, map);                                
		mapCodeObject.put(CodesItem.certType, map2);		                              
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




	/**���֤<ShenFenZheng>  */
	public static final CertType ShenFenZheng                            		= getObject("01");
	/**����֤<GongZuoZheng>  */
	public static final CertType GongZuoZheng                            		= getObject("02");
	/**����<HuZhao>  */
	public static final CertType HuZhao                                  		= getObject("03");
	/**���ڲ�<HuKouPu>  */
	public static final CertType HuKouPu                                 		= getObject("04");
	/**ѧ��֤<QuanShengZheng>  */
	public static final CertType QuanShengZheng                          		= getObject("05");
	/**Ӫҵִ��<YingYeZhiZhao>  */
	public static final CertType YingYeZhiZhao                           		= getObject("06");
	/**��ҵ�Ǽ�֤<ShangYeDengJiZheng>  */
	public static final CertType ShangYeDengJiZheng                      		= getObject("07");
	/**����֤<HuiXiangZheng>  */
	public static final CertType HuiXiangZheng                           		= getObject("08");
	/**�̿�<LvKa>  */
	public static final CertType LvKa                                    		= getObject("09");
	/**����֤<JunGuanZheng>  */
	public static final CertType JunGuanZheng                            		= getObject("10");
	/**����֤<LvXingZheng>  */
	public static final CertType LvXingZheng                             		= getObject("11");
	/**��½����֤<DaLuWangLaiZheng>  */
	public static final CertType DaLuWangLaiZheng                        		= getObject("12");
	/**���˴���֤<FaRenDaiMaZheng>  */
	public static final CertType FaRenDaiMaZheng                         		= getObject("13");
	/**��ҵ����֤<QiYeDaiMaZheng>  */
	public static final CertType QiYeDaiMaZheng                          		= getObject("14");
	/**�Ǽ�֤<DengJiZheng>  */
	public static final CertType DengJiZheng                             		= getObject("15");
	/**���ŷ���֤<SheTuanFaRenZheng>  */
	public static final CertType SheTuanFaRenZheng                       		= getObject("16");
	/**����֤<BingYiZheng>  */
	public static final CertType BingYiZheng                             		= getObject("17");
	/**��֯��������֤<ZuZhiJiGouDaiMaZheng>  */
	public static final CertType ZuZhiJiGouDaiMaZheng                    		= getObject("18");
	/**������ʻ֤<CheLiangXingShiZheng>  */
	public static final CertType CheLiangXingShiZheng                    		= getObject("19");
	/**������������<CheLiangFaDongJiHao>  */
	public static final CertType CheLiangFaDongJiHao                     		= getObject("20");
	/**����<QiTa>  */
	public static final CertType QiTa                                    		= getObject("99");
}

