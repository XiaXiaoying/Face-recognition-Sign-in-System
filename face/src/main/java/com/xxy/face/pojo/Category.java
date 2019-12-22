package com.xxy.face.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    int cid;

    String cname;

    public int getId() {
        return cid;
    }
    public void setId(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return cname;
    }
    public void setName(String cname) {
        this.cname = cname;
    }
}
