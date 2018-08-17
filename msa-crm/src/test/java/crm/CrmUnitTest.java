package crm;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.eshequ.msa.crm.mapper.SpBaseCspMapper;
import com.eshequ.msa.crm.mapper.SpServeBillPayTradeMapper;
import com.eshequ.msa.crm.model.SpBaseCsp;
import com.eshequ.msa.crm.model.SpServeBillPayTrade;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.EntityField;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.eshequ.msa.crm.config.AppConfig.class)
@WebAppConfiguration
public class CrmUnitTest {
	
	
	@Autowired
	private SpBaseCspMapper spBaseCspMapper;
	
	@Autowired
	private SpServeBillPayTradeMapper spServeBillPayTradeMapper;
	
	@Test
	public void testJoinQuery() {
		
		String cspId = "160419100038865011";
		List<SpServeBillPayTrade> list = spServeBillPayTradeMapper.getBillTradeByCsp(cspId);
		
		for (SpServeBillPayTrade spServeBillPayTrade : list) {
			
			System.out.println(spServeBillPayTrade.getTradeWaterId());
		}
	}
	
	@Test
	public void testQuery() {
		
		PageHelper.startPage(0, 10, true);
		
		List<SpBaseCsp> list = spBaseCspMapper.selectAll();
		System.out.println(list.size());
		for (SpBaseCsp spBaseCsp : list) {
			System.out.println(spBaseCsp.getCspName());
		}
		
//		SpBaseCsp csp = spBaseCspMapper.selectByPrimaryKey(Long.valueOf("130320100000000059"));
//		System.out.println(csp.getCspName());
	}
	
	public static void main(String[] args) {
		
//		getFields(SpBaseCsp.class, null, null);
		
		Type[]types = SpBaseCspMapper.class.getGenericInterfaces();
		for (Type type : types) {
			System.out.println(type.getTypeName());
		}
		
		Type[]types2 = SpServeBillPayTradeMapper.class.getGenericInterfaces();
		for (Type type : types2) {
			System.out.println(type.getTypeName());
		}
		
	}
	
	
	private static List<EntityField> getFields(Class<?> entityClass, List<EntityField> fieldList, Integer level) {
        
        Field[] fields = entityClass.getDeclaredFields();
        int index = 0;
        for (int i = 0; i < fields.length; i++) {
    	}
		return fieldList;
	}
	
}
