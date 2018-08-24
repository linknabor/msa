package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**��������������������  */												 
public class CarType extends CodesItem {                                      
	private CarType(String code){super(CodesItem.carType,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.carType,code);                         
	}                                                                                   
	public static String getValue(CarType code){	                                
		return CodesItem.getValue(CodesItem.carType,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.carType);                           
	}                                                                                   
	public static final CarType getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.carType);                         
		return map==null?null:(CarType)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.carType);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new CarType(temp));                                        
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




	/**�γ�<JiaoChe>  */
	public static final CarType JiaoChe                                 		= getObject("01");
	/**ԽҰ��<YueYeChe>  */
	public static final CarType YueYeChe                                		= getObject("02");
	/**�ܳ�<PaoChe>  */
	public static final CarType PaoChe                                  		= getObject("03");
	/**���г�<LvXingChe>  */
	public static final CarType LvXingChe                               		= getObject("04");
	/**�ͳ�<KeChe>  */
	public static final CarType KeChe                                   		= getObject("05");
	/**����<HuoChe>  */
	public static final CarType HuoChe                                  		= getObject("06");
	/**����<QiTa>  */
	public static final CarType QiTa                                    		= getObject("99");
}

