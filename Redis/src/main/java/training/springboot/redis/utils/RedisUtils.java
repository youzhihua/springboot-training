package training.springboot.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String,Object> customRedisTemplate;

    /**
     * 插入缓存
     */
    public void insertRedisKeys(String key,String value){
        customRedisTemplate.opsForValue().set(key,value);
    }

    /**
     * 更新缓存
     */
    public void updateRedisKeys(String key,String value){
        customRedisTemplate.opsForValue().getAndSet(key,value);
    }

    /**
     * 获取缓存
     */
    public Object getRedisKeys(String key){
        return customRedisTemplate.opsForValue().get(key);
    }

    /**
     * 删除缓存
     */
    public void deleteRedisKeys(String key){
        customRedisTemplate.delete(key);
    }
}
