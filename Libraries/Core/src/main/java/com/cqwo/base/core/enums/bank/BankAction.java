package com.cqwo.base.core.enums.bank;

import com.cqwo.base.core.model.SelectListItem;
import com.cqwo.base.core.helper.TypeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cqnews
 */

public enum BankAction {


    /**
     * 消费
     */
    Spend("spend", "消费", -3),
    /**
     * 扣款
     */
    Debit("debit", "扣款", -2),

    /**
     * 提现
     */
    Cash("cash", "提现", -1),

    /**
     * 未定义
     */
    None("none", "未定义", 0),
    /// <summary>
    /// 收入
    /// </summary>
    InCome("income", "消费收入", 1),
    /// <summary>
    /// 充值
    /// </summary>
    Recharge("recharge", "充值", 2),
    /// <summary>
    /// 提成奖励
    /// </summary>
    Reward("reward", "报事奖励", 3),
    /// <summary>
    /// 推荐奖励
    /// </summary>
    Recommend("recommend", "推荐奖励", 4);


    String code;
    String name;
    Integer index;


    BankAction(String code, String name, int index) {
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

    public void setIndex(int index) {
        this.index = index;
    }


    /**
     * 通过index获取枚举名称
     *
     * @param index
     * @return
     */
    public String getName(int index) {

        BankAction[] actions = BankAction.values();
        for (BankAction bankAction : actions) {
            if (index == bankAction.getIndex()) {
                return bankAction.getName();
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
    public static BankAction getBankAction(int index) {

        BankAction[] actions = BankAction.values();
        for (BankAction bankAction : actions) {
            if (bankAction.getIndex().equals(index)) {
                return bankAction;
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
    public static List<SelectListItem> getSelectListItem(int index) {
        List<SelectListItem> selectListItemList = new ArrayList<SelectListItem>();

        BankAction[] actions = BankAction.values();
        for (BankAction bankAction : actions) {

            SelectListItem item = new SelectListItem();

            item.setText(bankAction.getName());
            item.setValue(TypeHelper.intToString(bankAction.getIndex()));

            if (bankAction.getIndex().equals(index)) {
                item.setSelected(true);
            }

            selectListItemList.add(item);
        }

        return selectListItemList;
    }
}
