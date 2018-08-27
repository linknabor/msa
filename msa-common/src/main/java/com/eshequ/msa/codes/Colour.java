package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**代码类型名：颜色  */												 
public class Colour extends CodesItem {                                      
	private Colour(String code){super(CodesItem.colour,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.colour,code);                         
	}                                                                                   
	public static String getValue(Colour code){	                                
		return CodesItem.getValue(CodesItem.colour,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.colour);                           
	}                                                                                   
	public static final Colour getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.colour);                         
		return map==null?null:(Colour)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.colour);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new Colour(temp));                                        
		}                                                                                 
		mapCategoryCode.put(CodesItem.colour, map);                                
		mapCodeObject.put(CodesItem.colour, map2);		                              
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




	/**黑<Hei>  */
	public static final Colour Hei                                     		= getObject("01");
	/**白<Bai>  */
	public static final Colour Bai                                     		= getObject("02");
	/**银<Yin>  */
	public static final Colour Yin                                     		= getObject("03");
	/**金<Jin>  */
	public static final Colour Jin                                     		= getObject("04");
	/**灰<Hui>  */
	public static final Colour Hui                                     		= getObject("05");
	/**红<Hong>  */
	public static final Colour Hong                                    		= getObject("06");
	/**褐<He>  */
	public static final Colour He                                      		= getObject("07");
	/**橙<Cheng>  */
	public static final Colour Cheng                                   		= getObject("08");
	/**黄<Huang>  */
	public static final Colour Huang                                   		= getObject("09");
	/**绿<Lv>  */
	public static final Colour Lv                                      		= getObject("10");
	/**青<Qing>  */
	public static final Colour Qing                                    		= getObject("11");
	/**蓝<Lan>  */
	public static final Colour Lan                                     		= getObject("12");
	/**紫<Zi>  */
	public static final Colour Zi                                      		= getObject("13");
	/**其他<QiTa>  */
	public static final Colour QiTa                                    		= getObject("99");
}

