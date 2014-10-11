/**  
 * @Title:  PropertiesUtils.java
 * @Package com.wugu.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author yangch
 * @date  2014-9-25 
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package com.wugu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

/**
 * @ClassName: PropertiesUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yangch
 * @date 2014-9-25
 * 
 */
public class PropertiesUtils implements Serializable {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    public static Properties config = null;

    /**
     * 
     * @Title: initMailProperties
     * @Description: 初始化邮箱服务器
     * @author yangch
     * @date 2014-9-25
     * @throws
     */
    public static void initMailProperties() {
        config = new Properties();
        InputStream in = PropertiesUtils.class.getClassLoader()
                .getResourceAsStream("mail.properties");
        try {
            config.load(in);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @Title: getMailProperties
     * @Description: 获取邮件服务器配置信息
     * @author yangch
     * @date 2014-9-25
     * @return
     * @throws
     */
    public static Properties getMailProperties() {
        if (config == null) {
            initMailProperties();
        }
        return config;
    }
}
