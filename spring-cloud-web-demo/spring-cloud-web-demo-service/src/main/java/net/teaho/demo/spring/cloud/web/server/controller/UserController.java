package net.teaho.demo.spring.cloud.web.server.controller;

import net.teaho.demo.spring.cloud.web.api.UserFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController implements UserFeign {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Override
    public Object getUserById(Long id) {
        return "{\"id\":1, \"name\": \"test\"}";
    }

    @Override
    public Object getUserDetail() {
        return "{\"id\":1, \"name\": \"test\"}";
    }

    @Override
    public Boolean processVendorSpu(Long id, Byte result, Long languageId, Long categoryId, String categoryName, Long subCategoryId, String subCategoryName, Long itemId, String itemName, String description, String[] descImgs, String[] bannerImgs, String indexImage, String jsonSKU, String rejectMsg, String parameters, Long templateId) {
        System.out.println("id: " + id);
        return true;
    }


}
