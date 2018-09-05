CREATE database msadatacenter DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use msadatacenter;

#商铺信息表
DROP TABLE IF EXISTS MSA_BASE_SHOPS ;
CREATE TABLE MSA_BASE_SHOPS(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #物业单元ID
SHOPS_TYPE                                        CHAR(2) NULL, #商铺类型
SHOPS_AREA                                        VARCHAR(20) NULL, #套内建筑面积
SHOPS_PHONE                                       VARCHAR(40) NULL, #固定电话
CONSTRAINT MSA_BASE_SHOPS_PK PRIMARY KEY(MNG_CELL_ID)   );

#客户车辆初始缴费日期表
DROP TABLE IF EXISTS MSA_BASE_CUST_CAR_FEE_START_DATE ;
CREATE TABLE MSA_BASE_CUST_CAR_FEE_START_DATE(
CAR_ID                                            BIGINT default 0 NOT NULL, #车辆ID
FEE_START_DATE                                    CHAR(8) NOT NULL, #缴费开始日期
PAYMENT_DATE                                      CHAR(8) NULL, #缴费有效日期
CONSTRAINT MSA_BASE_CUST_CAR_FEE_START_DATE_PK PRIMARY KEY(CAR_ID)   );

#客户信息表
DROP TABLE IF EXISTS MSA_BASE_CUST ;
CREATE TABLE MSA_BASE_CUST(
CUST_ID                                           BIGINT default 0 NOT NULL, #客户ID
CUST_STATUS                                       CHAR(1) NOT NULL, #状态
CUST_NAME                                         VARCHAR(160) NOT NULL, #客户名称
CUST_TYPE                                         CHAR(2) NOT NULL, #客户类型
CODE_TYPE                                         CHAR(2) NULL, #证件类型
CUST_CODE                                         VARCHAR(80) NULL, #证件号码/组织机构代码
TEL_NO                                            VARCHAR(40) NULL, #联系电话
ACCT_BANK                                         VARCHAR(160) NULL, #开户银行名称
ACCT_NAME                                         VARCHAR(160) NULL, #银行账户名称
ACCT_NO                                           VARCHAR(64) NULL, #银行账号
REMARK                                            VARCHAR(512) NULL, #备注
CUST_ACCT_NO                                      BIGINT default 0 NOT NULL, #客户账号
IS_CERTIFI                                        CHAR(1) default '0' NOT NULL, #是否已认证
RELATED_CUST_NO                                   VARCHAR(40) NULL, #关联客户信息编号
CONSTRAINT MSA_BASE_CUST_PK PRIMARY KEY(CUST_ID)   );

#房屋客户关联关系表
DROP TABLE IF EXISTS MSA_CELL_CUST ;
CREATE TABLE MSA_CELL_CUST(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #物业单元ID
CUST_ID                                           BIGINT default 0 NOT NULL, #客户ID
CUST_KIND                                         CHAR(2) NOT NULL, #客户性质
CONSTRAINT MSA_CELL_CUST_PK PRIMARY KEY(MNG_CELL_ID,CUST_ID)   );

#车辆物业关系表
DROP TABLE IF EXISTS MSA_CUST_CAR ;
CREATE TABLE MSA_CUST_CAR(
CUST_ID                                           BIGINT default 0 NOT NULL, #客户ID
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #物业单元ID
CAR_ID                                            BIGINT default 0 NOT NULL, #车辆ID
CONSTRAINT MSA_CUST_CAR_PK PRIMARY KEY(CUST_ID,MNG_CELL_ID,CAR_ID)   );

#停车关系表
DROP TABLE IF EXISTS MSA_PARK_CAR ;
CREATE TABLE MSA_PARK_CAR(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #物业单元ID
CUST_ID                                           BIGINT default 0 NOT NULL, #客户ID
CAR_ID                                            BIGINT default 0 NOT NULL, #车辆ID
CONSTRAINT MSA_PARK_CAR_PK PRIMARY KEY(MNG_CELL_ID,CUST_ID,CAR_ID)   );

