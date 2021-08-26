package com.zxk.domain;

import com.zxk.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @program: StudentManagerMyBatis
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-13 11:39
 **/
public class Student implements Serializable {
    private static final long serialVersionUID = 8683452581122892189L;
    /**
     * 学生id
     */
    private Integer id;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生年龄
     */
    private Integer age;
    /**
     * 学生性别
     */
    private String gender;
    /**
     * 学生成绩
     */
    private Integer score;
    /**
     * 学生生日
     */
    private Date bir;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String gender, Integer score, Date bir) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.score = score;
        this.bir = bir;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public String getBirStr() {
        return DateUtils.date2Str(getBir());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId()) &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getAge(), student.getAge()) &&
                Objects.equals(getGender(), student.getGender()) &&
                Objects.equals(getScore(), student.getScore()) &&
                Objects.equals(getBir(), student.getBir());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getGender(), getScore(), getBir());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", bir=" + bir +
                '}';
    }
}
