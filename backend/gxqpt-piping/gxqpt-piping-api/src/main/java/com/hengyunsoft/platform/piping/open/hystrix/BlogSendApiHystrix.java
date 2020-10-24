package com.hengyunsoft.platform.piping.open.hystrix;

import org.springframework.stereotype.Component;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.piping.api.msgs.dto.BlogSendDTO;
import com.hengyunsoft.platform.piping.open.BlogSendApi;
@Component
public class BlogSendApiHystrix implements BlogSendApi{

	public Result<String> send(BlogSendDTO blogSendDTO) {
		return Result.timeout();
	}

}
