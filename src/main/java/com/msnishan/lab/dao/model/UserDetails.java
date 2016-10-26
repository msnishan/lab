package com.msnishan.lab.dao.model;

import com.msnishan.lab.model.Level;

/**
 * Created by ksaleh on 10/16/16.
 */
public class UserDetails extends User {
    public enum Gender {
      MALE("M"), FEMALE("F");
        String value;

        Gender(String value) {
            this.value = value;
        }
    };

    private Gender gender;
    private Level level;
    private Address address;

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public Level getLevel() {
        return level;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserDetails that = (UserDetails) o;

        if (gender != that.gender) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "gender=" + gender +
                ", level=" + level +
                ", address=" + address +
                '}';
    }
}
