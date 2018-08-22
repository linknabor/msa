package crm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.eshequ.msa.crm.config.RestTempletConfig;
import com.eshequ.msa.crm.vo.targetcust.TargetCustVo;
import com.eshequ.msa.util.SnowFlake;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.eshequ.msa.crm.config.AppConfig.class)
@WebAppConfiguration
public class TargetCustTest {

	@Autowired
	private SnowFlake snowFlake;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ClientHttpRequestFactory factory;
	
	
	@Test
	public void testTargetCustAdd(){
		TargetCustVo vo = new TargetCustVo();
		vo.setCityId(snowFlake.nextId()+"");
		vo.setCustAddr("三林路129号999室");
		vo.setCustName("目标客户3");
		vo.setIndustryId(snowFlake.nextId()+"");
		vo.setProvinceId(snowFlake.nextId()+"");
		vo.setRegionId(snowFlake.nextId()+"");
		vo.setRemark("备注1");
		String url = "http://localhost:9090/crm/targetcustAdd";
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, vo, String.class);
		System.out.println("添加成功！");
	}
	
	@Test
	public void testTargetCustQuery(){
		TargetCustVo vo = new TargetCustVo();
		vo.setCustId(snowFlake.nextId()+"");
		vo.setCityId(snowFlake.nextId()+"");
		vo.setCustAddr("三林路128号1401室");
		vo.setCustName("目标客户2");
		vo.setIndustryId(snowFlake.nextId()+"");
		vo.setProvinceId(snowFlake.nextId()+"");
		vo.setRegionId(snowFlake.nextId()+"");
		vo.setRemark("备注1");
		String url = "http://localhost:9090/crm/targetcustQuery";
		restTemplate.postForEntity(url, vo, String.class);
		System.out.println("success");
	}
	
	@Test
	public void testTargetCustEdit(){
		TargetCustVo vo = new TargetCustVo();
		vo.setCustId("4748270664552448");
		vo.setCityId(snowFlake.nextId()+"");
		vo.setCustAddr("三林路999号1401室");
		vo.setCustName("目标客户9");
		vo.setIndustryId(snowFlake.nextId()+"");
		vo.setProvinceId(snowFlake.nextId()+"");
		vo.setRegionId(snowFlake.nextId()+"");
		vo.setRemark("备注2");
		String url = "http://localhost:9090/crm/targetcustEdit";
		restTemplate.postForEntity(url, vo, String.class);
		System.out.println("success");
	}
	
	@Test
	public void testTargetCustDel(){
		String url = "http://localhost:9090/crm/targetcustDel/0";
		restTemplate.postForEntity(url, null, String.class);
		System.out.println("success");
	}
}
