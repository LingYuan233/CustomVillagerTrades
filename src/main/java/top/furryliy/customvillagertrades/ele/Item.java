package top.furryliy.customvillagertrades.ele;

public class Item {
    private ItemS require;
    private ItemS result;
    public Item(ItemS r, ItemS i){
        this.require = r;
        this.result = i;
    }

    public ItemS getResult() {
        return result;
    }

    public ItemS getRequire() {
        return require;
    }

    public void setRequire(ItemS require) {
        this.require = require;
    }

    public void setResult(ItemS result) {
        this.result = result;
    }
}
