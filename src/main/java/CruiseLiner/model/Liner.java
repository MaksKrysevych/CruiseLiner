package CruiseLiner.model;

import jakarta.persistence.*;

@Entity
public class Liner {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "built", nullable = false, length = 4)
    private String built;
    @Basic
    @Column(name = "room_count", nullable = false)
    private int roomCount;
    @Basic
    @Column(name = "max_people", nullable = false)
    private int maxPeople;
    @Basic
    @Column(name = "class", nullable = false, length = 45)
    private String clazz;
    @Basic
    @Column(name = "room_inner", nullable = false)
    private int roomInner;
    @Basic
    @Column(name = "room_with_window", nullable = false)
    private int roomWithWindow;
    @Basic
    @Column(name = "room_with_balcony", nullable = false)
    private int roomWithBalcony;
    @Basic
    @Column(name = "room_luxury", nullable = false)
    private int roomLuxury;

    public Liner(String name, String built, int roomCount, int maxPeople, String clazz, int roomInner, int roomWithWindow, int roomWithBalcony, int roomLuxury) {
        this.name = name;
        this.built = built;
        this.roomCount = roomCount;
        this.maxPeople = maxPeople;
        this.clazz = clazz;
        this.roomInner = roomInner;
        this.roomWithWindow = roomWithWindow;
        this.roomWithBalcony = roomWithBalcony;
        this.roomLuxury = roomLuxury;
    }

    public Liner() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilt() {
        return built;
    }

    public void setBuilt(String built) {
        this.built = built;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getRoomInner() {
        return roomInner;
    }

    public void setRoomInner(int roomInner) {
        this.roomInner = roomInner;
    }

    public int getRoomWithWindow() {
        return roomWithWindow;
    }

    public void setRoomWithWindow(int roomWithWindow) {
        this.roomWithWindow = roomWithWindow;
    }

    public int getRoomWithBalcony() {
        return roomWithBalcony;
    }

    public void setRoomWithBalcony(int roomWithBalcony) {
        this.roomWithBalcony = roomWithBalcony;
    }

    public int getRoomLuxury() {
        return roomLuxury;
    }

    public void setRoomLuxury(int roomLuxury) {
        this.roomLuxury = roomLuxury;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Liner liner = (Liner) o;

        if (roomCount != liner.roomCount) return false;
        if (maxPeople != liner.maxPeople) return false;
        if (roomInner != liner.roomInner) return false;
        if (roomWithWindow != liner.roomWithWindow) return false;
        if (roomWithBalcony != liner.roomWithBalcony) return false;
        if (roomLuxury != liner.roomLuxury) return false;
        if (name != null ? !name.equals(liner.name) : liner.name != null) return false;
        if (built != null ? !built.equals(liner.built) : liner.built != null) return false;
        if (clazz != null ? !clazz.equals(liner.clazz) : liner.clazz != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (built != null ? built.hashCode() : 0);
        result = 31 * result + roomCount;
        result = 31 * result + maxPeople;
        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
        result = 31 * result + roomInner;
        result = 31 * result + roomWithWindow;
        result = 31 * result + roomWithBalcony;
        result = 31 * result + roomLuxury;
        return result;
    }
}
