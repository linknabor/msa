#Ǩ���б�
DROP TABLE IF EXISTS MSA_MIGRATION_LIST ;
CREATE TABLE MSA_MIGRATION_LIST(
ORI_TABLE_NAME                                    VARCHAR(40) NOT NULL, #Դϵͳ����
CURR_TABLE_NAME                                   VARCHAR(40) NOT NULL, #��ϵͳ����
NEED_MIGRATE                                      CHAR(1) NULL, #�Ƿ���ҪǨ��
FINISHED_MIGRATION                                CHAR(1) NULL, #�Ƿ����Ǩ��
FINISHED_TIME                                     CHAR(14) NULL, #Ǩ�����ʱ��
CONSTRAINT MSA_MIGRATION_LIST_PK PRIMARY KEY(ORI_TABLE_NAME)   );

