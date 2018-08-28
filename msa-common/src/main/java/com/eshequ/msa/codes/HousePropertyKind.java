package com.eshequ.msa.codes;																														
/**Auto Created by VBScript Do not modify!*/												 
import java.util.HashMap;                                                                  
import java.util.List;                                                       
import java.util.Map;                                                           
import com.eshequ.msa.codes.model.CodeInfo;                     
/**代码类型名：物业产权性质  */												 
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
		mapCategoryCode.put(CodesItem.housePropertyKind, map);                                
		mapCodeObject.put(CodesItem.housePropertyKind, map2);		                              
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




	/**商品房<ShangPinFang>  */
	public static final HousePropertyKind ShangPinFang                            		= getObject("1");
	/**售后公房<ShouHouGongFang>  */
	public static final HousePropertyKind ShouHouGongFang                         		= getObject("2");
	/**有限产权<YouXianChanQuan>  */
	public static final HousePropertyKind YouXianChanQuan                         		= getObject("3");
	/**系统公房<XiTongGongFang>  */
	public static final HousePropertyKind XiTongGongFang                          		= getObject("4");
	/**直管公房(直管)<ZhiGuanGongFang>  */
	public static final HousePropertyKind ZhiGuanGongFang                         		= getObject("5");
	/**经适房<JingShiFang>  */
	public static final HousePropertyKind JingShiFang                             		= getObject("6");
	/**廉租房<LianZuFang>  */
	public static final HousePropertyKind LianZuFang                              		= getObject("7");
	/**动迁房<DongQianFang>  */
	public static final HousePropertyKind DongQianFang                            		= getObject("8");
	/**直管公房(自管)<ZiGuanGongFang>  */
	public static final HousePropertyKind ZiGuanGongFang                          		= getObject("A");
	/**直管公房(代管)<DaiGuanGongFang>  */
	public static final HousePropertyKind DaiGuanGongFang                         		= getObject("B");
	/**租赁房<ZuLinFang>  */
	public static final HousePropertyKind ZuLinFang                               		= getObject("C");
	/**空置房（租赁）<ZuLinKongZhiFang>  */
	public static final HousePropertyKind ZuLinKongZhiFang                        		= getObject("D");
	/**空置房（产权）<ChanQuanKongZhiFang>  */
	public static final HousePropertyKind ChanQuanKongZhiFang                     		= getObject("E");
	/**非居住用房（非居租赁）<FeiJuZuLin>  */
	public static final HousePropertyKind FeiJuZuLin                              		= getObject("F");
	/**非居住用房（非居产权）<FeiJuChanQuan>  */
	public static final HousePropertyKind FeiJuChanQuan                           		= getObject("G");
	/**非居住用房（居改非）<JuGaiFei>  */
	public static final HousePropertyKind JuGaiFei                                		= getObject("H");
	/**商铺（租赁）<ZuLinShangPu>  */
	public static final HousePropertyKind ZuLinShangPu                            		= getObject("I");
	/**商铺（产权）<ChanQuanShangPu>  */
	public static final HousePropertyKind ChanQuanShangPu                         		= getObject("J");
	/**商铺（空置）<KongZhiShangPu>  */
	public static final HousePropertyKind KongZhiShangPu                          		= getObject("K");
}

