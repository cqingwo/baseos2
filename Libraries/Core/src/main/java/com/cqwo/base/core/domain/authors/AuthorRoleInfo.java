package com.cqwo.base.core.domain.authors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

//用户分组表
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "w_author_roles")
public class AuthorRoleInfo implements Serializable {


    private static final long serialVersionUID = -7169807466024299037L;
    /**
     * id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId = 0;

    /**
     * 分组名称
     **/
    @Column(name = "title", nullable = false)
    @ColumnDefault(value = "''")
    private String title = "";

    /**
     * 分组标识
     */
    @Column(name = "code", nullable = false, length = 20)
    @ColumnDefault(value = "''")
    private String code = "";

    /**
     * 分组描述
     **/
    @Column(name = "description", nullable = false)
    @ColumnDefault(value = "''")
    private String description = "";

}