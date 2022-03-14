package com.example.projectarbetecomplexjavaspring.controller;


import com.example.projectarbetecomplexjavaspring.entity.UserEntity;
import com.example.projectarbetecomplexjavaspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserEntityController {

    @Autowired
    private UserRepository Urepo;

    @GetMapping({"/list", "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("list-userEntity");
        mav.addObject("userEntitys", Urepo.findAll());
        return mav;
    }


    @GetMapping("/addUserEntityForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-userEntity-form");
        UserEntity newUserEntity = new UserEntity();
        mav.addObject("userEntitys", newUserEntity);
        return mav;
    }

    @PostMapping("/saveUserEntity")
    public String saveEmployee(@ModelAttribute UserEntity userEntity) {
        Urepo.save(userEntity);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long userEntityId) {
        ModelAndView mav = new ModelAndView("add-userEntity-form");
        UserEntity userEntity = Urepo.findById(userEntityId).get();
        mav.addObject("userEntitys", userEntity);
        return mav;
    }

    @GetMapping("/deleteUserEntity")
    public String deleteEmployee(@RequestParam Long userEntityId) {
        Urepo.deleteById(userEntityId);
        return "redirect:/list";
    }
}
