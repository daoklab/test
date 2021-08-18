package com.daoklab.test.dbid.controller;

import com.daoklab.test.dbid.commons.base.BaseController;
import com.daoklab.test.dbid.commons.msg.ResultMessage;
import com.daoklab.test.dbid.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author xianglin
 * @Date 2021/8/17 16:03
 * @Version V1.0
 */
@Api(tags = "DB-ID")
@RestController
@RequestMapping
public class IndexController extends BaseController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "autoKey写入数据")
    @GetMapping("/auto/{sum}")
    public ResultMessage autoKey(@PathVariable Long sum) {
        return testService.autoKey(sum);
    }

    @ApiOperation(value = "uuidKey写入数据")
    @GetMapping("/uuid/{sum}")
    public ResultMessage uuidKey(@PathVariable Long sum) {
        return testService.uuidKey(sum);
    }

    @ApiOperation(value = "randomKey写入数据")
    @GetMapping("/random/{sum}")
    public ResultMessage randomKey(@PathVariable Long sum) {
        return testService.randomKey(sum);
    }

}
