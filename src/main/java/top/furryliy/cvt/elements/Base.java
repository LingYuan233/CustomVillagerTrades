package top.furryliy.cvt.elements;

public class Base {
    private Villager villager;
    private Items item;

    public Base(Villager villager, Items item) {
        this.villager = villager;
        this.item = item;
    }

    public Villager getVillager() {
        return villager;
    }

    public void setVillager(Villager villager) {
        this.villager = villager;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Base{" +
                "villager=" + villager +
                ", item=" + item +
                '}';
    }
}
