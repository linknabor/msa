# ��ģ��˵��
sso �����¼,��������
ops ��Ӫ����,��������
crm �ͻ�������������
bdp ҵ�����ݹ�Ӧ���񣬵�������
dms ����Ǩ�Ʒ��񣬵�������
common ���ú���ģ�飬����ģ��

# ����֮ǰ�뿴˵��!!!
1.msa-common��Ϊƽ̨������Ŀ����ģ��Modules,ÿ������Ŀ����pom�ļ�������������������Dependency:
<dependency>
	<groupId>com.eshequ</groupId>
	<artifactId>msa-common</artifactId>
	<version>${msa.common.version}</version>
</dependency>

2.������Ŀ��pom�в�������д��������version��Ӧ���ն���pom�еİ汾�Ž�������,��$(springboot.version)��
3.������Ŀ��Ϊ�ɶ������еķ��񣬲����������κ�����Ŀ����Ŀ����Ŀ֮����Feign��װ��httpЭ�����ͨѶ��
�ڶ���pom������<modules>�ڵ���Ϊ����Ŀ����ʱ���㣬���������������ϵ���Ŀ�以���������б��ڴ�����ҵ������ģ����ģ��֮��Ĺ�ϵ��
4.������������������ο�����ͰͿ����ֲᡣ�ɳ��� public void a()��ʽ�ĺ�����������������Ӧ�����շ���򣬼����ˡ�
5.��Ҫ��mabatis���򹤳�����ʵ���mapper�����޸�resources�ļ��µ�generatorConfig.xml��Ȼ����Util�����ҵ�MybatisGeneratorUtill����࣬
ִ������main�������з������ɡ�Eclipse�в��Ҳ���Զ����ɣ����﷽��ʹ��Idea������ͬѧ��
����������������������ʵ��ʱmodelOnly�������Զ�����SQL�����Ӧ��mapper�������д�����ʵ���Ӧ��Mapper�ļ����̳�com.eshequ.msa.common.CommonMapper
6.��Ԫ��������src/test/javaĿ¼��д����������
7.Util����ʱ����msa-crm�£����ú������ƺ󣬻�ŵ�msa-common�齨�¡��뾡����Ҫ�Ĵ���д���ù��ߺ�����
8.��������ʱ�����û��consul����ر�consul���ַ�������������ע�������У�@EnableDiscoveryClient��
���ʹ��consul��������1.21�汾������������������consul agent -dev
9.��ȡΨһ�����ĺ������÷�����ע��SnowFlake, Ȼ�����snowFlake.nextId()���������������������ļ�������machine.id��datacenter.id,ֵ��Ϊ���������ɡ�
10.ʹ��http����ķ�������ע��HttpClientProxy,Ȼ�����doPost�ȷ����� 
11.ʹ��maven����ʱ�����ù�˾��maven�ֿ⣬�ٶȻ�ȽϿ졣�ֿ��ַ:http://svn-service.chinacloudapp.cn:8081/nexus/content/groups/public/
12.�жϷǿ�һ��ʹ��OjbectUtil.isEmpty();
13.ʱ����غ�������DateUtil���߰�
14.jsonת����ʹ��objectMapper���������£�
1)jsonת����
ObjectMapper objectMapper = new ObjectMapper();
Someobj somObj = objectMapper.readValue(respJson, Someobj.class);
2)����תjson�ַ���
ObjectMapper mapper = new ObjectMapper();
String requestJsonStr = mapper.writeValueAsString(map);	//map תjson
15.����ͼƬ��֤��ķ�ʽ:����VeriCodeUtil.generateVeriCode()���ɣ�����һ��vo���������ɵ�4λ�������һ��bufferedImg.
����������
OutputStream os = response.getOutputStream();
VeriCodeVO vo = VeriCodeUtil.generateVeriCode();
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
response.setContentType("image/jpeg");
ImageIO.write(vo.getBufferedImage(), "jpeg", os);String requestJsonStr = mapper.writeValueAsString(map);	//map תjson

16.�쳣����ControllerAdvice���Զ��������������쳣��BusinessException, AppSysException, Exception�����߼��������׳��쳣���ɡ�
17.Controller���� ͳһ��BaseResult��ʽ��