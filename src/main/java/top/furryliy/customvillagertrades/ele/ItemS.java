package top.furryliy.customvillagertrades.ele;

public class ItemS {
    private String item;
    private int count;
    public ItemS(String i, int c){
        this.count = c;
        this.item = i;
    }

    public int getCount() {
        return count;
    }

    public String getItem() {
        return item;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
