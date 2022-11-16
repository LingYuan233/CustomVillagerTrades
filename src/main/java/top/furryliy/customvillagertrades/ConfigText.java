package top.furryliy.customvillagertrades;

public class ConfigText {

    private String r(){
        return System.getProperty("line.separator");
    }

    public static final String defaultCfg = """
            [ 
              ---This is a sample config file.
              ---Please according this format to edit 'VillagerConfig.json' file.
              ---这是一个示例配置文件
              ---请按照这种格式去编辑VillagerConfig.json文件
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
            ]""";
}
