package com.yuchengtech.bcrm.sales.marketTask.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * @describtion: autogenerated by lhqheli's Tools
 *
 * @author : lhqheli (email: lhqheli@gmail.com)
 * @date : 2014-07-03 10:21:57
 */
@Entity
@Table(name="OCRM_F_MM_TARGET")
public class OcrmFMmTarget implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="TARGET_CODE")
    private String targetCode;

    @Column(name="TARGET_NAME")
    private String targetName;

    @Column(name="TARGET_CYCLE")
    private String targetCycle;

    @Column(name="TARGET_TYPE")
    private String targetType;

    @Column(name="UPDATE_USER")
    private String updateUser;

    @Temporal(TemporalType.DATE)
    @Column(name="UPDATE_DATE")
    private Date updateDate;


    public String getTargetCode(){
        return this.targetCode;
    }

    public void setTargetCode(String targetCode){
        this.targetCode = targetCode;
    }

    public String getTargetName(){
        return this.targetName;
    }

    public void setTargetName(String targetName){
        this.targetName = targetName;
    }

    public String getTargetCycle(){
        return this.targetCycle;
    }

    public void setTargetCycle(String targetCycle){
        this.targetCycle = targetCycle;
    }

    public String getTargetType(){
        return this.targetType;
    }

    public void setTargetType(String targetType){
        this.targetType = targetType;
    }

    public String getUpdateUser(){
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser){
        this.updateUser = updateUser;
    }

    public Date getUpdateDate(){
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
    }


}