package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**������������֧������  */												 
public class PayMethod extends CodesItem {                                      
	private PayMethod(String code){super(CodesItem.payMethod,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.payMethod,code);                         
	}                                                                                   
	public static String getValue(PayMethod code){	                                
		return CodesItem.getValue(CodesItem.payMethod,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.payMethod);                           
	}                                                                                   
	public static final PayMethod getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.payMethod);                         
		return map==null?null:(PayMethod)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.payMethod);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new PayMethod(temp));                                        
		}                                                                                 
		mapCategoryCode.put(CodesItem.payMethod, map);                                
		mapCodeObject.put(CodesItem.payMethod, map2);		                              
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




	/**�ֽ�<XianJin>  */
	public static final PayMethod XianJin                                 		= getObject("01");
	/**ת��<ZhuanZhang>  */
	public static final PayMethod ZhuanZhang                              		= getObject("02");
	/**POS���ѻ���<Pos>  */
	public static final PayMethod Pos                                     		= getObject("03");
	/**֧����<AliPayWeb>  */
	public static final PayMethod AliPayWeb                               		= getObject("04");
	/**�Ƹ�ͨ<TenPayWeb>  */
	public static final PayMethod TenPayWeb                               		= getObject("05");
	/**΢�Ź��ں�<WeChat>  */
	public static final PayMethod WeChat                                  		= getObject("06");
	/**΢��App<WechatApp>  */
	public static final PayMethod WechatApp                               		= getObject("07");
	/**΢��ɨ��<WechatMicropay>  */
	public static final PayMethod WechatMicropay                          		= getObject("08");
	/**֧����ɨ��<AliPayMicropay>  */
	public static final PayMethod AliPayMicropay                          		= getObject("09");
	/**POS��������<MobilePos>  */
	public static final PayMethod MobilePos                               		= getObject("10");
	/**�Ϻ���ҵApp<WyFeeMp>  */
	public static final PayMethod WyFeeMp                                 		= getObject("99");
}

