package com.eshequ.msa.codes;																																
/**Auto Created by VBScript Do not modify!*/																								 	
import java.util.ArrayList;                                                                 	
import java.util.Collections;                                                         				
import java.util.Comparator;                                                    							
import java.util.HashMap;                                       															
import java.util.Iterator;                                      															
import java.util.List;                                                           						
import java.util.Map;                                                           							
import javax.annotation.PostConstruct;                                                       
import org.springframework.beans.factory.annotation.Autowired;                               
import org.springframework.stereotype.Component;                                             
import com.eshequ.msa.codes.mapper.CodeInfoMapper;                                           
import com.eshequ.msa.codes.model.CodeInfo;                                                  
import com.eshequ.msa.exception.NotFoundException;                                           
@Component                                                                                   
public class CodesItem {                                                      			
	
	protected static final String orgStatus=new String("50");
	
	protected static final String invoiceType=new String("52");
	
	protected static final String invoiceStatus=new String("53");
	
	protected static final String invoiceApplyType=new String("54");
	
	protected static final String regInfoStatus=new String("55");
	
	protected static final String orgType=new String("56");
	
	protected static final String proCreateType=new String("18");
	
	protected static final String sectType=new String("19");
	
	protected static final String infoStatus=new String("20");
	
	protected static final String buildType=new String("21");
	
	protected static final String isFlag=new String("22");
	
	protected static final String houseModel=new String("23");
	
	protected static final String carportType=new String("24");
	
	protected static final String ward=new String("25");
	
	protected static final String shopsType=new String("26");
	
	protected static final String adLocateType=new String("27");
	
	protected static final String mngCellKind=new String("28");
	
	protected static final String housePropertyKind=new String("29");
	
	protected static final String liftFlag=new String("30");
	
	protected static final String buildUsage=new String("31");
	
	protected static final String mngCellType=new String("32");
	
	protected static final String parkType=new String("33");
	
	protected static final String carType=new String("34");
	
	protected static final String colour=new String("35");
	
	protected static final String carOwnerType=new String("36");
	
	protected static final String certType=new String("38");
	
	protected static final String custType=new String("39");
	
	protected static final String custKind=new String("40");
	
	protected static final String payMethod=new String("41");
	
	protected static final String platChannel=new String("42");
	
	protected static final String mchType=new String("43");
	
	protected static final String tradeState=new String("44");
	
	protected static final String refundState=new String("45");
	
	protected static final String productVersion=new String("46");
	
	protected static final String cardType=new String("49");
	
	protected static final String smsStatus=new String("58");
	
	protected static final String menuFunLevel=new String("59");


	protected static final Map mapCat= new HashMap(100);
	static{
		mapCat.put("OrgStatus",orgStatus);
		mapCat.put("InvoiceType",invoiceType);
		mapCat.put("InvoiceStatus",invoiceStatus);
		mapCat.put("InvoiceApplyType",invoiceApplyType);
		mapCat.put("RegInfoStatus",regInfoStatus);
		mapCat.put("OrgType",orgType);
		mapCat.put("ProCreateType",proCreateType);
		mapCat.put("SectType",sectType);
		mapCat.put("InfoStatus",infoStatus);
		mapCat.put("BuildType",buildType);
		mapCat.put("IsFlag",isFlag);
		mapCat.put("HouseModel",houseModel);
		mapCat.put("CarportType",carportType);
		mapCat.put("Ward",ward);
		mapCat.put("ShopsType",shopsType);
		mapCat.put("AdLocateType",adLocateType);
		mapCat.put("MngCellKind",mngCellKind);
		mapCat.put("HousePropertyKind",housePropertyKind);
		mapCat.put("LiftFlag",liftFlag);
		mapCat.put("BuildUsage",buildUsage);
		mapCat.put("MngCellType",mngCellType);
		mapCat.put("ParkType",parkType);
		mapCat.put("CarType",carType);
		mapCat.put("Colour",colour);
		mapCat.put("CarOwnerType",carOwnerType);
		mapCat.put("CertType",certType);
		mapCat.put("CustType",custType);
		mapCat.put("CustKind",custKind);
		mapCat.put("PayMethod",payMethod);
		mapCat.put("PlatChannel",platChannel);
		mapCat.put("MchType",mchType);
		mapCat.put("TradeState",tradeState);
		mapCat.put("RefundState",refundState);
		mapCat.put("ProductVersion",productVersion);
		mapCat.put("CardType",cardType);
		mapCat.put("SmsStatus",smsStatus);
		mapCat.put("MenuFunLevel",menuFunLevel);
	}