#商户信息表
DROP TABLE IF EXISTS MSA_MCH_INFO ;
CREATE TABLE MSA_MCH_INFO(
MCH_INFO_ID                                       BIGINT default 0 NOT NULL, #商户信息ID
MCH_ID                                            VARCHAR(256) NOT NULL, #商户号
MCH_NAME                                          VARCHAR(80) NOT NULL, #商户名称
MCH_TYPE                                          CHAR(1) NOT NULL, #商户类型
MCH_STATUS                                        CHAR(1) NOT NULL, #商户状态
SECRET                                            VARCHAR(256) NULL, #商户密钥
APPID                                             VARCHAR(20) NULL, #应用ID
PLAT_CHANNEL                                      CHAR(1) NULL, #支付平台
BANK_ACCT                                         VARCHAR(32) NULL, #银行结算账户
ACCT_NAME                                         VARCHAR(256) NULL, #结算账户名称
BANK_NAME                                         VARCHAR(256) NULL, #结算账户开户行
CREATE_DATE                                       CHAR(8) NULL, #创建日期
CREATE_TIME                                       CHAR(6) NULL, #创建时间
MCH_SUBJECT                                       VARCHAR(255) NULL, #商户主体
SUBJECT_ID                                        VARCHAR(255) NULL, #主体ID
PARENT_MCH_INFO_ID                                BIGINT default 0 NOT NULL, #商户信息ID
CONSTRAINT MSA_MCH_INFO_PK PRIMARY KEY(MCH_INFO_ID)   );

#商户渠道费率关系表
DROP TABLE IF EXISTS MSA_MCH_RATE ;
CREATE TABLE MSA_MCH_RATE(
MCH_INFO_ID                                       BIGINT default 0 NOT NULL, #商户信息ID
PAY_METHOD                                        CHAR(2) NOT NULL, #支付渠道
PAY_RATE                                          DECIMAL(5,2) NULL, #支付费率
CONSTRAINT MSA_MCH_RATE_CHK3 CHECK(PAY_RATE<=100.00),
CONSTRAINT MSA_MCH_RATE_PK PRIMARY KEY(MCH_INFO_ID,PAY_METHOD)   );

#支付配置信息表
DROP TABLE IF EXISTS MSA_MCH_CFG_PAY ;
CREATE TABLE MSA_MCH_CFG_PAY(
PAY_METHOD                                        CHAR(2) NOT NULL, #支付渠道
PAY_SCENARIOS                                     CHAR(2) default '00' NOT NULL, #支付场景
INFO_ID                                           VARCHAR(38) NOT NULL, #信息ID
MCH_INFO_ID                                       BIGINT default 0 NOT NULL, #商户信息ID
CONSTRAINT MSA_MCH_CFG_PAY_PK PRIMARY KEY(PAY_METHOD,PAY_SCENARIOS,INFO_ID,MCH_INFO_ID)   );

#商户渠道多费率关系表
DROP TABLE IF EXISTS MSA_MCH_MULTI_RATE ;
CREATE TABLE MSA_MCH_MULTI_RATE(
MCH_INFO_ID                                       BIGINT default 0 NOT NULL, #商户信息ID
PAY_METHOD                                        CHAR(2) NOT NULL, #支付渠道
METHOD_WAY                                        VARCHAR(10) NOT NULL, #渠道方式
PAY_RATE                                          DECIMAL(5,2) NULL, #支付费率
CONSULT_THRESHOLD                                 VARCHAR(20) NULL, #费率金额阈值
CONSTRAINT MSA_MCH_MULTI_RATE_CHK4 CHECK(PAY_RATE<=100.00),
CONSTRAINT MSA_MCH_MULTI_RATE_PK PRIMARY KEY(MCH_INFO_ID,PAY_METHOD,METHOD_WAY)   );



#系统配置参数表
DROP TABLE IF EXISTS MSA_CFG_SYS_PARA ;
CREATE TABLE MSA_CFG_SYS_PARA(
PARA_ID                                           BIGINT default 0 NOT NULL, #参数ID
PARA_NAME                                         VARCHAR(40) NOT NULL, #参数名称
PARA_VALUE                                        VARCHAR(40) NOT NULL, #参数值
PARA_TYPE                                         CHAR(1) NOT NULL, #参数类型
REMARK                                            VARCHAR(512) NULL, #备注
CONSTRAINT MSA_CFG_SYS_PARA_PK PRIMARY KEY(PARA_ID)   );


#省份信息表
DROP TABLE IF EXISTS MSA_BASE_PROVINCE ;
CREATE TABLE MSA_BASE_PROVINCE(
PROVINCE_ID                                       BIGINT default 0 NOT NULL, #省份ID
PROVINCE_STATUS                                   CHAR(1) NOT NULL, #状态
PROVINCE_NAME                                     VARCHAR(256) NOT NULL, #省份名称
PROVINCE_SHORT_NAME                               VARCHAR(40) NULL, #省份简称
REMARK                                            VARCHAR(512) NULL, #备注
CONSTRAINT MSA_BASE_PROVINCE_PK PRIMARY KEY(PROVINCE_ID)   );

#城市信息表
DROP TABLE IF EXISTS MSA_BASE_CITY ;
CREATE TABLE MSA_BASE_CITY(
CITY_ID                                           BIGINT default 0 NOT NULL, #城市ID
CITY_STATUS                                       CHAR(1) NOT NULL, #状态
CITY_NAME                                         VARCHAR(256) NOT NULL, #城市名称
CITY_CODE                                         VARCHAR(5) NULL, #城市代码
REMARK                                            VARCHAR(512) NULL, #备注
PROVINCE_ID                                       BIGINT default 0 NULL, #省份ID
CONSTRAINT MSA_BASE_CITY_PK PRIMARY KEY(CITY_ID)   );


