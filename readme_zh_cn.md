#自定义村民交易

这个模组允许你自定义村民们的交易项目
你可以在<b><i>./config/CustomVillagerTrades/</i></b> 目录下找到 <b><i>sample.json</i></b> and <b><i>VillagerConfig.json</i></b>

simple.json是一个示例文件，而<b>VillagerConfig.json</b>才是主要配置文件

---





## 怎么自定义村民的交易?

你可以根据 <b>sample.json</b> 中的格式编辑<b>VillagerConfig.json</b>

实例代码:

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
          "count": 64
        },
      "result": {
        "item": "minecraft:diamond",
        "count": 1
      }
    }
  }
]
```

---

在最外面数组里的每一个对象都是一个自定义交易描述块(以下简称交易块)

在交易块中有两个对象，分别名叫<b>villager</b>和<b>item</b>

---

在villager中：

|     键名     |     描述     | 数据类型 |   示例   |
| :----------: | :----------: | :------: | :------: |
|  profession  |  村民的职业  |  字符串  | "farmer" |
|    level     |  村民的等级  |   整数   |    1     |
|      xp      |     经验     |   整数   |    5     |
|  max_count   | 最大交易次数 |   整数   |    3     |
| max_discount |   最大打折   |  浮点数  |   0.5    |

### 请注意：profession字段只能填写原版MC中支持的村民职业

如下：(其他不符合值的全部归类为无业)

|   可填数值    |    描述    |       对应MC原版的村民职业        |
| :-----------: | :--------: | :-------------------------------: |
|    farmer     |    农民    |    VillagerProfession.FARMER;     |
|    armorer    |   护甲商   |    VillagerProfession.ARMORER;    |
|    butcher    |    屠夫    |    VillagerProfession.BUTCHER;    |
| cartographer  |   制图员   | VillagerProfession.CARTOGRAPHER;  |
|    cleric     |    牧师    |    VillagerProfession.CLERIC;     |
|    fishman    |    渔夫    |   VillagerProfession.FISHERMAN;   |
|   fletcher    |   制箭师   |   VillagerProfession.FLETCHER;    |
| leatherworker |   皮革商   | VillagerProfession.LEATHERWORKER; |
|   librarian   | 图书管理员 |   VillagerProfession.LIBRARIAN;   |
|     mason     |    石匠    |     VillagerProfession.MASON;     |
|   shepherd    |   牧羊人   |   VillagerProfession.SHEPHERD;    |
|   toolsmith   |   工具商   |   VillagerProfession.TOOLSMITH;   |
|  weaponsmith  |   武器商   |  VillagerProfession.WEAPONSMITH;  |
|     其他      |    无业    |    VillagerProfession.NITWIT;     |

----

在item中，有两个对象，分别名为<b>require</b>和<b>result</b>，分别对应<b>需要的物品</b>和<b>成品</b>

require和result块都是一个物品描述块

| 键名  |   描述   | 数据类型 |       示例        |
| :---: | :------: | :------: | :---------------: |
| item  |  物品id  |  字符串  | minecraft:diamond |
| count | 物品数量 |   整数   |        10         |



---

### 如何添加多个交易块？

只需要在外围数组中继续添加交易块即可(别忘了逗号)

如:

```json
[
  {//第一个交易块
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
          "count": 64
        },
      "result": {
        "item": "minecraft:diamond",
        "count": 1
      }
    }
  },
    
  {//第二个交易块
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
          "count": 64
        },
      "result": {
        "item": "minecraft:diamond",
        "count": 1
      }
    }
  }
]
```

