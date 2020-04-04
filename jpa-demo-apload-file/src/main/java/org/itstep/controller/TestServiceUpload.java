package org.itstep.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Slf4j
@Controller
@RequestMapping(value = "/upload")
public class TestServiceUpload {


    @GetMapping
    public String index() {
        log.info("index GET upload");
        return "uploadAvatar";
    }

    @PostMapping
    public String upload(@RequestParam CommonsMultipartFile img, Model model) throws IOException {
        Path p = Paths.get(System.getProperty("user.dir"));
        log.info("p: " + p);
        log.info(p + "/imgForAvatar/" + img.getOriginalFilename());
        img.transferTo(new File(p + "/imgForAvatar/" + img.getOriginalFilename()));
        return "redirect:/upload";
    }
}