#行政区域信息表
DROP TABLE IF EXISTS MSA_BASE_REGION ;
CREATE TABLE MSA_BASE_REGION(
REGION_ID                                         BIGINT default 0 NOT NULL, #行政区域ID
REGION_STATUS                                     CHAR(1) NOT NULL, #状态
REGION_NAME                                       VARCHAR(256) NOT NULL, #行政区域名称
REMARK                                            VARCHAR(512) NULL, #备注
CITY_ID                                           BIGINT default 0 NULL, #城市ID
CONSTRAINT MSA_BASE_REGION_PK PRIMARY KEY(REGION_ID)   );


#企业客户信息表
DROP TABLE IF EXISTS MSA_BASE_ENTERPRISE ;
CREATE TABLE MSA_BASE_ENTERPRISE(
ENTERPRISE_ID                                     VARCHAR(38) NOT NULL, #企业客户ID
CUST_STATE                                        CHAR(1) NULL, #客户状态
CUST_NAME                                         VARCHAR(80) NULL, #客户名称
CUST_ADDR                                         VARCHAR(256) NULL, #客户地址
ENTERPRISE_TYPE                                   CHAR(2) NULL, #企业客户类型
CUST_TEL                                          VARCHAR(40) NULL, #联系方式
REMARK                                            VARCHAR(512) NULL, #备注
PROVINCE_ID                                       BIGINT default 0 NOT NULL, #省份ID
CITY_ID                                           BIGINT default 0 NOT NULL, #城市ID
REGION_ID                                         BIGINT default 0 NOT NULL, #行政区域ID
ORIGIN_ID                                         VARCHAR(40) NULL, #原系统ID
ORIGIN_SYS                                        BIGINT default 0 NULL, #源系统
CONSTRAINT MSA_BASE_ENTERPRISE_PK PRIMARY KEY(ENTERPRISE_ID)   );



#物业项目信息表
DROP TABLE IF EXISTS MSA_BASE_SECT ;
CREATE TABLE MSA_BASE_SECT(
SECT_ID                                           BIGINT default 0 NOT NULL, #物业项目ID
STATUS                                            CHAR(1) NOT NULL, #状态
SECT_TYPE                                         CHAR(2) NOT NULL, #项目类型
PRO_TYPE                                          CHAR(1) NULL, #项目性质
SECT_NAME                                         VARCHAR(256) NOT NULL, #名称
SECT_ADDR                                         VARCHAR(256) NOT NULL, #地址
SECT_ROAD                                         VARCHAR(80) NULL, #路
SECT_STREET                                       VARCHAR(80) NULL, #弄
SECT_SUB_STREET                                   VARCHAR(80) NULL, #支弄
SECT_NO                                           VARCHAR(80) NULL, #号
REMARK                                            VARCHAR(512) NULL, #备注
PROVINCE_ID                                       BIGINT default 0 NOT NULL, #省份ID
REGION_ID                                         BIGINT default 0 NOT NULL, #行政区域ID
CITY_ID                                           BIGINT default 0 NOT NULL, #城市ID
ZIP_CODE                                          VARCHAR(6) NULL, #邮政编码
CNST_AREA                                         VARCHAR(20) NULL, #建筑面积
LAND_AREA                                         VARCHAR(20) NULL, #占地面积
SHOPS_AREA                                        VARCHAR(20) NULL, #商铺面积
PUBLIC_AREA                                       VARCHAR(20) NULL, #公建面积
GREEN_AREA                                        VARCHAR(20) NULL, #绿化面积
TOT_BUILDS                                        VARCHAR(20) NULL, #总楼宇数
TOT_HOUS                                          VARCHAR(20) NULL, #总住宅数
TOT_SHOPS                                         VARCHAR(20) NULL, #总商铺数
TOT_ONG_PARKS                                     VARCHAR(20) NULL, #地面车位数
TOT_UNG_PARKS                                     VARCHAR(20) NULL, #室内车位数
OFFICE_ADDR                                       VARCHAR(256) NULL, #小区管理处地址
OFFICE_TEL                                        VARCHAR(40) NULL, #小区报修电话
RELATED_SECT_NO                                   VARCHAR(40) NULL, #关联小区编号
CONSTRAINT MSA_BASE_SECT_PK PRIMARY KEY(SECT_ID)   );


