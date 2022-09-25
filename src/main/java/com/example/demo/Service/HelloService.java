package com.example.demo.Service;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试类")
@RestController
@RequestMapping("api/hello")
public class HelloService {
    @RequestMapping(value = "say/{name}",method = RequestMethod.GET)
    public String sayName(@PathVariable String name) {
        return "Your name is " + name + "!";
    }

}
