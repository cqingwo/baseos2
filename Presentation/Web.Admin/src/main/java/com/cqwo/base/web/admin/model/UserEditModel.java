package com.cqwo.base.web.admin.model;

import com.cqwo.base.core.domain.base.RegionInfo;
import com.cqwo.base.core.model.SelectListItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * @author cqnews
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEditModel implements Serializable {

    private static final long serialVersionUID = -7996331993623183968L;
    /**
     * Uid
     */
    @NotNull(message = "用户名不能为空")
    @Length(min = 1, message = "Uid必须大于1")
    private String uid = "";


    /**
     * 用户名
     **/
    @NotNull(message = "用户名不能为空")
    @Length(min = 5, max = 20, message = "用户名长度必须在5-20之间")
    private String userName = "";
    /**
     * 邮箱
     **/
    @NotNull(message = "邮箱不能为空")
    @Length(min = 5, max = 20, message = "邮箱长度必须在5-20之间")
    @Email(message = "请输入正确的邮箱")
    private String email = "";
    /**
     * 手机
     **/
    @NotNull(message = "手机不能为空")
    @Length(min = 5, max = 20, message = "手机长度必须不正确")
    @Pattern(regexp = "^((13[0-9])|(14[57])|(15[012356789])|(17[678])|(18[0123456789]))\\d{8}$", message = "请输入正确的手机号码")
    private String mobile = "";

    /**
     * 密码
     **/
    @Length(min = 0, max = 20, message = "密码长度必须在0-20之间")
    private String password = "";
    /**
     * 用户等级
     **/
    @NotNull(message = "用户等级不能为空")
    @Range(min = 1, message = "请选择正确的用户等级")
    private int userRid = 0;
    /**
     * 昵称
     **/
    @NotNull(message = "用户昵称不能为空")
    private String nickName = "";
    /**
     * 真实姓名
     **/
    @NotNull(message = "真实姓名不能为空")
    private String realName = "";

    /**
     * 所在区域
     **/
    private int regionId = 0;
    /**
     * 地址
     **/
    @NotNull(message = "地址不能为空")
    private String address = "";

    /**
     * 用户详情
     */
    @NotNull(message = "用户详情不能为空")
    private String bio = "";


    /**
     * 用户列表
     */
    private List<SelectListItem> userRankItemList;

    /**
     * 区域模型
     */
    private RegionInfo regionInfo;


}
