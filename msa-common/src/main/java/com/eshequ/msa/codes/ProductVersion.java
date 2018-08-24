package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**代码类型名：产品版本  */												 
public class ProductVersion extends CodesItem {                                      
	private ProductVersion(String code){super(CodesItem.productVersion,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.productVersion,code);                         
	}                                                                                   
	public static String getValue(ProductVersion code){	                                
		return CodesItem.getValue(CodesItem.productVersion,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.productVersion);                           
	}                                                                                   
	public static final ProductVersion getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.productVersion);                         
		return map==null?null:(ProductVersion)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.productVersion);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new ProductVersion(temp));                                        
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




	/**标准版<BiaoZhun>  */
	public static final ProductVersion BiaoZhun                                		= getObject("01");
	/**专业版<ZhuanYe>  */
	public static final ProductVersion ZhuanYe                                 		= getObject("02");
	/**企业版<QiYeBan>  */
	public static final ProductVersion QiYeBan                                 		= getObject("03");
}

