package com.cqwo.base.core.enums.categories;


import com.cqwo.base.core.helper.TypeHelper;
import com.cqwo.base.core.model.SelectListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现分类
 */
public enum CateTypeEnums {

    Forum(0, "生态圈子"),
    Specie(1, "发现物种"),
    Event(2, "事件上报"),
    Ask(3, "问专家");

    private Integer typeId;

    private String name;


    CateTypeEnums(Integer typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 通过index获取枚举名称
     *
     * @param index
     * @return
     */
    public String getName(Integer index) {

        CateTypeEnums[] arr = CateTypeEnums.values();
        for (CateTypeEnums type : arr) {
            if (type.getTypeId().equals(index)) {
                return type.getName();
            }
        }

        return null;
    }

    /**
     * 通过index获取枚举
     *
     * @param index
     * @return
     */
    public static CateTypeEnums getBankAction(Integer index) {

        CateTypeEnums[] typeEnums = CateTypeEnums.values();
        for (CateTypeEnums type : typeEnums) {
            if (type.getTypeId().equals(index)) {
                return type;
            }
        }
        return null;
    }

    /**
     * 获取枚举的列表
     *
     * @return
     */
    public static List<SelectListItem> getSelectListItem() {
        return getSelectListItem(1);
    }


    /**
     * 获取枚举的列表
     * index 默认选择项目
     *
     * @return
     */
    public static List<SelectListItem> getSelectListItem(Integer index) {
        List<SelectListItem> selectListItemList = new ArrayList<SelectListItem>();

        CateTypeEnums[] typeEnums = CateTypeEnums.values();
        for (CateTypeEnums type : typeEnums) {

            SelectListItem item = new SelectListItem();

            item.setText(type.getName());
            item.setValue(TypeHelper.intToString(type.getTypeId()));

            if (type.getTypeId().equals(index)) {
                item.setSelected(true);
            }

            selectListItemList.add(item);
        }

        return selectListItemList;
    }
}
