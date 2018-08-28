package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**������������ͣ������  */												 
public class ParkType extends CodesItem {                                      
	private ParkType(String code){super(CodesItem.parkType,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.parkType,code);                         
	}                                                                                   
	public static String getValue(ParkType code){	                                
		return CodesItem.getValue(CodesItem.parkType,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.parkType);                           
	}                                                                                   
	public static final ParkType getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.parkType);                         
		return map==null?null:(ParkType)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.parkType);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new ParkType(temp));                                        
		}                                                                                 
		mapCategoryCode.put(CodesItem.parkType, map);                                
		mapCodeObject.put(CodesItem.parkType, map2);		                              
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




	/**�̶���λ<GuDingGongGongCheWei>  */
	public static final ParkType GuDingGongGongCheWei                    		= getObject("01");
	/**������λ<BuGuDingGongGongCheWei>  */
	public static final ParkType BuGuDingGongGongCheWei                  		= getObject("02");
	/**˽�ҳ�λ<SiJiaCheWei>  */
	public static final ParkType SiJiaCheWei                             		= getObject("03");
	/**���޳�λ<ZuLinCheWei>  */
	public static final ParkType ZuLinCheWei                             		= getObject("04");
}

