package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**代码类型名：物业项目类型  */												 
public class SectType extends CodesItem {                                      
	private SectType(String code){super(CodesItem.sectType,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.sectType,code);                         
	}                                                                                   
	public static String getValue(SectType code){	                                
		return CodesItem.getValue(CodesItem.sectType,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.sectType);                           
	}                                                                                   
	public static final SectType getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.sectType);                         
		return map==null?null:(SectType)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.sectType);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new SectType(temp));                                        
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




	/**住宅<ZhuZhai>  */
	public static final SectType ZhuZhai                                 		= getObject("01");
	/**商用<ShangYong>  */
	public static final SectType ShangYong                               		= getObject("02");
	/**商住两用<ShangZhuLiangYong>  */
	public static final SectType ShangZhuLiangYong                       		= getObject("03");
}

