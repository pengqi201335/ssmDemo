package pengqi.commons.startUp;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * mybatis逆向工程核心代码，用于加载配置文件并生成pojo/mapper接口/mapper映射文件
 * 将所有数据表配置好之后运行一次即可，多次运行生成的代码不会覆盖原有的代码，而会向后追加，造成bug
 * 若要重新生成，将先前生成的文件删除即可
 */
public class mybatisGenerator {
    public static void main(String[] args) throws Exception{
        List<String> warnings = new ArrayList<>();
        boolean overWrite = true;
        //指定逆向工程配置文件
        File configFile = new File("/home/pengqi/IdeaProjects/ssmDemo/src/main/resources/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration configuration = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overWrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,callback,warnings);
        myBatisGenerator.generate(null);
    }
}
