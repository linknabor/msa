package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**代码类型名：建筑类型  */												 
public class BuildType extends CodesItem {                                      
	private BuildType(String code){super(CodesItem.buildType,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.buildType,code);                         
	}                                                                                   
	public static String getValue(BuildType code){	                                
		return CodesItem.getValue(CodesItem.buildType,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.buildType);                           
	}                                                                                   
	public static final BuildType getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.buildType);                         
		return map==null?null:(BuildType)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.buildType);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new BuildType(temp));                                        
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




	/**高层<GaoCeng>  */
	public static final BuildType GaoCeng                                 		= getObject("1");
	/**多层<DuoCeng>  */
	public static final BuildType DuoCeng                                 		= getObject("2");
	/**小高层<XiaoGaoCeng>  */
	public static final BuildType XiaoGaoCeng                             		= getObject("3");
	/**联体别墅<LianTiBieShu>  */
	public static final BuildType LianTiBieShu                            		= getObject("4");
	/**单体别墅<DanTiBieShu>  */
	public static final BuildType DanTiBieShu                             		= getObject("5");
	/**其他<QiTa>  */
	public static final BuildType QiTa                                    		= getObject("9");
}

