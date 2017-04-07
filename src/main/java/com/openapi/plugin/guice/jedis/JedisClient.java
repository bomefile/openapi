package com.openapi.plugin.guice.jedis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.openapi.annotation.mvc.Component;
import com.openapi.constants.TuituiConstants;
import com.openapi.dao.JxTuituiBlackwordMapper;
import com.openapi.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * redis 操作 工具类 单例模式
 *
 * @author liuzeyuan
 */
@Component
@Singleton
public class JedisClient {
    @Inject
    JxTuituiBlackwordMapper jxTuituiBlackwordMapper;
    private static JedisPool pool = null;
    protected static final Logger logger = LogManager.getLogger(JedisClient.class);

    @Inject
    public JedisClient(//
                       @Named("redis.host") String host, //
                       @Named("redis.port") int port, //
                       @Named("redis.timeout") int timeout, //
                       @Named("redis.maxtotal") int maxtotal,//
                       @Named("redis.maxidle") int maxidle,//
                       @Named("redis.maxwait") int maxwait,//
                       @Named("redis.testOnBorrow") boolean testOnBorrow) {
        try {
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            poolConfig.setMaxTotal(maxtotal);
            poolConfig.setMaxIdle(maxidle);
            poolConfig.setMaxWaitMillis(maxwait);
            poolConfig.setTestOnBorrow(testOnBorrow);
            pool = new JedisPool(poolConfig, host, port, timeout);
            logger.info("jedis pool init successfully");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            logger.info("jedis pool init failed");
        } finally {

        }
    }

    /**
     * 获得jedis
     *
     * @return
     */
    public Jedis getJedis() {
        return pool.getResource();
    }

    /**
     * 关闭jredis
     *
     * @param jedis
     */
    public void closeRedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 推推房源标题,判断是否包含黑名单关键字
     *
     * @param content
     * @return
     */
    @SuppressWarnings("resource")
    public boolean checkContainsTuituiHouseTitleKeyWords(String content) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            // redis 中存储key
            final String key = "tuitui.keywords.blacklist";
            //
            content = StringUtil.trim(content);
            if (StringUtil.isBlank(content)) {
                return true;
            }
            List<String> words = jedis.lrange(key, 0, -1);
            // 没有数据初始化数据
            if (words != null && words.size() <= 0) {
                words = jxTuituiBlackwordMapper.selectALLWords();
                TuituiConstants.black_words.clear();
                for (String word : words) {
                    jedis.lpush(key, StringUtil.trim(word));
                    TuituiConstants.black_words.add(word);
                }
            }
            // 有数据则遍历
            for (String word : words) {
                if (content.contains(word)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        } finally {
            // 这里很重要，一旦拿到的jedis实例使用完毕，必须要返还给池中
            if (jedis != null) {
                jedis.close();
            }
        }

    }
}
