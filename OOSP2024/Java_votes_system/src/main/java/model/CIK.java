package model;

public class CIK extends baseEntity {
    public CIK(int id, String name) {
        super(id, name);
    }

    public CIK(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "CIK{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}