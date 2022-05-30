package com.example.test_spring_boot.Entity;

import com.example.test_spring_boot.Configuration.Oauth2.CustomOauth2User;
import com.example.test_spring_boot.Configuration.Security.UserDetailCustom;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "Create_date")
    private Date CreateDate;

    @Column(name = "Create_By")
    private String CreateBy;

    @Column(name = "Modifier_date")
    private Date ModifierDate;

    @Column(name = "Modifier_by")
    private String ModifierBy;

    @PrePersist
    public void prePersist(){
        String createBy ="unknowUser";
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailCustom userDetailsCustom = (UserDetailCustom) authentication.getPrincipal();
            createBy = userDetailsCustom.getUsername();

        if (userDetailsCustom.getUsername() == null){
            authentication = SecurityContextHolder.getContext().getAuthentication();
            CustomOauth2User oAuth2User = (CustomOauth2User) authentication.getPrincipal();
            createBy = oAuth2User.getName();
        }

        this.CreateBy =createBy;
        this.CreateDate = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        String modifyBy ="unknowUser";
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailCustom userDetailsCustom = (UserDetailCustom) authentication.getPrincipal();
            modifyBy = userDetailsCustom.getUsername();

            if (userDetailsCustom.getUsername() == null){
                 authentication = SecurityContextHolder.getContext().getAuthentication();
                CustomOauth2User oAuth2User = (CustomOauth2User) authentication.getPrincipal();
                modifyBy = oAuth2User.getName();
            }
        this.ModifierBy = modifyBy;
        this.ModifierDate = new Date();
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public String getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(String createBy) {
        CreateBy = createBy;
    }

    public Date getModifierDate() {
        return ModifierDate;
    }

    public void setModifierDate(Date modifierDate) {
        ModifierDate = modifierDate;
    }

    public String getModifierBy() {
        return ModifierBy;
    }

    public void setModifierBy(String modifierBy) {
        ModifierBy = modifierBy;
    }
}