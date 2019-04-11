package com.cqwo.base.core.domain.base;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

//信息配置文件
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "w_sysconfig")
public class SYSConfigInfo implements Serializable {


    private static final long serialVersionUID = -7966650301907548911L;
    /**
     * 配置id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0;

    /**
     * 变量名称
     **/
    @Column(name = "varname", nullable = false)
    @ColumnDefault(value = "''")
    private String varName = "";

    /**
     * 变量说明
     **/
    @Column(name = "vardesc", nullable = false)
    @ColumnDefault(value = "''")
    private String varDesc = "";

    /**
     * 变量类型
     **/
    @Column(name = "type", nullable = false)
    @ColumnDefault(value = "''")
    private String type = "json";

    /**
     * 变量值
     **/
    @Column(name = "varvalue", nullable = false)
    @ColumnDefault(value = "''")
    private String varValue = "";

}