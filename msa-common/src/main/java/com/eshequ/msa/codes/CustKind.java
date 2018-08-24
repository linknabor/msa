package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**代码类型名：客户性质  */												 
public class CustKind extends CodesItem {                                      
	private CustKind(String code){super(CodesItem.custKind,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.custKind,code);                         
	}                                                                                   
	public static String getValue(CustKind code){	                                
		return CodesItem.getValue(CodesItem.custKind,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.custKind);                           
	}                                                                                   
	public static final CustKind getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.custKind);                         
		return map==null?null:(CustKind)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.custKind);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new CustKind(temp));                                        
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




	/**业主<YeZhu>  */
	public static final CustKind YeZhu                                   		= getObject("01");
	/**租户<ZuLin>  */
	public static final CustKind ZuLin                                   		= getObject("02");
	/**居住人<JuZhu>  */
	public static final CustKind JuZhu                                   		= getObject("03");
}

