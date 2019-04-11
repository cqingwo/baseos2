package com.cqwo.base.core.domain.authors;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户动作表
 *
 * @author cqnews
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "w_author_actions")
public class AuthorActionInfo implements Serializable {

    private static final long serialVersionUID = -2227297665686562449L;
    /**
     * aid
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private Integer aid = 0;

    /**
     * action
     **/
    @Column(name = "action", nullable = false)
    @ColumnDefault(value = "''")
    private String action = "";

    /**
     * 排序
     **/
    @Column(name = "displayorder", nullable = false)
    @ColumnDefault(value = "50")
    private Integer displayOrder = 50;

    /**
     * 上级id
     **/
    @Column(name = "parentid", nullable = false)
    @ColumnDefault(value = "0")
    private Integer parentId = 0;

    /**
     * 消息分组
     */
    @Column(name = "group2", nullable = false, length = 30)
    @ColumnDefault(value = "''")
    private String group = "user";

    /**
     * 标题
     **/
    @Column(name = "title", nullable = false)
    @ColumnDefault(value = "''")
    private String title = "";


}