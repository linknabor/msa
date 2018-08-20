package crm;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.eshequ.msa.crm.mapper.CrmMarketingCustMapper;
import com.eshequ.msa.crm.model.CrmMarketingCust;
import com.eshequ.msa.crm.service.TargetCustService;
import com.eshequ.msa.crm.vo.targetcust.TargetCustVo;
import com.eshequ.msa.util.SnowFlake;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.eshequ.msa.crm.config.AppConfig.class)
@WebAppConfiguration
public class TargetCustTest {

	@MockBean
	private CrmMarketingCustMapper targetCustMapper;
	
	@Autowired
	private TargetCustService targetCustService;
	
	
	@Autowired
	private SnowFlake snowFlake;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	public void testTargetCustAdd(){
		
		TargetCustVo vo = new TargetCustVo();
		vo.setCustId(snowFlake.nextId());
		vo.setCityId(snowFlake.nextId());
//		vo.setCustAddr("三林路128号1401室");
//		vo.setCustName("目标客户1");
		vo.setIndustryId(snowFlake.nextId());
		vo.setProvinceId(snowFlake.nextId());
		vo.setRegionId(snowFlake.nextId());
		vo.setRemark("备注1");
		
		
		ResponseEntity<String> s = restTemplate.postForEntity("http://localhost:9090/crm/targetcustAdd", vo, String.class);
		System.out.println("resp : " + s);
	}
	
	public void testTargetCustQuery(){
		List<CrmMarketingCust> list = targetCustService.targetcustQuery("");
		System.out.println(list.toString());
	}
	
}
