package net.teaho.demo.spring.web.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping(value = "/getUserById")
    public Object getUserById(Long id) {
        return "{\"id\":1, \"name\": \"getUserById\"}";
    }

    @GetMapping(value = "/getUserDetail")
    public Object getUserDetail() {
        return "{\"id\":1, \"name\": \"getUserDetail\"}";
    }

    @GetMapping(value = "/processVendorSpu")
    public Boolean processVendorSpu(Long id, Byte result, Long languageId, Long categoryId, String categoryName, Long subCategoryId, String subCategoryName, Long itemId, String itemName, String description, String[] descImgs, String[] bannerImgs, String indexImage, String jsonSKU, String rejectMsg, String parameters, Long templateId) {
        System.out.println("id: " + id);
        return true;
    }


}
