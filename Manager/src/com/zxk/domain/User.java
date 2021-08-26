package com.zxk.domain;

import com.zxk.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @program: mmm
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-08 11:40
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 8683452581122892189L;
    /**
     * 用户id
     */
    private String uid;
    /**
     * 用户标识
     */
    private String ucode;
    /**
     * 登录名
     */
    private String loginname;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户性别
     */
    private String gender;
    /**
     * 用户生日
     */
    private Date birthday;
    /**
     * 入职日期
     */
    private Date dutydate;

    public User() {
    }

    public User(String uid, String ucode, String loginname, String password, String username, String gender,
                Date birthday, Date dutydate) {
        this.uid = uid;
        this.ucode = ucode;
        this.loginname = loginname;
        this.password = password;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.dutydate = dutydate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getBirStr() {
        return DateUtils.date2Str(getBirthday());
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDutydate() {
        return dutydate;
    }

    public String getDutyStr() {
        return DateUtils.date2Str(getDutydate());
    }

    public void setDutydate(Date dutydate) {
        this.dutydate = dutydate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(uid, user.uid) &&
                Objects.equals(ucode, user.ucode) &&
                Objects.equals(loginname, user.loginname) &&
                Objects.equals(password, user.password) &&
                Objects.equals(username, user.username) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(dutydate, user.dutydate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, ucode, loginname, password, username, gender, birthday, dutydate);
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", ucode='" + ucode + '\'' +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", dutydate=" + dutydate +
                '}';
    }
}
