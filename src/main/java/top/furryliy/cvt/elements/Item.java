package top.furryliy.cvt.elements;

public class Item {
    private String name;
    private int count;
    private String nbt;

    public Item(String name, int count, String nbt) {
        this.name = name;
        this.count = count;
        this.nbt = nbt;
    }

    public String getNbt() {
        return nbt;
    }

    public void setNbt(String nbt) {
        this.nbt = nbt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
