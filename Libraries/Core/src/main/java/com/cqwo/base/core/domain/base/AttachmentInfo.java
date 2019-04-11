package com.cqwo.base.core.domain.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author cqnews
 */ //附件表
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "w_attachment")
public class AttachmentInfo implements Serializable {


    private static final long serialVersionUID = 2641109345239370432L;
    /**
     * 附件id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachid")
    private Integer attachId = 0;

    /**
     * 用户uid
     **/
    @Column(name = "uid", nullable = false)
    @ColumnDefault(value = "-1")
    private Integer uid = -1;

    /**
     * 附件地址
     **/
    @Column(name = "url", nullable = false)
    @ColumnDefault(value = "''")
    private String url = "";

    /**
     * 标题
     **/
    @Column(name = "title", nullable = false)
    @ColumnDefault(value = "''")
    private String title = "";

    /**
     * 创建时间
     **/
    @Column(name = "createtime", nullable = false)
    @ColumnDefault(value = "0")
    private Integer createTime = 0;


    public AttachmentInfo(String uri, Integer uid, String title) {
        this.url = uri;
        this.uid = uid;
        this.title = title;
    }
}