package top.liy233.mods.cvt.customvillagertrades.ele;

public class Villager {
    private String profession;
    private int level;
    private int max_count;
    private float max_discount;
    private int xp;

    public Villager(String profession, int level, int max_count, float max_discount, int xp) {
        this.profession = profession;
        this.level = level;
        this.max_count = max_count;
        this.max_discount = max_discount;
        this.xp = xp;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    @Override
    public String toString() {
        return "Villager{" +
                "profession='" + profession + '\'' +
                ", level=" + level +
                ", max_count=" + max_count +
                ", max_discount=" + max_discount +
                ", xp=" + xp +
                '}';
    }
}
