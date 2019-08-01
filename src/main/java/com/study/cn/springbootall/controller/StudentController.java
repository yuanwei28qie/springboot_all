package com.study.cn.springbootall.controller;

import com.study.cn.springbootall.entity.Person;
import com.study.cn.springbootall.filter.ApiResponse;
import com.study.cn.springbootall.other.entity.Student;
import com.study.cn.springbootall.repository.PersonRepository;
import com.study.cn.springbootall.service.StudentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author huWei
 * @date 2019/7/21 12:26
 * <p> description:
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private PersonRepository personRepository;

    @RequestMapping(value = "detail/{id}",name = "查询学生详情")
    public ApiResponse detail(@PathVariable Long id){
        ApiResponse response = new ApiResponse();
        Student student = studentService.findByIdThrow(id);

        response.setCode(200);
        response.setData(student);
        response.setMessage("success");
        return  response;
    }

    @RequestMapping(value = "person/detail/{id}",name = "查询人物详情")
    public ApiResponse person(@PathVariable Long primaryId){
        ApiResponse response = new ApiResponse();
        Optional<Person> person = personRepository.findById(primaryId);
        if(person.isPresent()){
            response.setData(person.get());
        }
        response.setCode(200);
        response.setMessage("success");
        return  response;
    }


}