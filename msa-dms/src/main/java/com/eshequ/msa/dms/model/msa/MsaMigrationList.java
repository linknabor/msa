package com.eshequ.msa.dms.model.msa;

import com.eshequ.msa.common.BaseModel;

public class MsaMigrationList extends BaseModel {
    private String tableName;

    private String needMigrate;

    private String finishedMigration;

    private String finishedTime;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getNeedMigrate() {
        return needMigrate;
    }

    public void setNeedMigrate(String needMigrate) {
        this.needMigrate = needMigrate;
    }

    public String getFinishedMigration() {
        return finishedMigration;
    }

    public void setFinishedMigration(String finishedMigration) {
        this.finishedMigration = finishedMigration;
    }

    public String getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(String finishedTime) {
        this.finishedTime = finishedTime;
    }
}