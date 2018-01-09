package ru.cmx.msa.testRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Echo
{
	Logger log = LoggerFactory.getLogger(Echo.class.getName());

	@RequestMapping(value = "/info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,String> info(HttpEntity httpEntity, HttpServletRequest request){
		Map<String,String> result = new HashMap<>();

		log.info("request: remote ip = "+request.getRemoteAddr());
		result.put("remoteIp",request.getRemoteAddr());

		for (Map.Entry<String,List<String>> header : httpEntity.getHeaders().entrySet())
			result.put(header.getKey(),header.getValue().get(0));
		return result;
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}

