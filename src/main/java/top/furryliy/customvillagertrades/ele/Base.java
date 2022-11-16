package top.furryliy.customvillagertrades.ele;

public class Base {
    private Villager villager;
    private Item item;
    public Base(Villager v, Item i){
        this.item = i;
        this.villager = v;
    }

    public Item getItem() {
        return item;
    }

    public Villager getVillager() {
        return villager;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setVillager(Villager villager) {
        this.villager = villager;
    }
}
