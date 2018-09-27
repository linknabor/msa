#迁移列表
DROP TABLE IF EXISTS MSA_MIGRATION_LIST ;
CREATE TABLE MSA_MIGRATION_LIST(
ORI_TABLE_NAME                                    VARCHAR(40) NOT NULL, #源系统表名
CURR_TABLE_NAME                                   VARCHAR(40) NOT NULL, #现系统表名
NEED_MIGRATE                                      CHAR(1) NULL, #是否需要迁移
FINISHED_MIGRATION                                CHAR(1) NULL, #是否完成迁移
FINISHED_TIME                                     CHAR(14) NULL, #迁移完成时间
CONSTRAINT MSA_MIGRATION_LIST_PK PRIMARY KEY(ORI_TABLE_NAME)   );

