CREATE database config DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

#系统代码信息表
DROP TABLE IF EXISTS CODE_INFO ;
CREATE TABLE CODE_INFO(
CI_SP_CODE                                        VARCHAR(40) NOT NULL, #代码值
CI_SP_CLASS                                       VARCHAR(40) NOT NULL, #所属类别号
CI_SP_CLASSNAME                                   VARCHAR(80) NOT NULL, #类别名称
CI_SP_NAME                                        VARCHAR(256) NOT NULL, #代码名称
CI_SP_REMARK                                      VARCHAR(512) NULL, #备注
CONSTRAINT CODE_INFO_PK PRIMARY KEY(CI_SP_CODE,CI_SP_CLASS)   );

#　系统的引用值个数:10
#　本引用值的代码个数:2 -------i==1
delete from code_info where ci_sp_class='261';
INSERT INTO CODE_INFO  VALUES ('0', '261', '是否标志', '否', 'IsFlag');
INSERT INTO CODE_INFO  VALUES ('1', '261', '是否标志', '是', 'IsFlag');
#　本引用值的代码个数:5 -------i==2
delete from code_info where ci_sp_class='265';
INSERT INTO CODE_INFO  VALUES ('0', '265', '用户状态', '未认证', 'UserStatus');
INSERT INTO CODE_INFO  VALUES ('1', '265', '用户状态', '正常', 'UserStatus');
INSERT INTO CODE_INFO  VALUES ('2', '265', '用户状态', '暂停使用', 'UserStatus');
INSERT INTO CODE_INFO  VALUES ('3', '265', '用户状态', '正在使用', 'UserStatus');
INSERT INTO CODE_INFO  VALUES ('4', '265', '用户状态', '注销', 'UserStatus');
#　本引用值的代码个数:17 -------i==3
delete from code_info where ci_sp_class='279';
INSERT INTO CODE_INFO  VALUES ('00', '279', '操作日志类型', '登录', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('99', '279', '操作日志类型', '登出', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('01', '279', '操作日志类型', '新增', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('02', '279', '操作日志类型', '修改', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('03', '279', '操作日志类型', '删除', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('04', '279', '操作日志类型', '查看', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('05', '279', '操作日志类型', '新建关系', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('06', '279', '操作日志类型', '断开关系', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('07', '279', '操作日志类型', '更换关系', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('08', '279', '操作日志类型', '审核', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('09', '279', '操作日志类型', '复核', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('10', '279', '操作日志类型', '审核退回', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('11', '279', '操作日志类型', '复核退回', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('12', '279', '操作日志类型', '撤销审核', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('13', '279', '操作日志类型', '数据导入', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('14', '279', '操作日志类型', '业务创建', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('15', '279', '操作日志类型', '基础信息纠错', 'OperatorType');
#　本引用值的代码个数:2 -------i==4
delete from code_info where ci_sp_class='280';
INSERT INTO CODE_INFO  VALUES ('01', '280', '参数类别', '系统参数', 'ParaType');
INSERT INTO CODE_INFO  VALUES ('02', '280', '参数类别', '业务参数', 'ParaType');
#　本引用值的代码个数:3 -------i==5
delete from code_info where ci_sp_class='282';
INSERT INTO CODE_INFO  VALUES ('01', '282', '客户性质', '户主', 'UserCustKind');
INSERT INTO CODE_INFO  VALUES ('02', '282', '客户性质', '租客', 'UserCustKind');
INSERT INTO CODE_INFO  VALUES ('03', '282', '客户性质', '居住人', 'UserCustKind');
#　本引用值的代码个数:2 -------i==6
delete from code_info where ci_sp_class='283';
INSERT INTO CODE_INFO  VALUES ('m', '283', '性别', '男', 'SexFlag');
INSERT INTO CODE_INFO  VALUES ('f', '283', '性别', '女', 'SexFlag');
#　本引用值的代码个数:3 -------i==7
delete from code_info where ci_sp_class='284';
INSERT INTO CODE_INFO  VALUES ('1', '284', 'APP操作系统', 'IOS', 'DeviceType');
INSERT INTO CODE_INFO  VALUES ('2', '284', 'APP操作系统', 'Android', 'DeviceType');
INSERT INTO CODE_INFO  VALUES ('3', '284', 'APP操作系统', '个人PC', 'DeviceType');
#　本引用值的代码个数:2 -------i==8
delete from code_info where ci_sp_class='285';
INSERT INTO CODE_INFO  VALUES ('1', '285', '邮箱激活状态', '已激活', 'EmailActive');
INSERT INTO CODE_INFO  VALUES ('0', '285', '邮箱激活状态', '未激活', 'EmailActive');
#　本引用值的代码个数:3 -------i==9
delete from code_info where ci_sp_class='286';
INSERT INTO CODE_INFO  VALUES ('1', '286', '客户端系统', 'APP', 'ClientSystem');
INSERT INTO CODE_INFO  VALUES ('2', '286', '客户端系统', '微信', 'ClientSystem');
INSERT INTO CODE_INFO  VALUES ('3', '286', '客户端系统', 'web系统', 'ClientSystem');
#　本引用值的代码个数:4 -------i==10
delete from code_info where ci_sp_class='287';
INSERT INTO CODE_INFO  VALUES ('00', '287', '用户来源', '微信公众号', 'RegisterFrom');
INSERT INTO CODE_INFO  VALUES ('01', '287', '用户来源', '网站', 'RegisterFrom');
INSERT INTO CODE_INFO  VALUES ('02', '287', '用户来源', '手机客户端', 'RegisterFrom');
INSERT INTO CODE_INFO  VALUES ('03', '287', '用户来源', '微信刷卡', 'RegisterFrom');
