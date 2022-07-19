package com.skillstorm.project2.userPlan;

import com.skillstorm.project2.device.Device;
import com.skillstorm.project2.plan.Plan;
import com.skillstorm.project2.user.User;

import javax.persistence.*;

@Entity
@Table(name = "user_plan")
public class UserPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    /*
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;*/
    int user_id;

    @OneToOne
    @JoinColumn(name = "plan_id")
    Plan plan;

    // int plan_id;

    /*
    @OneToOne
    @JoinColumn(name = "device_id")
    Device device;*/
    int device_id;

    @Override
    public String toString() {
        return "UserPlan{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", plan=" + plan +
                ", device_id=" + device_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public int getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }
}
