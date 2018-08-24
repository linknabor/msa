package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**代码类型名：广告位类型  */												 
public class AdLocateType extends CodesItem {                                      
	private AdLocateType(String code){super(CodesItem.adLocateType,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.adLocateType,code);                         
	}                                                                                   
	public static String getValue(AdLocateType code){	                                
		return CodesItem.getValue(CodesItem.adLocateType,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.adLocateType);                           
	}                                                                                   
	public static final AdLocateType getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.adLocateType);                         
		return map==null?null:(AdLocateType)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.adLocateType);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new AdLocateType(temp));                                        
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




	/**广告牌<GuangGaoPai>  */
	public static final AdLocateType GuangGaoPai                             		= getObject("01");
	/**电梯广告<DianTiGuangGao>  */
	public static final AdLocateType DianTiGuangGao                          		= getObject("02");
	/**宣传栏<XuanChuanLan>  */
	public static final AdLocateType XuanChuanLan                            		= getObject("03");
	/**路灯柱<LuDengZhu>  */
	public static final AdLocateType LuDengZhu                               		= getObject("04");
	/**灯箱<DengXiang>  */
	public static final AdLocateType DengXiang                               		= getObject("05");
	/**其他<QiTa>  */
	public static final AdLocateType QiTa                                    		= getObject("99");
}

