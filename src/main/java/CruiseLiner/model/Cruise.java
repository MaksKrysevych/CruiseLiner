package CruiseLiner.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Cruise {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Basic
    @Column(name = "regions", nullable = false, length = 200)
    private String regions;
    @Basic
    @Column(name = "liner", nullable = false, length = 100)
    private String liner;
    @Basic
    @Column(name = "start_day", nullable = false)
    private Date startDay;
    @Basic
    @Column(name = "finish_day", nullable = false)
    private Date finishDay;
    @Basic
    @Column(name = "from_port", nullable = false, length = 45)
    private String fromPort;
    @Basic
    @Column(name = "to_port", nullable = false, length = 45)
    private String toPort;
    @Basic
    @Column(name = "days", nullable = false)
    private int days;
    @Basic
    @Column(name = "description", nullable = false, length = 10000)
    private String description;

    public Cruise(String name, String regions, String liner, Date startDay, Date finishDay, String fromPort, String toPort, int days, String description) {
        this.name = name;
        this.regions = regions;
        this.liner = liner;
        this.startDay = startDay;
        this.finishDay = finishDay;
        this.fromPort = fromPort;
        this.toPort = toPort;
        this.days = days;
        this.description = description;
    }

    public Cruise() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions;
    }

    public String getLiner() {
        return liner;
    }

    public void setLiner(String liner) {
        this.liner = liner;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getFinishDay() {
        return finishDay;
    }

    public void setFinishDay(Date finishDay) {
        this.finishDay = finishDay;
    }

    public String getFromPort() {
        return fromPort;
    }

    public void setFromPort(String fromPort) {
        this.fromPort = fromPort;
    }

    public String getToPort() {
        return toPort;
    }

    public void setToPort(String toPort) {
        this.toPort = toPort;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cruise cruise = (Cruise) o;

        if (days != cruise.days) return false;
        if (name != null ? !name.equals(cruise.name) : cruise.name != null) return false;
        if (regions != null ? !regions.equals(cruise.regions) : cruise.regions != null) return false;
        if (liner != null ? !liner.equals(cruise.liner) : cruise.liner != null) return false;
        if (startDay != null ? !startDay.equals(cruise.startDay) : cruise.startDay != null) return false;
        if (finishDay != null ? !finishDay.equals(cruise.finishDay) : cruise.finishDay != null) return false;
        if (fromPort != null ? !fromPort.equals(cruise.fromPort) : cruise.fromPort != null) return false;
        if (toPort != null ? !toPort.equals(cruise.toPort) : cruise.toPort != null) return false;
        if (description != null ? !description.equals(cruise.description) : cruise.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (regions != null ? regions.hashCode() : 0);
        result = 31 * result + (liner != null ? liner.hashCode() : 0);
        result = 31 * result + (startDay != null ? startDay.hashCode() : 0);
        result = 31 * result + (finishDay != null ? finishDay.hashCode() : 0);
        result = 31 * result + (fromPort != null ? fromPort.hashCode() : 0);
        result = 31 * result + (toPort != null ? toPort.hashCode() : 0);
        result = 31 * result + days;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
