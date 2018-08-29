package crm;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.eshequ.msa.crm.vo.para.ParaVo;
import com.eshequ.msa.util.SnowFlake;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.eshequ.msa.crm.config.AppConfig.class)
@WebAppConfiguration
public class SysParaTest {

	@Autowired
	private SnowFlake snowFlake;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void testSysParaEdit(){
		ParaVo vo = new ParaVo();
		String url = "http://localhost:9090/crm/paraEdit";
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, vo, String.class);
		System.out.println("编辑成功！");
	}
}
