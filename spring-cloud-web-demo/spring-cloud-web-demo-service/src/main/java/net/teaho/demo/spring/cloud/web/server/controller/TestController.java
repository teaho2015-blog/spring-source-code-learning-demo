package net.teaho.demo.spring.cloud.web.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * @author teaho2015
 * @since 2019-09
 */
@RestController
public class TestController {

    @PostMapping(value = "/admin/vendor/sku/process/v3", produces = "application/json;charset=utf-8")
    public Boolean processVendorSpu2(HttpServletRequest request, @RequestParam(value = "id") Long id,
                                     @RequestParam(value = "result") Byte result,
                                     @RequestParam(value = "languageId", required = false) Long languageId,
                                     @RequestParam(value = "categoryId") Long categoryId,
                                     @RequestParam(value = "categoryName", required = false) String categoryName,
                                     @RequestParam(value = "subCategoryId") Long subCategoryId,
                                     @RequestParam(value = "subCategoryName", required = false) String subCategoryName,
                                     @RequestParam(value = "itemId", required = false) Long itemId,
                                     @RequestParam(value = "itemName", required = false) String itemName,
                                     @RequestParam(value = "description", required = false) String description,
                                     @RequestParam(value = "descImgs", required = false) String[] descImgs,
                                     @RequestParam(value = "bannerImgs", required = false) String[] bannerImgs,
                                     @RequestParam(value = "indexImg", required = false) String indexImage,
                                     @RequestParam(value = "jsonSKU", required = false) String jsonSKU,
                                     @RequestParam(value = "rejectMsg", required = false) String rejectMsg,
                                     @RequestParam(value = "parameters", required = false) String parameters,
                                     @RequestParam(value = "templateId", required = false) Long templateId) {
        System.out.println("id: " + id);

        return true;
    }
}
