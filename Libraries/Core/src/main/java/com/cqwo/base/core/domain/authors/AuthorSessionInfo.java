package com.cqwo.base.core.domain.authors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户-组关联表
 *
 * @author cqnews
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "w_author_sessions")
public class AuthorSessionInfo implements Serializable {


    private static final long serialVersionUID = -2426142183869450857L;
    /**
     * Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = 0;

    /**
     * 用户uid
     **/
    @Column(name = "uid", nullable = false)
    @ColumnDefault(value = "''")
    private String uid = "";

    /**
     * 用户组id
     **/
    @Column(name = "roleid", nullable = false)
    @ColumnDefault(value = "0")
    private Integer roleId = 0;

    public AuthorSessionInfo(String uid, Integer roleId) {
        this.uid = uid;
        this.roleId = roleId;
    }
}