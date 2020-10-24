package com.hengyunsoft.platform.developer.impl.screen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.CommonApi;

@RestController
public class CommonApiImpl implements CommonApi {

	@Override
	@GetMapping("/screen/common/getDiscretenessCount")
	public Result<Integer> getDiscretenessCount() {
		return Result.success(83);
	}

}
