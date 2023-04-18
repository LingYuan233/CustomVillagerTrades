package top.furryliy.cvt.elements;

import java.util.Arrays;

public class Items {
    private Item[] require;
    private Item result;

    public Items(Item[] require, Item result) {
        this.require = require;
        this.result = result;
    }

    public Item[] getRequire() {
        return require;
    }

    public void setRequire(Item[] require) {
        this.require = require;
    }

    public Item getResult() {
        return result;
    }

    public void setResult(Item result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Items{" +
                "require=" + Arrays.toString(require) +
                ", result=" + result +
                '}';
    }
}
