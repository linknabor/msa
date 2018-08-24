package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**代码类型名：建筑用途  */												 
public class BuildUsage extends CodesItem {                                      
	private BuildUsage(String code){super(CodesItem.buildUsage,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.buildUsage,code);                         
	}                                                                                   
	public static String getValue(BuildUsage code){	                                
		return CodesItem.getValue(CodesItem.buildUsage,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.buildUsage);                           
	}                                                                                   
	public static final BuildUsage getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.buildUsage);                         
		return map==null?null:(BuildUsage)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.buildUsage);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new BuildUsage(temp));                                        
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
	public static final BuildUsage ZhuZhai                                 		= getObject("01");
	/**商业<ShangYe>  */
	public static final BuildUsage ShangYe                                 		= getObject("02");
	/**车库<CheKu>  */
	public static final BuildUsage CheKu                                   		= getObject("03");
	/**地下室<DiXiaShi>  */
	public static final BuildUsage DiXiaShi                                		= getObject("04");
	/**其他<QiTa>  */
	public static final BuildUsage QiTa                                    		= getObject("99");
}

