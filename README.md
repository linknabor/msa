# 开发之前请看说明!!!

1.msa-common作为平台所有项目的子模块Modules,每个子项目请在pom文件中自行引入如下依赖Dependency:
<dependency>
	<groupId>com.eshequ</groupId>
	<artifactId>msa-common</artifactId>
	<version>${msa.common.version}</version>
</dependency>

2.各子项目的pom中不得自行写入依赖的version，应参照顶级pom中的版本号进行配置,如$(springboot.version)。
3.各子项目都为可独立运行的服务，不依赖其他任何子项目。项目与项目之间以Feign封装的http协议进行通讯。
在顶层pom中引入<modules>节点是为了项目导入时方便，并不是真正意义上地项目间互相依赖，有别于大型企业开发的模块与模块之间的关系。
4.函数、方法的命名请参考阿里巴巴开发手册。忌出现 public void a()形式的函数命名。变量命名应遵守驼峰规则，简单明了。
5.需要用mabatis反向工程生成实体和mapper的请修改resources文件下的generatorConfig.xml。然后在Util包下找到MybatisGeneratorUtill这个类，
执行其中main函数进行反向生成。Eclipse有插件也可自动生成，这里方便使用Idea开发的同学。
反向生成由于设置了生成实体时modelOnly，不会自动生成SQL及其对应的mapper，请自行创建该实体对应的Mapper文件并继承com.eshequ.msa.common.CommonMapper
6.单元测试请在src/test/java目录下写测试用例。
7.Util包暂时放在msa-crm下，公用函数完善后，会放到msa-common组建下。请尽量不要四处编写公用工具函数。
8.单机开发时，如果没有consul，请关闭consul发现服务。在启动类中注释以下行：@EnableDiscoveryClient。
如果使用consul，请下载1.21版本。开发版启动命令行consul agent -dev
9.获取唯一主键的函数的用法：先注入SnowFlake, 然后调用snowFlake.nextId()。在生产环境请在配置文件请配置machine.id和datacenter.id,值设为正整数即可。
10.使用http请求的方法：先注入HttpClientProxy,然后调用doPost等方法。 
11.使用maven编译时可以用公司的maven仓库，速度会比较快。仓库地址:http://svn-service.chinacloudapp.cn:8081/nexus/content/groups/public/
