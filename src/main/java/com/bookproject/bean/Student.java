package com.bookproject.bean;

/**
 * @author jh
 * @create 2021-06-01-18:53
 */
public class Student {
    private String username;
    private String name;
    private String password;
    private String job;
    private String phone;

    public Student() {
    }

    public Student(String username, String name, String password, String job, String phone) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.job = job;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
