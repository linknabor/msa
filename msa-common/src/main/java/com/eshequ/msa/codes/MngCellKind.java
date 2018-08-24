package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**��������������ҵ��Ԫ����  */												 
public class MngCellKind extends CodesItem {                                      
	private MngCellKind(String code){super(CodesItem.mngCellKind,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.mngCellKind,code);                         
	}                                                                                   
	public static String getValue(MngCellKind code){	                                
		return CodesItem.getValue(CodesItem.mngCellKind,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.mngCellKind);                           
	}                                                                                   
	public static final MngCellKind getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.mngCellKind);                         
		return map==null?null:(MngCellKind)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.mngCellKind);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new MngCellKind(temp));                                        
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




	/**��ͨ��ҵ<PuTongWuYe>  */
	public static final MngCellKind PuTongWuYe                              		= getObject("1");
	/**��������<GongJianPeiTao>  */
	public static final MngCellKind GongJianPeiTao                          		= getObject("2");
	/**��ҵ�÷�<WuYeYongFang>  */
	public static final MngCellKind WuYeYongFang                            		= getObject("3");
	/**�����̲�Ȩ<RenFangGongCheng>  */
	public static final MngCellKind RenFangGongCheng                        		= getObject("4");
}

