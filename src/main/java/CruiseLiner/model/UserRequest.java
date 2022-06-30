package CruiseLiner.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "user_request", schema = "cruise_liner")
public class UserRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "login", nullable = false, length = 45)
    private String login;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cruise_name", nullable = false, length = 200)
    private String cruiseName;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    @Basic
    @Column(name = "count_people", nullable = false)
    private int countPeople;
    @Basic
    @Column(name = "status", nullable = false, length = 45)
    private String status;

    public UserRequest(String login, String cruiseName, int price, Date createTime, int countPeople, String status) {
        this.login = login;
        this.cruiseName = cruiseName;
        this.price = price;
        this.createTime = createTime;
        this.countPeople = countPeople;
        this.status = status;
    }

    public UserRequest() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCruiseName() {
        return cruiseName;
    }

    public void setCruiseName(String cruiseName) {
        this.cruiseName = cruiseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRequest that = (UserRequest) o;

        if (price != that.price) return false;
        if (countPeople != that.countPeople) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (cruiseName != null ? !cruiseName.equals(that.cruiseName) : that.cruiseName != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (cruiseName != null ? cruiseName.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + countPeople;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
