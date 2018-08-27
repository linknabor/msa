package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**代码类型名：机构状态  */												 
public class OrgStart extends CodesItem {                                      
	private OrgStart(String code){super(CodesItem.orgStart,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.orgStart,code);                         
	}                                                                                   
	public static String getValue(OrgStart code){	                                
		return CodesItem.getValue(CodesItem.orgStart,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.orgStart);                           
	}                                                                                   
	public static final OrgStart getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.orgStart);                         
		return map==null?null:(OrgStart)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.orgStart);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new OrgStart(temp));                                        
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




	/**正常<ZhengChang>  */
	public static final OrgStart ZhengChang                              		= getObject("0");
	/**注销<ZhuXiao>  */
	public static final OrgStart ZhuXiao                                 		= getObject("1");
}

