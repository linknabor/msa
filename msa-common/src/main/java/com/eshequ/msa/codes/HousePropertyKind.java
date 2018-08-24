package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**��������������ҵ��Ȩ����  */												 
public class HousePropertyKind extends CodesItem {                                      
	private HousePropertyKind(String code){super(CodesItem.housePropertyKind,code);}	        
	public static String getValue(String code){                                         
		return CodesItem.getValue(CodesItem.housePropertyKind,code);                         
	}                                                                                   
	public static String getValue(HousePropertyKind code){	                                
		return CodesItem.getValue(CodesItem.housePropertyKind,code.toString());              
	}                                                                                   
	public static List<CodeInfo> getCodeList(){	                                                
		return CodesItem.getCodeList(CodesItem.housePropertyKind);                           
	}                                                                                   
	public static final HousePropertyKind getObject(String code){                          
		Map map=(Map)mapCodeObject.get(CodesItem.housePropertyKind);                         
		return map==null?null:(HousePropertyKind)map.get(code);                                             
	}                                                                                   
	static {		fillObjectToMap();	}                                                   
	private static final void fillObjectToMap(){                                        
		List<CodeInfo> listCode = getCodeFromDB(CodesItem.housePropertyKind);                                                                 
		Map map = new HashMap(listCode.size());        
		String temp = null;	                          
		Map map2 = new HashMap(listCode.size());                           
		for (int i=0; i<listCode.size();i++){                                            
			CodeInfo codeInfo = listCode.get(i);                                              
			temp = codeInfo.getCiSpCode();                                              
			map.put(temp, codeInfo.getCiSpName());                                     
			map2.put(temp, new HousePropertyKind(temp));                                        
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




	/**��Ʒ��<ShangPinFang>  */
	public static final HousePropertyKind ShangPinFang                            		= getObject("1");
	/**�ۺ󹫷�<ShouHouGongFang>  */
	public static final HousePropertyKind ShouHouGongFang                         		= getObject("2");
	/**���޲�Ȩ<YouXianChanQuan>  */
	public static final HousePropertyKind YouXianChanQuan                         		= getObject("3");
	/**ϵͳ����<XiTongGongFang>  */
	public static final HousePropertyKind XiTongGongFang                          		= getObject("4");
	/**ֱ�ܹ���(ֱ��)<ZhiGuanGongFang>  */
	public static final HousePropertyKind ZhiGuanGongFang                         		= getObject("5");
	/**���ʷ�<JingShiFang>  */
	public static final HousePropertyKind JingShiFang                             		= getObject("6");
	/**���ⷿ<LianZuFang>  */
	public static final HousePropertyKind LianZuFang                              		= getObject("7");
	/**��Ǩ��<DongQianFang>  */
	public static final HousePropertyKind DongQianFang                            		= getObject("8");
	/**ֱ�ܹ���(�Թ�)<ZiGuanGongFang>  */
	public static final HousePropertyKind ZiGuanGongFang                          		= getObject("A");
	/**ֱ�ܹ���(����)<DaiGuanGongFang>  */
	public static final HousePropertyKind DaiGuanGongFang                         		= getObject("B");
	/**���޷�<ZuLinFang>  */
	public static final HousePropertyKind ZuLinFang                               		= getObject("C");
	/**���÷������ޣ�<ZuLinKongZhiFang>  */
	public static final HousePropertyKind ZuLinKongZhiFang                        		= getObject("D");
	/**���÷�����Ȩ��<ChanQuanKongZhiFang>  */
	public static final HousePropertyKind ChanQuanKongZhiFang                     		= getObject("E");
	/**�Ǿ�ס�÷����Ǿ����ޣ�<FeiJuZuLin>  */
	public static final HousePropertyKind FeiJuZuLin                              		= getObject("F");
	/**�Ǿ�ס�÷����ǾӲ�Ȩ��<FeiJuChanQuan>  */
	public static final HousePropertyKind FeiJuChanQuan                           		= getObject("G");
	/**�Ǿ�ס�÷����Ӹķǣ�<JuGaiFei>  */
	public static final HousePropertyKind JuGaiFei                                		= getObject("H");
	/**���̣����ޣ�<ZuLinShangPu>  */
	public static final HousePropertyKind ZuLinShangPu                            		= getObject("I");
	/**���̣���Ȩ��<ChanQuanShangPu>  */
	public static final HousePropertyKind ChanQuanShangPu                         		= getObject("J");
	/**���̣����ã�<KongZhiShangPu>  */
	public static final HousePropertyKind KongZhiShangPu                          		= getObject("K");
}

