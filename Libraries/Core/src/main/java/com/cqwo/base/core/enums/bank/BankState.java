package com.cqwo.base.core.enums.bank;

import com.cqwo.base.core.model.SelectListItem;
import com.cqwo.base.core.helper.TypeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cqnews
 */

public enum BankState {

    /// <summary>
    /// 已提交
    /// </summary>
    Submitted("submitted", "已提交,审核中", 10),
    /// <summary>
    /// 银行处理中
    /// </summary>
    Confirming("confirm", "审核完成,待确认", 20),
    /// <summary>
    /// 已完成
    /// </summary>
    Completed("completed", "已完成", 30),

    /// <summary>
    /// 失败
    /// </summary>
    Returned("returned", "失败", 160),
    /// <summary>
    /// 冻结
    /// </summary>
    Locked("locked", "冻结", 180),
    /// <summary>
    /// 取消
    /// </summary>
    Cancelled("cancelled", "取消", 200);

    private String code;
    private String name;
    private Integer index;

    BankState(String code, String name, Integer index) {
        this.code = code;
        this.name = name;
        this.index = index;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }


    /**
     * 通过index获取枚举名称
     *
     * @param index
     * @return
     */
    public String getName(Integer index) {

        BankState[] states = BankState.values();
        for (BankState bankState : states) {
            if (index.equals(bankState.getIndex())) {
                return bankState.getName();
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
    public static BankState getBankAction(Integer index) {

        BankState[] states = BankState.values();
        for (BankState bankState : states) {
            if (index.equals(bankState.getIndex())) {
                return bankState;
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

        BankState[] states = BankState.values();
        for (BankState bankState : states) {

            SelectListItem item = new SelectListItem();

            item.setText(bankState.getName());
            item.setValue(TypeHelper.intToString(bankState.getIndex()));

            if (bankState.getIndex().equals(index)) {
                item.setSelected(true);
            }

            selectListItemList.add(item);
        }

        return selectListItemList;
    }
}
