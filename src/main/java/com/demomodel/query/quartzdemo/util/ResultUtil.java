package com.demomodel.query.quartzdemo.util;


import com.google.gson.Gson;

/**
 * @ClassName ResultUtil
 * @Description TODO
 * @Author simonsfan
 * @Date 2019/1/1
 * Version  1.0
 */
public class ResultUtil<T> {
	public static void main(String[] args) {
		//return ResultUtil.fail();
//return ResultUtil.success(ResultEnum.PARAM_EMPTY.getCode(), ResultEnum.PARAM_EMPTY.getMessage());
	}

    public static String success() {
        Result result = new Result(ResultEnum.SUCCESS);
        return new Gson().toJson(result);
    }

    public static String success(Object obj) {
        Result result = new Result(ResultEnum.SUCCESS, obj);
        return new Gson().toJson(result);
    }

    public static String fail() {
        Result result = new Result(ResultEnum.FAIL);
        return new Gson().toJson(result);
    }

    public static String success(Integer code, String message) {
        Result result = new Result(code, message);
        return new Gson().toJson(result);
    }

}
