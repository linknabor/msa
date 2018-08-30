package com.eshequ.msa.sso.model;

import com.eshequ.msa.common.BaseModel;
import java.math.BigDecimal;

public class SsoMenu extends BaseModel {
    private Long menuId;

    private String menuName;

    private String menuCode;

    private String menuLevel;

    private Long parentId;

    private BigDecimal menuPos;

    private String entranceUrl;

    private String menuDesc;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public BigDecimal getMenuPos() {
        return menuPos;
    }

    public void setMenuPos(BigDecimal menuPos) {
        this.menuPos = menuPos;
    }

    public String getEntranceUrl() {
        return entranceUrl;
    }

    public void setEntranceUrl(String entranceUrl) {
        this.entranceUrl = entranceUrl;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }
}