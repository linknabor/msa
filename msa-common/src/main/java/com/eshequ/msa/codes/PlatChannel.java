package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**代码类型名：支付平台  */												 
public class PlatChannel extends CodesItem {                                      
	private PlatChannel(String code){super(CodesItem.platChannel,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.platChannel,code);                         
	}                                                                                   
	public static String getValue(PlatChannel code){	                                
		return CodesItem.getValue(CodesItem.platChannel,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.platChannel);                           
	}                                                                                   
	public static final PlatChannel getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.platChannel);                         
		return map==null?null:(PlatChannel)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.platChannel);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new PlatChannel(temp));                                        
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




	/**微信<Weixin>  */
	public static final PlatChannel Weixin                                  		= getObject("0");
	/**威富通<Swiftpass>  */
	public static final PlatChannel Swiftpass                               		= getObject("1");
	/**河马付<Sand>  */
	public static final PlatChannel Sand                                    		= getObject("2");
	/**通联<Allinpay>  */
	public static final PlatChannel Allinpay                                		= getObject("3");
	/**拉卡拉<Lakala>  */
	public static final PlatChannel Lakala                                  		= getObject("4");
	/**兴业银联刷卡<XingyePos>  */
	public static final PlatChannel XingyePos                               		= getObject("5");
	/**建行银联刷卡<JianHangPos>  */
	public static final PlatChannel JianHangPos                             		= getObject("6");
	/**嘉兴银行刷卡<JiaxingBKPos>  */
	public static final PlatChannel JiaxingBKPos                            		= getObject("7");
	/**拉卡拉刷卡<LakalaPos>  */
	public static final PlatChannel LakalaPos                               		= getObject("8");
	/**建行在线<CbcOnline>  */
	public static final PlatChannel CbcOnline                               		= getObject("9");
	/**慧兜圈<HuiDouQuan>  */
	public static final PlatChannel HuiDouQuan                              		= getObject("A");
	/**财付通<Tenpay>  */
	public static final PlatChannel Tenpay                                  		= getObject("Y");
	/**现金<Cash>  */
	public static final PlatChannel Cash                                    		= getObject("Z");
}

