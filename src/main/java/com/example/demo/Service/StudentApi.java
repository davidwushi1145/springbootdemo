package com.example.demo.Service;

import com.example.demo.Dao.IStudentDao;
import com.example.demo.Entity.Student;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "学生信息管理AIP")
@RestController
@RequestMapping(value = "/student")
public class StudentApi {
    @Autowired
    private IStudentDao studentDao;
//    @RequestMapping(value = "login/",method = RequestMethod.GET)
//    @GetMapping(value = "/login/{name}/{password}")
//    public Student login(@PathVariable String name,@PathVariable String password){
//        Student s= studentDao.findStudentByNameAndPassword(name,password);
//        if (s==null){
//            return null;
//        }else {
//            return s;
//        }
//    }
    @PostMapping(value = "/login")
    @ApiOperation(value = "登录",notes = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",required = true,dataType = "String"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 400,message = "失败")
    })
    public Student login2(@RequestParam String name,@RequestParam String password){
        return studentDao.findStudentByNameAndPassword(name,password);
    }
    @PostMapping(value = "/register")
    @ApiOperation(value = "注册",notes = "注册")
    @ApiImplicitParam(name = "student",value = "学生实体",required = true,dataType = "Student")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 400,message = "失败")
    })
    public boolean register(@RequestBody Student student){
        try {
            studentDao.save(student);
    }catch (Exception e){
            return false;
        }return true;
    }
    @PutMapping(value = "/update")
    @ApiOperation(value = "修改",notes = "修改")
    @ApiImplicitParam(name = "student",value = "学生实体",required = true,dataType = "Student")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 400,message = "失败")
    })
    public boolean update(@RequestBody Student student){
        try {
            studentDao.save(student);
        }catch (Exception e){
            return false;
        }return true;
    }
    @DeleteMapping(value = "/delete")
    @ApiOperation(value = "删除",notes = "删除")
    @ApiImplicitParam(name = "id",value = "学生id",required = true,dataType = "Long")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 400,message = "失败")
    })
    public boolean delete(@RequestParam Long id){
        try {
            studentDao.deleteById(id);
        }catch (Exception e){
            return false;
        }return true;
    }
}
