package com.cqwo.base.core.domain.authors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 角色许可表
 * @author cqnews
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "w_author_permissions")
public class AuthorPermissionInfo implements Serializable {


    private static final long serialVersionUID = 3164302230408551310L;
    /**
     * Id
     **/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    /**
     * 用户角色id
     **/
    @Column(name = "roleid", nullable = false)
    @ColumnDefault(value = "0")
    private Integer roleId = 0;

    /**
     * 动作id
     **/
    @Column(name = "aid", nullable = false)
    @ColumnDefault(value = "0")
    private Integer aid = 0;


}