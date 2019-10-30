package training.springboot.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import training.springboot.redis.util.RedisUtils;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private RedisUtils redisUtils;

    //测试插入缓存
    @Test
    public void testInsertKeys(){
        redisUtils.insertRedisKeys("testkey01","redisTest");
    }

    //测试获取缓存
    @Test
    public void testGetKeks(){
        System.out.println(redisUtils.getRedisKeys("testkey01"));
    }

    //测试更新缓存
    @Test
    public void testUpdateKeks(){
        redisUtils.updateRedisKeys("testkey01","testUpdate");
    }

    //测试删除缓存
    @Test
    public void testDelKeks(){
        redisUtils.deleteRedisKeys("testkey01");
    }
}
