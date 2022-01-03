package net.teaho.demo.spring.cloud.discovery.api.config;

import net.teaho.demo.spring.cloud.discovery.api.UserFeign;

public class UserFeignFallback implements UserFeign {

    @Override
    public Object getUserById(Long id) {
        return "fallback getUserById";
    }

    @Override
    public Object getUserDetail() {
        return "fallback getUserDetail";
    }

    @Override
    public Boolean processVendorSpu(Long id, Byte result, Long languageId, Long categoryId, String categoryName, Long subCategoryId, String subCategoryName, Long itemId, String itemName, String description, String[] descImgs, String[] bannerImgs, String indexImage, String jsonSKU, String rejectMsg, String parameters, Long templateId) {
        return false;
    }
}