	protected static final  Map mapCategoryCode=new HashMap(100);																			
	protected static final  Map mapCodeObject=new HashMap(100);																				
 private static CodeInfoMapper mapper;
 @Autowired
 private CodeInfoMapper codeInfoMapper;
	public boolean equals(String obj) {                                                               
		return this.code.equals(obj);                                                        						
	}                                                                                                 
	public boolean equals(Object obj) {  
		return this.code.equals(obj);                                                           				
	}                                                                                            			
	public String toString(){ return this.code; }                                                     
	                                                                                                  
	/**根据指定的代码值转换成中文名字                                                                 
	 * @param category   本代码所属的类别的编号                                                       
	 * @param code   本代码的代码值                                                                   
	 * @return                                                                                        
	 */                                                                                               
	protected static String getValue(String category,String code){                                    
		Map map=(Map)mapCategoryCode.get(category);                                                     
		if(map==null) return "";                                    						              				
		String temp=(String)map.get(code);                                    						  						
		return (temp==null)? "" : temp;                                    														
	}

		public static List<CodeInfo> getCodeList(String categoryCode){
		   List<CodeInfo> list = new ArrayList<CodeInfo>();
		   Map mp = (Map)mapCategoryCode.get(categoryCode);
		   if(mp==null) return list;
		   String temp;
		   for (Iterator it = mp.keySet().iterator(); it.hasNext();){
		      temp = (String)it.next();
		      CodeInfo codeInfo = new CodeInfo();
		      codeInfo.setCiSpClass(categoryCode);
		      codeInfo.setCiSpCode(temp);
		      codeInfo.setCiSpName((String)mp.get(temp));
		      list.add(codeInfo);
		      }
		      Collections.sort(list, new Comparator<CodeInfo>() {
		         @Override
		         public int compare(CodeInfo o1, CodeInfo o2) {
		            int i = o1.getCiSpCode().compareTo(o2.getCiSpCode());
		      			if (i==0) {return o1.getCiSpName().compareTo(o2.getCiSpName());}
		            return i;
		         }
		      });
		      return list;
   }

		public static Map getCategoryItems(String categoryName){
		   String categoryCode = (String)mapCat.get(categoryName);
		   if(categoryCode==null)
		      throw new RuntimeException(categoryName + "代码大类别未进行初始化！");
		   
		   Map mp=(Map)mapCategoryCode.get(categoryCode);
		   return mp;
		}

	/**                                                                                               
	 * 直接转换成中文名字                                                                             
	 * @return                                                                                        
	 */                                                                                               
	public  String getValue(){                                                                        
		 return getValue( this.category,this.code);                                                     
	}                                                                                                 
	public CodesItem() {
	}                                                                                                 
	
	@PostConstruct                                                                                    
	public void init() {                                                                              
	   mapper = this.codeInfoMapper;                                                                  
	}                                                                                                 
	/**                                                                                               
	 * 构造函数.                                                                                      
	 * @param category   本代码所属的类别的编号                                                       
	 * @param code   本代码的代码值                                                                   
	 */                                                                                               
	protected  CodesItem(String category,String code){                                                
		this.category=category;                                                                         
		this.code=code;                                                                                 
	}                                                                                                 
	                                                                                                  
	protected static final List<CodeInfo> getCodeFromDB(String category) {             							
			List<CodeInfo> list = mapper.selectByClass(category);                                  
			if(list.size()<1){	                                                                        
				throw new NotFoundException("当前使用的代码项在数据库无法取到 code=" + category);             
			}                                                                                     
		return list;                                                                                      
	}                                                                                                 
	private String code;                                                                              
	protected String category;                                                                        
	public  String getCategoryCode(){                                                
		return category;                                                                                 
	}                                                                                                 
}                                                                                                  



