package com.spring.xiecf.sample04.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

	@Autowired
	private StringRedisTemplate srt;

	@Autowired
	private RedisTemplate rt;

	@Test
	public void test() throws Exception {
		srt.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", srt.opsForValue().get("aaa"));

	}
}
