# Custom Villager Trades

This mod allow you to custom villager's trades.
You can find <b><i>sample.txt</i></b> and <b><i>CVT.json</i></b> in <b><i>./config/CustomVillagerTrades/</i></b>

---





## How to custom villager's trades?

You can customize your villager transactions according to the format in the <b>sample.json</b>

For example:

```json
[
  {
    "villager": {
      "profession": "farmer",
      "level": 1,
      "max_count": 3,
      "max_discount": 0.5,
      "xp": 5
    },
    "item": {
      "require": {
          "item": "minecraft:wheat",
          "count": 64,
          "nbt": ""
        },
      "result": {
          "item": "minecraft:diamond",
          "count": 1,
          "nbt": ""
      }
    }
  }
]
```

---

Each object in the outermost array is a user-defined transaction description block (hereinafter referred to as transaction block)

There are two objects in transaction block, called <b>villager</b> and <b>item</b> , respectively.

---

In Villager:

|   Key Name   |      Description      | Data Type | Example  |
| :----------: | :-------------------: | :-------: | :------: |
|  profession  | Villager's profession |  String   | "farmer" |
|    level     |   Villager's level    |  Integer  |    1     |
|      xp      |          Xp           |  Integer  |    5     |
|  max_count   | Max number of trades  |  Integer  |    3     |
| max_discount |   Maximum discount    |   Float   |   0.5    |

### Please warning: KeyName "profession" must be supported in Minecraft

As follows(All other nonconformities are in Other):

| Fillabe Value |  Description  |      Profession in Minecraft      |
| :-----------: | :-----------: | :-------------------------------: |
|    farmer     |    Farmer     |    VillagerProfession.FARMER;     |
|    armorer    |    Armorer    |    VillagerProfession.ARMORER;    |
|    butcher    |    Butcher    |    VillagerProfession.BUTCHER;    |
| cartographer  | Cartographer  | VillagerProfession.CARTOGRAPHER;  |
|    cleric     |    Cleric     |    VillagerProfession.CLERIC;     |
|    fishman    |    Fishman    |   VillagerProfession.FISHERMAN;   |
|   fletcher    |   Fletcher    |   VillagerProfession.FLETCHER;    |
| leatherworker | LeatherWorker | VillagerProfession.LEATHERWORKER; |
|   librarian   |   Librarian   |   VillagerProfession.LIBRARIAN;   |
|     mason     |     Mason     |     VillagerProfession.MASON;     |
|   shepherd    |   Shepherd    |   VillagerProfession.SHEPHERD;    |
|   toolsmith   |   Toolsmith   |   VillagerProfession.TOOLSMITH;   |
|  weaponsmith  |  Weaponsmith  |  VillagerProfession.WEAPONSMITH;  |
|     Other     | No profession |    VillagerProfession.NITWIT;     |

---

There are two objects in item block, called <b>require</b> and <b>result</b> , respectively.

require and result are item-description block.

| Key Name | Description | Data Type |      Example      |
| :------: | :---------: | :-------: | :---------------: |
|   item   |   Item id   |  String   | minecraft:diamond |
|  count   | Item count  |  Integer  |        10         |
|  nbt     | NBT Data    |  String   | {Damage:0}        |

---

### How to add NBT data?


In item object, write a identifier into NBT attribute

Warning：
> <b>Try to use only English and underscores for identifiers</b>

> <b>a *.nbt.txt file can only write one NBT data</b>

In <b>./config/CVT/nbt/</b> ,create a text file，name is <b>identifier.nbt.txt</b> such as test.nbt.txt

Then you can write NBT data that you need in this file.
```txt
{Damage:0,Enchantments:[{id:"minecraft:efficiency",lvl:5s}],RepairCost:1}
```

---

### How to add more trades blocks?

Just continue to add trades blocks to the outer array.

Such as:

```json
[
  {//First Trades Block
    "villager": {
      "profession": "farmer",
      "level": 1,
      "max_count": 3,
      "max_discount": 0.5,
      "xp": 5
    },
    "item": {
      "require": {
          "item": "minecraft:wheat",
          "count": 64,
          "nbt": ""
        },
      "result": {
        "item": "minecraft:diamond",
        "count": 1,
          "nbt": ""
      }
    }
  },
    
  {//Second Trades Block
    "villager": {
      "profession": "armorer",
      "level": 2,
      "max_count": 1,
      "max_discount": 0.6,
      "xp": 10
    },
    "item": {
      "require": {
          "item": "minecraft:diamond_block",
          "count": 64,
          "nbt": ""
        },
      "result": {
          "item": "minecraft:diamond",
          "count": 1,
          "nbt": ""
      }
    }
  }
]
```
