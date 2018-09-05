CREATE database msaconfig DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use msaconfig;


DROP TABLE IF EXISTS CODE_INFO ;
CREATE TABLE CODE_INFO(
CI_SP_CODE                                        VARCHAR(40) NOT NULL, #代码值
CI_SP_CLASS                                       VARCHAR(40) NOT NULL, #所属类别号
CI_SP_CLASSNAME                                   VARCHAR(80) NOT NULL, #类别名称
CI_SP_NAME                                        VARCHAR(256) NOT NULL, #代码名称
CI_SP_REMARK                                      VARCHAR(512) NULL, #备注
CONSTRAINT CODE_INFO_PK PRIMARY KEY(CI_SP_CODE,CI_SP_CLASS)   );

#　系统的引用值个数:33
#　本引用值的代码个数:3 -------i==1
delete from code_info where ci_sp_class='50';
INSERT INTO CODE_INFO  VALUES ('0', '50', '单位状态', '正常', 'OrgStatus');
INSERT INTO CODE_INFO  VALUES ('1', '50', '单位状态', '禁用', 'OrgStatus');
INSERT INTO CODE_INFO  VALUES ('2', '50', '单位状态', '注销', 'OrgStatus');
#　本引用值的代码个数:2 -------i==2
delete from code_info where ci_sp_class='52';
INSERT INTO CODE_INFO  VALUES ('0', '52', '发票开具类型', '纸质发票', 'InvoiceType');
INSERT INTO CODE_INFO  VALUES ('1', '52', '发票开具类型', '电子发票', 'InvoiceType');
#　本引用值的代码个数:6 -------i==3
delete from code_info where ci_sp_class='53';
INSERT INTO CODE_INFO  VALUES ('01', '53', '发票开具状态', '申请中', 'InvoiceStatus');
INSERT INTO CODE_INFO  VALUES ('02', '53', '发票开具状态', '开票中', 'InvoiceStatus');
INSERT INTO CODE_INFO  VALUES ('03', '53', '发票开具状态', '成功', 'InvoiceStatus');
INSERT INTO CODE_INFO  VALUES ('97', '53', '发票开具状态', '作废中', 'InvoiceStatus');
INSERT INTO CODE_INFO  VALUES ('98', '53', '发票开具状态', '失败', 'InvoiceStatus');
INSERT INTO CODE_INFO  VALUES ('99', '53', '发票开具状态', '作废', 'InvoiceStatus');
#　本引用值的代码个数:2 -------i==4
delete from code_info where ci_sp_class='54';
INSERT INTO CODE_INFO  VALUES ('0', '54', '发票申请类型', '正数发票开具', 'InvoiceApplyType');
INSERT INTO CODE_INFO  VALUES ('1', '54', '发票申请类型', '负数发票开具', 'InvoiceApplyType');
#　本引用值的代码个数:7 -------i==5
delete from code_info where ci_sp_class='18';
INSERT INTO CODE_INFO  VALUES ('1', '18', '物业项目性质', '商品房', 'ProCreateType');
INSERT INTO CODE_INFO  VALUES ('2', '18', '物业项目性质', '动迁房', 'ProCreateType');
INSERT INTO CODE_INFO  VALUES ('3', '18', '物业项目性质', '经适房', 'ProCreateType');
INSERT INTO CODE_INFO  VALUES ('4', '18', '物业项目性质', '售后房', 'ProCreateType');
INSERT INTO CODE_INFO  VALUES ('5', '18', '物业项目性质', '直管公房', 'ProCreateType');
INSERT INTO CODE_INFO  VALUES ('6', '18', '物业项目性质', '混合', 'ProCreateType');
INSERT INTO CODE_INFO  VALUES ('7', '18', '物业项目性质', '系统公房', 'ProCreateType');
#　本引用值的代码个数:3 -------i==6
delete from code_info where ci_sp_class='19';
INSERT INTO CODE_INFO  VALUES ('01', '19', '物业项目类型', '住宅', 'SectType');
INSERT INTO CODE_INFO  VALUES ('02', '19', '物业项目类型', '商用', 'SectType');
INSERT INTO CODE_INFO  VALUES ('03', '19', '物业项目类型', '商住两用', 'SectType');
#　本引用值的代码个数:2 -------i==7
delete from code_info where ci_sp_class='20';
INSERT INTO CODE_INFO  VALUES ('0', '20', '状态', '正常', 'InfoStatus');
INSERT INTO CODE_INFO  VALUES ('1', '20', '状态', '注销', 'InfoStatus');
#　本引用值的代码个数:6 -------i==8
delete from code_info where ci_sp_class='21';
INSERT INTO CODE_INFO  VALUES ('1', '21', '建筑类型', '高层', 'BuildType');
INSERT INTO CODE_INFO  VALUES ('2', '21', '建筑类型', '多层', 'BuildType');
INSERT INTO CODE_INFO  VALUES ('3', '21', '建筑类型', '小高层', 'BuildType');
INSERT INTO CODE_INFO  VALUES ('4', '21', '建筑类型', '联体别墅', 'BuildType');
INSERT INTO CODE_INFO  VALUES ('5', '21', '建筑类型', '单体别墅', 'BuildType');
INSERT INTO CODE_INFO  VALUES ('9', '21', '建筑类型', '其他', 'BuildType');
#　本引用值的代码个数:2 -------i==9
delete from code_info where ci_sp_class='22';
INSERT INTO CODE_INFO  VALUES ('0', '22', '是否标志', '否', 'IsFlag');
INSERT INTO CODE_INFO  VALUES ('1', '22', '是否标志', '是', 'IsFlag');
#　本引用值的代码个数:7 -------i==10
delete from code_info where ci_sp_class='23';
INSERT INTO CODE_INFO  VALUES ('01', '23', '户型', '一室', 'HouseModel');
INSERT INTO CODE_INFO  VALUES ('02', '23', '户型', '二室', 'HouseModel');
INSERT INTO CODE_INFO  VALUES ('03', '23', '户型', '三室', 'HouseModel');
INSERT INTO CODE_INFO  VALUES ('04', '23', '户型', '四室', 'HouseModel');
INSERT INTO CODE_INFO  VALUES ('05', '23', '户型', '五室', 'HouseModel');
INSERT INTO CODE_INFO  VALUES ('06', '23', '户型', '五室以上', 'HouseModel');
INSERT INTO CODE_INFO  VALUES ('99', '23', '户型', '其他', 'HouseModel');
#　本引用值的代码个数:2 -------i==11
delete from code_info where ci_sp_class='24';
INSERT INTO CODE_INFO  VALUES ('01', '24', '车位类型', '室内', 'CarportType');
INSERT INTO CODE_INFO  VALUES ('02', '24', '车位类型', '地面', 'CarportType');
#　本引用值的代码个数:8 -------i==12
delete from code_info where ci_sp_class='25';
INSERT INTO CODE_INFO  VALUES ('01', '25', '朝向', '南', 'Ward');
INSERT INTO CODE_INFO  VALUES ('02', '25', '朝向', '北', 'Ward');
INSERT INTO CODE_INFO  VALUES ('03', '25', '朝向', '东', 'Ward');
INSERT INTO CODE_INFO  VALUES ('04', '25', '朝向', '西', 'Ward');
INSERT INTO CODE_INFO  VALUES ('05', '25', '朝向', '东南', 'Ward');
INSERT INTO CODE_INFO  VALUES ('06', '25', '朝向', '西南', 'Ward');
INSERT INTO CODE_INFO  VALUES ('07', '25', '朝向', '东北', 'Ward');
INSERT INTO CODE_INFO  VALUES ('08', '25', '朝向', '西北', 'Ward');
#　本引用值的代码个数:3 -------i==13
delete from code_info where ci_sp_class='26';
INSERT INTO CODE_INFO  VALUES ('01', '26', '商铺类型', '底商', 'ShopsType');
INSERT INTO CODE_INFO  VALUES ('02', '26', '商铺类型', '写字间', 'ShopsType');
INSERT INTO CODE_INFO  VALUES ('03', '26', '商铺类型', '商场', 'ShopsType');
#　本引用值的代码个数:6 -------i==14
delete from code_info where ci_sp_class='27';
INSERT INTO CODE_INFO  VALUES ('01', '27', '广告位类型', '广告牌', 'AdLocateType');
INSERT INTO CODE_INFO  VALUES ('02', '27', '广告位类型', '电梯广告', 'AdLocateType');
INSERT INTO CODE_INFO  VALUES ('03', '27', '广告位类型', '宣传栏', 'AdLocateType');
INSERT INTO CODE_INFO  VALUES ('04', '27', '广告位类型', '路灯柱', 'AdLocateType');
INSERT INTO CODE_INFO  VALUES ('05', '27', '广告位类型', '灯箱', 'AdLocateType');
INSERT INTO CODE_INFO  VALUES ('99', '27', '广告位类型', '其他', 'AdLocateType');
#　本引用值的代码个数:4 -------i==15
delete from code_info where ci_sp_class='28';
INSERT INTO CODE_INFO  VALUES ('1', '28', '物业单元性质', '普通物业', 'MngCellKind');
INSERT INTO CODE_INFO  VALUES ('2', '28', '物业单元性质', '公建配套', 'MngCellKind');
INSERT INTO CODE_INFO  VALUES ('3', '28', '物业单元性质', '物业用房', 'MngCellKind');
INSERT INTO CODE_INFO  VALUES ('4', '28', '物业单元性质', '开发商产权', 'MngCellKind');
#　本引用值的代码个数:19 -------i==16
delete from code_info where ci_sp_class='29';
INSERT INTO CODE_INFO  VALUES ('1', '29', '物业产权性质', '商品房', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('2', '29', '物业产权性质', '售后公房', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('3', '29', '物业产权性质', '有限产权', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('4', '29', '物业产权性质', '系统公房', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('5', '29', '物业产权性质', '直管公房(直管)', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('6', '29', '物业产权性质', '经适房', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('7', '29', '物业产权性质', '廉租房', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('8', '29', '物业产权性质', '动迁房', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('A', '29', '物业产权性质', '直管公房(自管)', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('B', '29', '物业产权性质', '直管公房(代管)', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('C', '29', '物业产权性质', '租赁房', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('D', '29', '物业产权性质', '空置房（租赁）', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('E', '29', '物业产权性质', '空置房（产权）', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('F', '29', '物业产权性质', '非居住用房（非居租赁）', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('G', '29', '物业产权性质', '非居住用房（非居产权）', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('H', '29', '物业产权性质', '非居住用房（居改非）', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('I', '29', '物业产权性质', '商铺（租赁）', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('J', '29', '物业产权性质', '商铺（产权）', 'HousePropertyKind');
INSERT INTO CODE_INFO  VALUES ('K', '29', '物业产权性质', '商铺（空置）', 'HousePropertyKind');
#　本引用值的代码个数:2 -------i==17
delete from code_info where ci_sp_class='30';
INSERT INTO CODE_INFO  VALUES ('0', '30', '电梯标志', '无', 'LiftFlag');
INSERT INTO CODE_INFO  VALUES ('1', '30', '电梯标志', '有', 'LiftFlag');
#　本引用值的代码个数:5 -------i==18
delete from code_info where ci_sp_class='31';
INSERT INTO CODE_INFO  VALUES ('01', '31', '建筑用途', '住宅', 'BuildUsage');
INSERT INTO CODE_INFO  VALUES ('02', '31', '建筑用途', '商业', 'BuildUsage');
INSERT INTO CODE_INFO  VALUES ('03', '31', '建筑用途', '车库', 'BuildUsage');
INSERT INTO CODE_INFO  VALUES ('04', '31', '建筑用途', '地下室', 'BuildUsage');
INSERT INTO CODE_INFO  VALUES ('99', '31', '建筑用途', '其他', 'BuildUsage');
#　本引用值的代码个数:5 -------i==19
delete from code_info where ci_sp_class='32';
INSERT INTO CODE_INFO  VALUES ('01', '32', '物业单元类型', '住宅', 'MngCellType');
INSERT INTO CODE_INFO  VALUES ('02', '32', '物业单元类型', '商铺', 'MngCellType');
INSERT INTO CODE_INFO  VALUES ('03', '32', '物业单元类型', '车位', 'MngCellType');
INSERT INTO CODE_INFO  VALUES ('04', '32', '物业单元类型', '广告位', 'MngCellType');
INSERT INTO CODE_INFO  VALUES ('05', '32', '物业单元类型', '地下室', 'MngCellType');
#　本引用值的代码个数:4 -------i==20
delete from code_info where ci_sp_class='33';
INSERT INTO CODE_INFO  VALUES ('01', '33', '停车类型', '固定车位', 'ParkType');
INSERT INTO CODE_INFO  VALUES ('02', '33', '停车类型', '公共车位', 'ParkType');
INSERT INTO CODE_INFO  VALUES ('03', '33', '停车类型', '私家车位', 'ParkType');
INSERT INTO CODE_INFO  VALUES ('04', '33', '停车类型', '租赁车位', 'ParkType');
#　本引用值的代码个数:7 -------i==21
delete from code_info where ci_sp_class='34';
INSERT INTO CODE_INFO  VALUES ('01', '34', '车辆类型', '轿车', 'CarType');
INSERT INTO CODE_INFO  VALUES ('02', '34', '车辆类型', '越野车', 'CarType');
INSERT INTO CODE_INFO  VALUES ('03', '34', '车辆类型', '跑车', 'CarType');
INSERT INTO CODE_INFO  VALUES ('04', '34', '车辆类型', '旅行车', 'CarType');
INSERT INTO CODE_INFO  VALUES ('05', '34', '车辆类型', '客车', 'CarType');
INSERT INTO CODE_INFO  VALUES ('06', '34', '车辆类型', '货车', 'CarType');
INSERT INTO CODE_INFO  VALUES ('99', '34', '车辆类型', '其他', 'CarType');
#　本引用值的代码个数:14 -------i==22
delete from code_info where ci_sp_class='35';
INSERT INTO CODE_INFO  VALUES ('01', '35', '颜色', '黑', 'Colour');
INSERT INTO CODE_INFO  VALUES ('02', '35', '颜色', '白', 'Colour');
INSERT INTO CODE_INFO  VALUES ('03', '35', '颜色', '银', 'Colour');
INSERT INTO CODE_INFO  VALUES ('04', '35', '颜色', '金', 'Colour');
INSERT INTO CODE_INFO  VALUES ('05', '35', '颜色', '灰', 'Colour');
INSERT INTO CODE_INFO  VALUES ('06', '35', '颜色', '红', 'Colour');
INSERT INTO CODE_INFO  VALUES ('07', '35', '颜色', '褐', 'Colour');
INSERT INTO CODE_INFO  VALUES ('08', '35', '颜色', '橙', 'Colour');
INSERT INTO CODE_INFO  VALUES ('09', '35', '颜色', '黄', 'Colour');
INSERT INTO CODE_INFO  VALUES ('10', '35', '颜色', '绿', 'Colour');
INSERT INTO CODE_INFO  VALUES ('11', '35', '颜色', '青', 'Colour');
INSERT INTO CODE_INFO  VALUES ('12', '35', '颜色', '蓝', 'Colour');
INSERT INTO CODE_INFO  VALUES ('13', '35', '颜色', '紫', 'Colour');
INSERT INTO CODE_INFO  VALUES ('99', '35', '颜色', '其他', 'Colour');
#　本引用值的代码个数:3 -------i==23
delete from code_info where ci_sp_class='36';
INSERT INTO CODE_INFO  VALUES ('01', '36', '车辆归属', '私车', 'CarOwnerType');
INSERT INTO CODE_INFO  VALUES ('02', '36', '车辆归属', '公车', 'CarOwnerType');
INSERT INTO CODE_INFO  VALUES ('99', '36', '车辆归属', '其他', 'CarOwnerType');
#　本引用值的代码个数:21 -------i==24
delete from code_info where ci_sp_class='38';
INSERT INTO CODE_INFO  VALUES ('01', '38', '证件类型', '身份证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('02', '38', '证件类型', '工作证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('03', '38', '证件类型', '护照', 'CertType');
INSERT INTO CODE_INFO  VALUES ('04', '38', '证件类型', '户口簿', 'CertType');
INSERT INTO CODE_INFO  VALUES ('05', '38', '证件类型', '学生证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('06', '38', '证件类型', '营业执照', 'CertType');
INSERT INTO CODE_INFO  VALUES ('07', '38', '证件类型', '商业登记证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('08', '38', '证件类型', '回乡证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('09', '38', '证件类型', '绿卡', 'CertType');
INSERT INTO CODE_INFO  VALUES ('10', '38', '证件类型', '军官证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('11', '38', '证件类型', '旅行证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('12', '38', '证件类型', '大陆往来证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('13', '38', '证件类型', '法人代码证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('14', '38', '证件类型', '企业代码证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('15', '38', '证件类型', '登记证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('16', '38', '证件类型', '社团法人证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('17', '38', '证件类型', '兵役证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('18', '38', '证件类型', '组织机构代码证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('19', '38', '证件类型', '车辆行驶证', 'CertType');
INSERT INTO CODE_INFO  VALUES ('20', '38', '证件类型', '车辆发动机号', 'CertType');
INSERT INTO CODE_INFO  VALUES ('99', '38', '证件类型', '其他', 'CertType');
#　本引用值的代码个数:4 -------i==25
delete from code_info where ci_sp_class='39';
INSERT INTO CODE_INFO  VALUES ('01', '39', '客户类型', '个人', 'CustType');
INSERT INTO CODE_INFO  VALUES ('02', '39', '客户类型', '公司', 'CustType');
INSERT INTO CODE_INFO  VALUES ('03', '39', '客户类型', '业委会', 'CustType');
INSERT INTO CODE_INFO  VALUES ('04', '39', '客户类型', '开发商', 'CustType');
#　本引用值的代码个数:3 -------i==26
delete from code_info where ci_sp_class='40';
INSERT INTO CODE_INFO  VALUES ('01', '40', '客户性质', '业主', 'CustKind');
INSERT INTO CODE_INFO  VALUES ('02', '40', '客户性质', '租户', 'CustKind');
INSERT INTO CODE_INFO  VALUES ('03', '40', '客户性质', '居住人', 'CustKind');
#　本引用值的代码个数:11 -------i==27
delete from code_info where ci_sp_class='41';
INSERT INTO CODE_INFO  VALUES ('01', '41', '支付渠道', '现金', 'PayMethod');
INSERT INTO CODE_INFO  VALUES ('02', '41', '支付渠道', '转账', 'PayMethod');
INSERT INTO CODE_INFO  VALUES ('03', '41', '支付渠道', 'POS（脱机）', 'PayMethod');
INSERT INTO CODE_INFO  VALUES ('04', '41', '支付渠道', '支付宝', 'PayMethod');
INSERT INTO CODE_INFO  VALUES ('05', '41', '支付渠道', '财付通', 'PayMethod');
INSERT INTO CODE_INFO  VALUES ('06', '41', '支付渠道', '微信公众号', 'PayMethod');
INSERT INTO CODE_INFO  VALUES ('07', '41', '支付渠道', '微信App', 'PayMethod');
INSERT INTO CODE_INFO  VALUES ('08', '41', '支付渠道', '微信扫码', 'PayMethod');
INSERT INTO CODE_INFO  VALUES ('09', '41', '支付渠道', '支付宝扫码', 'PayMethod');
INSERT INTO CODE_INFO  VALUES ('10', '41', '支付渠道', 'POS（联机）', 'PayMethod');
INSERT INTO CODE_INFO  VALUES ('99', '41', '支付渠道', '上海物业App', 'PayMethod');
#　本引用值的代码个数:13 -------i==28
delete from code_info where ci_sp_class='42';
INSERT INTO CODE_INFO  VALUES ('0', '42', '支付平台', '微信', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('1', '42', '支付平台', '威富通', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('2', '42', '支付平台', '河马付', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('3', '42', '支付平台', '通联', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('4', '42', '支付平台', '拉卡拉', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('5', '42', '支付平台', '兴业银联刷卡', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('6', '42', '支付平台', '建行银联刷卡', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('7', '42', '支付平台', '嘉兴银行刷卡', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('8', '42', '支付平台', '拉卡拉刷卡', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('9', '42', '支付平台', '建行在线', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('A', '42', '支付平台', '慧兜圈', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('Y', '42', '支付平台', '财付通', 'PlatChannel');
INSERT INTO CODE_INFO  VALUES ('Z', '42', '支付平台', '现金', 'PlatChannel');
#　本引用值的代码个数:2 -------i==29
delete from code_info where ci_sp_class='43';
INSERT INTO CODE_INFO  VALUES ('1', '43', '商户类型', '主商户', 'MchType');
INSERT INTO CODE_INFO  VALUES ('2', '43', '商户类型', '子商户', 'MchType');
#　本引用值的代码个数:5 -------i==30
delete from code_info where ci_sp_class='44';
INSERT INTO CODE_INFO  VALUES ('01', '44', '支付交易状态', '正在支付中', 'TradeState');
INSERT INTO CODE_INFO  VALUES ('02', '44', '支付交易状态', '已支付', 'TradeState');
INSERT INTO CODE_INFO  VALUES ('03', '44', '支付交易状态', '未支付', 'TradeState');
INSERT INTO CODE_INFO  VALUES ('04', '44', '支付交易状态', '已清算', 'TradeState');
INSERT INTO CODE_INFO  VALUES ('05', '44', '支付交易状态', '已返点', 'TradeState');
#　本引用值的代码个数:7 -------i==31
delete from code_info where ci_sp_class='45';
INSERT INTO CODE_INFO  VALUES ('00', '45', '退款交易状态', '编辑', 'RefundState');
INSERT INTO CODE_INFO  VALUES ('01', '45', '退款交易状态', '交易完成', 'RefundState');
INSERT INTO CODE_INFO  VALUES ('02', '45', '退款交易状态', '交易撤销', 'RefundState');
INSERT INTO CODE_INFO  VALUES ('03', '45', '退款交易状态', '待审核', 'RefundState');
INSERT INTO CODE_INFO  VALUES ('04', '45', '退款交易状态', '待复核', 'RefundState');
INSERT INTO CODE_INFO  VALUES ('05', '45', '退款交易状态', '在途', 'RefundState');
INSERT INTO CODE_INFO  VALUES ('06', '45', '退款交易状态', '审核退回', 'RefundState');
#　本引用值的代码个数:3 -------i==32
delete from code_info where ci_sp_class='46';
INSERT INTO CODE_INFO  VALUES ('01', '46', '产品版本', '标准版', 'ProductVersion');
INSERT INTO CODE_INFO  VALUES ('02', '46', '产品版本', '专业版', 'ProductVersion');
INSERT INTO CODE_INFO  VALUES ('03', '46', '产品版本', '企业版', 'ProductVersion');
#　本引用值的代码个数:2 -------i==33
delete from code_info where ci_sp_class='49';
INSERT INTO CODE_INFO  VALUES ('1', '49', '银行卡类型', '借记卡', 'CardType');
INSERT INTO CODE_INFO  VALUES ('2', '49', '银行卡类型', '贷记卡', 'CardType');
#　本引用值的代码个数:3 -------i==38
delete from code_info where ci_sp_class='60';
INSERT INTO CODE_INFO  VALUES ('0', '60', '活跃度', '新', 'Activity');
INSERT INTO CODE_INFO  VALUES ('1', '60', '活跃度', '活跃', 'Activity');
INSERT INTO CODE_INFO  VALUES ('2', '60', '活跃度', '潜在流失', 'Activity');