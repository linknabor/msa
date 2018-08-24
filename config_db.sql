CREATE database config DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

#ϵͳ������Ϣ��
DROP TABLE IF EXISTS CODE_INFO ;
CREATE TABLE CODE_INFO(
CI_SP_CODE                                        VARCHAR(40) NOT NULL, #����ֵ
CI_SP_CLASS                                       VARCHAR(40) NOT NULL, #��������
CI_SP_CLASSNAME                                   VARCHAR(80) NOT NULL, #�������
CI_SP_NAME                                        VARCHAR(256) NOT NULL, #��������
CI_SP_REMARK                                      VARCHAR(512) NULL, #��ע
CONSTRAINT CODE_INFO_PK PRIMARY KEY(CI_SP_CODE,CI_SP_CLASS)   );

#��ϵͳ������ֵ����:10
#��������ֵ�Ĵ������:2 -------i==1
delete from code_info where ci_sp_class='261';
INSERT INTO CODE_INFO  VALUES ('0', '261', '�Ƿ��־', '��', 'IsFlag');
INSERT INTO CODE_INFO  VALUES ('1', '261', '�Ƿ��־', '��', 'IsFlag');
#��������ֵ�Ĵ������:5 -------i==2
delete from code_info where ci_sp_class='265';
INSERT INTO CODE_INFO  VALUES ('0', '265', '�û�״̬', 'δ��֤', 'UserStatus');
INSERT INTO CODE_INFO  VALUES ('1', '265', '�û�״̬', '����', 'UserStatus');
INSERT INTO CODE_INFO  VALUES ('2', '265', '�û�״̬', '��ͣʹ��', 'UserStatus');
INSERT INTO CODE_INFO  VALUES ('3', '265', '�û�״̬', '����ʹ��', 'UserStatus');
INSERT INTO CODE_INFO  VALUES ('4', '265', '�û�״̬', 'ע��', 'UserStatus');
#��������ֵ�Ĵ������:17 -------i==3
delete from code_info where ci_sp_class='279';
INSERT INTO CODE_INFO  VALUES ('00', '279', '������־����', '��¼', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('99', '279', '������־����', '�ǳ�', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('01', '279', '������־����', '����', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('02', '279', '������־����', '�޸�', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('03', '279', '������־����', 'ɾ��', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('04', '279', '������־����', '�鿴', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('05', '279', '������־����', '�½���ϵ', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('06', '279', '������־����', '�Ͽ���ϵ', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('07', '279', '������־����', '������ϵ', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('08', '279', '������־����', '���', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('09', '279', '������־����', '����', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('10', '279', '������־����', '����˻�', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('11', '279', '������־����', '�����˻�', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('12', '279', '������־����', '�������', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('13', '279', '������־����', '���ݵ���', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('14', '279', '������־����', 'ҵ�񴴽�', 'OperatorType');
INSERT INTO CODE_INFO  VALUES ('15', '279', '������־����', '������Ϣ����', 'OperatorType');
#��������ֵ�Ĵ������:2 -------i==4
delete from code_info where ci_sp_class='280';
INSERT INTO CODE_INFO  VALUES ('01', '280', '�������', 'ϵͳ����', 'ParaType');
INSERT INTO CODE_INFO  VALUES ('02', '280', '�������', 'ҵ�����', 'ParaType');
#��������ֵ�Ĵ������:3 -------i==5
delete from code_info where ci_sp_class='282';
INSERT INTO CODE_INFO  VALUES ('01', '282', '�ͻ�����', '����', 'UserCustKind');
INSERT INTO CODE_INFO  VALUES ('02', '282', '�ͻ�����', '���', 'UserCustKind');
INSERT INTO CODE_INFO  VALUES ('03', '282', '�ͻ�����', '��ס��', 'UserCustKind');
#��������ֵ�Ĵ������:2 -------i==6
delete from code_info where ci_sp_class='283';
INSERT INTO CODE_INFO  VALUES ('m', '283', '�Ա�', '��', 'SexFlag');
INSERT INTO CODE_INFO  VALUES ('f', '283', '�Ա�', 'Ů', 'SexFlag');
#��������ֵ�Ĵ������:3 -------i==7
delete from code_info where ci_sp_class='284';
INSERT INTO CODE_INFO  VALUES ('1', '284', 'APP����ϵͳ', 'IOS', 'DeviceType');
INSERT INTO CODE_INFO  VALUES ('2', '284', 'APP����ϵͳ', 'Android', 'DeviceType');
INSERT INTO CODE_INFO  VALUES ('3', '284', 'APP����ϵͳ', '����PC', 'DeviceType');
#��������ֵ�Ĵ������:2 -------i==8
delete from code_info where ci_sp_class='285';
INSERT INTO CODE_INFO  VALUES ('1', '285', '���伤��״̬', '�Ѽ���', 'EmailActive');
INSERT INTO CODE_INFO  VALUES ('0', '285', '���伤��״̬', 'δ����', 'EmailActive');
#��������ֵ�Ĵ������:3 -------i==9
delete from code_info where ci_sp_class='286';
INSERT INTO CODE_INFO  VALUES ('1', '286', '�ͻ���ϵͳ', 'APP', 'ClientSystem');
INSERT INTO CODE_INFO  VALUES ('2', '286', '�ͻ���ϵͳ', '΢��', 'ClientSystem');
INSERT INTO CODE_INFO  VALUES ('3', '286', '�ͻ���ϵͳ', 'webϵͳ', 'ClientSystem');
#��������ֵ�Ĵ������:4 -------i==10
delete from code_info where ci_sp_class='287';
INSERT INTO CODE_INFO  VALUES ('00', '287', '�û���Դ', '΢�Ź��ں�', 'RegisterFrom');
INSERT INTO CODE_INFO  VALUES ('01', '287', '�û���Դ', '��վ', 'RegisterFrom');
INSERT INTO CODE_INFO  VALUES ('02', '287', '�û���Դ', '�ֻ��ͻ���', 'RegisterFrom');
INSERT INTO CODE_INFO  VALUES ('03', '287', '�û���Դ', '΢��ˢ��', 'RegisterFrom');
