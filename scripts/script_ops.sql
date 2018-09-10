#��Ŀ����ģ���
DROP TABLE IF EXISTS MSA_TEMPLET_SECT_PARA ;
CREATE TABLE MSA_TEMPLET_SECT_PARA(
PARA_NAME                                         VARCHAR(80) NOT NULL, #��������
SECT_ID                                           BIGINT default 0 NOT NULL, #��ĿID
PARA_VALUE                                        VARCHAR(256) NULL, #����ֵ
PARA_TYPE                                         CHAR(2) NOT NULL, #��������
REMARK                                            VARCHAR(256) NULL, #��ע
CONSTRAINT MSA_TEMPLET_SECT_PARA_PK PRIMARY KEY(PARA_NAME)   );

#��ҵ����ģ���
DROP TABLE IF EXISTS MSA_TEMPLET_ENP_PARA ;
CREATE TABLE MSA_TEMPLET_ENP_PARA(
PARA_NAME                                         VARCHAR(40) NOT NULL, #��������
ENTERPRISE_ID                                     BIGINT default 0 NOT NULL, #��ҵID
PARA_VALUE                                        VARCHAR(256) NOT NULL, #����ֵ
PARA_TYPE                                         CHAR(2) NOT NULL, #��������
REMARK                                            VARCHAR(256) NULL, #��ע
CONSTRAINT MSA_TEMPLET_ENP_PARA_PK PRIMARY KEY(PARA_NAME)   );

#��ҵ�������ñ�
DROP TABLE IF EXISTS MSA_CFG_ENP_PARA ;
CREATE TABLE MSA_CFG_ENP_PARA(
PARA_ID                                           BIGINT default 0 NOT NULL, #����ID
PARA_NAME                                         VARCHAR(40) NOT NULL, #��������
PARA_VALUE                                        VARCHAR(256) NULL, #����ֵ
PARA_TYPE                                         CHAR(2) NOT NULL, #�������
PARA_STATUS                                       CHAR(1) NOT NULL, #����״̬
ENTERPRISE_ID                                     VARCHAR(38) NOT NULL, #��ҵ�ͻ�ID
REMARK                                            VARCHAR(256) NULL, #��ע
CONSTRAINT MSA_CFG_ENP_PARA_PK PRIMARY KEY(PARA_ID)   );

#��Ŀ�������ñ�
DROP TABLE IF EXISTS MSA_CFG_SECT_PARA ;
CREATE TABLE MSA_CFG_SECT_PARA(
PARA_ID                                           BIGINT default 0 NOT NULL, #����ID
PARA_NAME                                         VARCHAR(40) NOT NULL, #��������
PARA_VALUE                                        VARCHAR(256) NULL, #����ֵ
PARA_TYPE                                         CHAR(2) NOT NULL, #�������
PARA_STATUS                                       CHAR(1) NOT NULL, #����״̬
SECT_ID                                           BIGINT default 0 NOT NULL, #��ҵ��ĿID
REMARK                                            VARCHAR(256) NULL, #��ע
CONSTRAINT MSA_CFG_SECT_PARA_PK PRIMARY KEY(PARA_ID)   );