#业主车辆信息表
DROP TABLE IF EXISTS MSA_BASE_CUST_CAR ;
CREATE TABLE MSA_BASE_CUST_CAR(
CAR_ID                                            BIGINT default 0 NOT NULL, #车辆ID
CAR_STATUS                                        CHAR(1) NOT NULL, #状态
CAR_NO                                            VARCHAR(20) NOT NULL, #车牌号
CAR_COLOUR                                        CHAR(2) NULL, #颜色
CAR_TYPE                                          CHAR(2) NULL, #类型
CAR_OWNER_TYPE                                    CHAR(2) NULL, #车辆归属
REMARK                                            VARCHAR(512) NULL, #备注
CAR_BRAND_ID                                      BIGINT default 0 NULL, #车辆厂牌ID
CAR_TYPE_ID                                       BIGINT default 0 NULL, #车辆型号ID
PARK_TYPE                                         CHAR(2) NOT NULL, #停放
CARPORT_TYPE                                      CHAR(2) NULL, #停放车位类型
IS_PREPAID                                        CHAR(1) default '0' NULL, #是否为储值用户
CUST_ID                                           BIGINT default 0 NOT NULL, #客户ID
CUST_NAME                                         VARCHAR(160) NOT NULL, #客户名称
CARD_NO                                           VARCHAR(80) NULL, #卡号
CONSTRAINT MSA_BASE_CUST_CAR_PK PRIMARY KEY(CAR_ID)   );



#企业项目关系表
DROP TABLE IF EXISTS MSA_ENTERPRISE_SECT ;
CREATE TABLE MSA_ENTERPRISE_SECT(
ENTERPRISE_ID                                     VARCHAR(38) NOT NULL, #企业客户ID
SECT_ID                                           BIGINT default 0 NOT NULL, #物业项目ID
CONSTRAINT MSA_ENTERPRISE_SECT_PK PRIMARY KEY(ENTERPRISE_ID,SECT_ID)   );


#住宅信息表
DROP TABLE IF EXISTS MSA_BASE_HOUSE ;
CREATE TABLE MSA_BASE_HOUSE(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #物业单元ID
HOUSE_MODEL                                       CHAR(2) NULL, #户型
HOUSE_WARD                                        CHAR(2) NULL, #朝向
HOUSE_AREA                                        VARCHAR(20) NULL, #套内建筑面积
HOUSE_PHONE                                       VARCHAR(40) NULL, #固定电话
CONSTRAINT MSA_BASE_HOUSE_PK PRIMARY KEY(MNG_CELL_ID)   );

#车位/库信息表
DROP TABLE IF EXISTS MSA_BASE_CARPORT ;
CREATE TABLE MSA_BASE_CARPORT(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #物业单元ID
CARPORT_TYPE                                      CHAR(2) NULL, #车位类型
CONSTRAINT MSA_BASE_CARPORT_PK PRIMARY KEY(MNG_CELL_ID)   );

#广告位信息表
DROP TABLE IF EXISTS MSA_BASE_AD_LOCATE ;
CREATE TABLE MSA_BASE_AD_LOCATE(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #物业单元ID
AD_LOCATE_TYPE                                    CHAR(2) NULL, #广告位类型
CONSTRAINT MSA_BASE_AD_LOCATE_PK PRIMARY KEY(MNG_CELL_ID)   );

#物业单元信息表
DROP TABLE IF EXISTS MSA_BASE_CELL ;
CREATE TABLE MSA_BASE_CELL(
MNG_CELL_ID                                       BIGINT default 0 NOT NULL, #物业单元ID
STATUS                                            CHAR(1) NOT NULL, #状态
CELL_NO                                           VARCHAR(80) NOT NULL, #编号
CELL_NAME                                         VARCHAR(40) NULL, #名称
CELL_ADDR                                         VARCHAR(256) NULL, #地址
CNST_AREA                                         DECIMAL(16,2) default 0 NOT NULL, #建筑面积
CELL_FLOOR                                        VARCHAR(6) default '0' NOT NULL, #楼层
MNG_CELL_TYPE                                     CHAR(2) NOT NULL, #物业类型
MNG_CELL_KIND                                     CHAR(1) NOT NULL, #物业性质
REMARK                                            VARCHAR(256) NULL, #备注
LIFT_FLAG                                         CHAR(1) NOT NULL, #电梯标志
PROPERTY_KIND                                     CHAR(1) NOT NULL, #产权性质
BUILD_TYPE                                        CHAR(1) NOT NULL, #建筑类型
BUILD_USAGE                                       CHAR(2) NOT NULL, #建筑用途
RELATED_HOU_NO                                    VARCHAR(40) NULL, #关联房屋编号
SECT_ID                                           BIGINT default 0 NOT NULL, #物业项目ID
CONSTRAINT MSA_BASE_CELL_PK PRIMARY KEY(MNG_CELL_ID)   );

