package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**�������������˿��״̬  */												 
public class RefundState extends CodesItem {                                      
	private RefundState(String code){super(CodesItem.refundState,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.refundState,code);                         
	}                                                                                   
	public static String getValue(RefundState code){	                                
		return CodesItem.getValue(CodesItem.refundState,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.refundState);                           
	}                                                                                   
	public static final RefundState getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.refundState);                         
		return map==null?null:(RefundState)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.refundState);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new RefundState(temp));                                        
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




	/**�༭<BianJi>  */
	public static final RefundState BianJi                                  		= getObject("00");
	/**�������<JiaoYiWanCheng>  */
	public static final RefundState JiaoYiWanCheng                          		= getObject("01");
	/**���׳���<JiaoYiCheXiao>  */
	public static final RefundState JiaoYiCheXiao                           		= getObject("02");
	/**�����<DaiShenHe>  */
	public static final RefundState DaiShenHe                               		= getObject("03");
	/**������<DaiFuHe>  */
	public static final RefundState DaiFuHe                                 		= getObject("04");
	/**��;<ZaiTu>  */
	public static final RefundState ZaiTu                                   		= getObject("05");
	/**����˻�<ShenHeTuiHui>  */
	public static final RefundState ShenHeTuiHui                            		= getObject("06");
}
