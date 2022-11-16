package top.furryliy.customvillagertrades.ele;

public class Villager {
    private String profession;
    private int level;
    private int max_count;
    private int xp;
    private float max_discount;
    public Villager(String o, int l, int m, int xp, float c){
        this.profession = o;
        this.level = l;
        this.xp = xp;
        this.max_count = m;
        this.max_discount = c;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMax_count() {
        return max_count;
    }

    public void setMax_count(int max_count) {
        this.max_count = max_count;
    }

    public float getMax_discount() {
        return max_discount;
    }

    public void setMax_discount(float max_discount) {
        this.max_discount = max_discount;
    }
}
