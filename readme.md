# Custom Villager Trades食用手册

## 介绍
Custom Villager Trades（简称CVT）是由Ling_Yuan制作的辅助性模组。

如模组名字所示，这个模组可以帮助地图等资源作者对村民进行交易物定制。

支持2换1，1换1，以及定义各交易物的NBT数据。

配置文件为json格式，需要有一定的json基础，可以借助一些网站对配置文件检错，如果模组加载错误的json，将会直接崩溃。

## 如何使用

**注意：村民职业的字段已于1.19.2-1.0.3版本添加了对模组村民职业的支持，以往的版本仅支持原版村民职业**

1. 安装模组
    - 首先对照自己所需的游戏版本下载对应版本的模组文件
    - 将模组文件(.jar)放进<b>游戏文件夹/mods/</b>中（需要Fabric API）
    - 启动游戏，创建默认配置文件，位于<b>游戏文件夹/config/CustomVillagerTrades/</b>中（以下简称cvt配置文件夹）
    - 安装完成
2. 编写自己的交易项
    1. 解读配置文件
        - 打开cvt配置文件夹下的<b>sample.txt</b>文本文件，可以看到这是由一个个交易项组成的数组。
        - 每个项里包含<b>villager</b>和<b>item</b>，这分别代表提供交易的村民属性和跟交易有关的物品。

        - villager对象内的属性：
          |     键名      |     描述     | 数据类型 |   示例   |
          | :----------: | :----------: | :------: | :------: |
          |  profession  |  村民的职业   |  字符串  | "farmer" |
          |    level     |  村民的等级   |   整数   |    1     |
          |      xp      |     经验     |   整数   |    5     |
          |  max_count   | 最大交易次数  |   整数   |    3     |
          | max_discount |   最大打折   |  浮点数  |   0.5    |
        
        - item对象内包含两个属性，一个是require，一个是result

        - require是由物品组成的数组，表示付出的物品。如果这个数组中只有一项，那么就是1换1；如果是包含两项及以上，那么就是2换1（第三项及以后的数据会被舍去）
        - result是一个物品对象，表示获得的物品
        - 物品所包含的属性：
        -   | 键名  |   描述   | 数据类型 |       示例        |
            | :---: | :------: | :------: | :---------------: |
            | item  |  物品id  |  字符串  | minecraft:diamond |
            | count | 物品数量 |   整数   |        10         |
            | nbt   | 物品的NBT | 字符串 |     {Damage:0}     |

    2. 编写交易项（简单）
        - 需求：在2级武器商，使用64个铁锭交易得1把钻石剑，每次最多交易1次，最大折扣0.5，经验得15
        - 村民：
            - 由需求可知：村民职业为<b>武器商</b>，等级为<b>2</b>级，最大交易次数为<b>1</b>次，最大折扣为<b>0.5</b>， 经验获得为<b>15</b>
            - 即
                ```json
                    "villager":{
                        "profession": "weaponsmith",
                        "level": 2,
                        "xp":15,
                        "max_count": 1,
                        "max_discount": 0.5
                    }
                ```
        - 物品：
            - 根据需求可知：使用<b>64</b>个<b>铁锭(minecraft:iron_ingot)</b>交易得<b>1</b>把<b>钻石剑(minecraft:diamond_sword)</b>
            - 即
                ```json
                "item":{
                    "require": [
                        {
                            "item": "minecraft:iron_ingot",
                            "count": 64,
                            "nbt": ""
                        }
                    ],
                    "result": {
                        "item": "minecraft:diamond_sword",
                        "count": 1,
                        "nbt": ""
                    }
                }
                ```
        - 最后再把两个对象拼接起来，得到最终的交易项：
            ```json
            {
                "villager": {
                    "profession": "weaponsmith",
                    "level": 2,
                    "max_count": 1,
                    "max_discount": 0.5,
                    "xp": 15
                },

                "item": {
                    "require": [{
                        "item": "minecraft:iron_ingot",
                        "count": 64,
                        "nbt": ""
                        }],
                    "result": {
                        "item": "minecraft:diamond_sword",
                        "count": 1,
                        "nbt": ""
                    }
                }
            }
            ```

    3. 编写交易项（高级）
        - 需求：在2级渔夫使用10个绿宝石和1把钓鱼竿，交易得附魔了耐久3，饵钓2的钓鱼竿，每次最多交易1次，最大折扣0.5，经验得15

        - 村民：
            - 由需求可知：村民职业为<b>渔夫</b>，等级为<b>2</b>级，最大交易次数为<b>1</b>次，最大折扣为<b>0.5</b>， 经验获得为<b>15</b>
            - 即                 
                ```json
                "villager": {
                    "profession": "fishman",
                    "level": 2,
                    "max_count": 1,
                    "max_discount": 0.5,
                    "xp": 15
                }
                ```
        - 物品：
            - 根据需求可知，第一个交易物为<b>10</b>个<b>绿宝石(minecraft:emerald)</b>，以及<b>1</b>把<b>钓鱼竿(minecraft:fishing_rod)</b>，获得<b>1</b>把<b>附魔钓鱼竿</b>
            
            - 注意：此处用到了NBT，需要注意几点：
                - nbt数据内的双引号需要使用反斜杠"\\"进行转义
                - 对于nbt数据，有需要的可以前往[此处查阅](https://minecraft.fandom.com/zh/wiki/%E6%95%99%E7%A8%8B/NBT%E5%91%BD%E4%BB%A4%E6%A0%87%E7%AD%BE)

            - 即
                ```json
                "item":{
                    "require": [
                        {
                            "item": "minecraft:emerald",
                            "count": 10,
                            "nbt": ""
                        },
                        {
                            "item": "minecraft:fishing_rod",
                            "count": 1,
                            "nbt": ""
                        }
                    ],
                    "result": {
                        "item": "minecraft:diamond_sword",
                        "count": 1,
                        "nbt": "{Enchantments:[{lvl:3,  id:\"minecraft:unbreaking\"},{lvl:2, id:\"minecraft:lure\"}]}"
                    }
                }
                ```
        - 最后再组合一下，得出最终的交易项：
            ```json
            {
                "villager": {
                    "profession": "fishman",
                    "level": 2,
                    "max_count": 1,
                    "max_discount": 0.5,
                    "xp": 15
                },
                "item":{
                    "require": [
                        {
                            "item": "minecraft:emerald",
                            "count": 10,
                            "nbt": ""
                        },
                        {
                            "item": "minecraft:fishing_rod",
                            "count": 1,
                            "nbt": ""
                        }
                    ],
                    "result": {
                        "item": "minecraft:diamond_sword",
                        "count": 1,
                        "nbt": "{Enchantments:[{lvl:3,  id:\"minecraft:unbreaking\"},{lvl:2, id:\"minecraft:lure\"}]}"
                    }
                }
            }
            ```
---


