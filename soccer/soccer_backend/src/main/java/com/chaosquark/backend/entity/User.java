package com.chaosquark.backend.entity;

import com.chaosquark.backend.common.enums.PlayerPositionEnum;
import com.chaosquark.backend.common.enums.PlayerStatusEnum;
import com.chaosquark.backend.common.enums.StaffStatusEnum;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_user")
public class User extends IdEntity {
    private static final long serialVersionUID = 70447731122541189L;

    //用户名
    private String username;
    //密码
    private String password;
    //加密盐
    private String salt;
    //联系电话
    @Column(name = "phone_number")
    private Long phoneNumber;
    //电子邮箱
    private String email;
    //真实姓名
    private String realname;
    //昵称
    private String nickname;
    //性别
    private Integer gender;
    //生日
    private Date birthday;
    //号码
    @Column(name = "uniform_number")
    private Integer uniformNumber;
    //角色id集合（逗号，分割）
    @Column(name = "role_ids")
    private String roleIds;
    //头像
    @Column(name = "head_protrait_url")
    private String headProtraitUrl;
    //省代码
    @Column(name = "province_code")
    private Integer provinceCode;
    //城市代码
    @Column(name = "city_code")
    private Integer cityCode;
    //区代码
    @Column(name = "distinct_code")
    private Integer distinctCode;
    //详细地址
    private String address;
    //球员位置枚举
    @Column(name = "player_position")
    private PlayerPositionEnum playerPosition;
    //个人荣誉id集合（逗号，分割）
    @Column(name = "honor_ids")
    private String honorIds;
    //球员状态枚举
    @Column(name = "player_status")
    private PlayerStatusEnum playerStatus;
    //员工状态枚举
    @Column(name = "staff_status")
    private StaffStatusEnum staffStatus;
    //是否激活账号
    private Boolean actived;
    //账号激活码
    @Column(name = "active_code")
    private String activeCode;
    //备注
    private String note;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getUniformNumber() {
        return uniformNumber;
    }

    public void setUniformNumber(Integer uniformNumber) {
        this.uniformNumber = uniformNumber;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getHeadProtraitUrl() {
        return headProtraitUrl;
    }

    public void setHeadProtraitUrl(String headProtraitUrl) {
        this.headProtraitUrl = headProtraitUrl;
    }

    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCity_code(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getDistinctCode() {
        return distinctCode;
    }

    public void setDistinctCode(Integer distinctCode) {
        this.distinctCode = distinctCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PlayerPositionEnum getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPositionEnum playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getHonorIds() {
        return honorIds;
    }

    public void setHonorIds(String honorIds) {
        this.honorIds = honorIds;
    }

    public PlayerStatusEnum getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatusEnum playerStatus) {
        this.playerStatus = playerStatus;
    }

    public StaffStatusEnum getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(StaffStatusEnum staffStatus) {
        this.staffStatus = staffStatus;
    }

    public Boolean getActived() {
        return actived;
    }

    public void setActived(Boolean actived) {
        this.actived = actived;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
