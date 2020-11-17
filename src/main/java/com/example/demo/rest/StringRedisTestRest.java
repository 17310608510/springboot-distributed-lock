package com.example.demo.rest;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.redis.util.RedisUtil;
import com.example.demo.util.JsonResult;
import com.example.demo.util.ResultCode;

/**
 * @author 作者 zuoruibo:
 * @date 创建时间：2020年11月16日 下午5:56:15
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@RestController
public class StringRedisTestRest {
	protected static Logger logger = LoggerFactory.getLogger(StringRedisTestRest.class);

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	// 例如：http://localhost:9090/set?key=name&value=minbo英文名
	@RequestMapping("/set")
	public JsonResult setKeyAndValue(String key, String value) {
		logger.debug("访问set:key={},value={}", key, value);
		RedisUtil.set(this.redisTemplate, key, value);
		return new JsonResult(ResultCode.SUCCESS);
	}

	// 例如：http://localhost:9090/get?key=name
	@RequestMapping("/get")
	public JsonResult getKey(String key) {
		logger.debug("访问get:key={}", key);
		String result = (String) RedisUtil.get(this.redisTemplate, key);
		logger.debug("get result=" + result);
		return new JsonResult(ResultCode.SUCCESS, result);
	}
}
