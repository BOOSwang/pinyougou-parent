package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbTypeTemplate;
import entity.PageResult;

/**
 * Created by wangyanci on 2018/9/6.
 */
public interface TemplateService {
    PageResult findPage(int page, int rows, TbTypeTemplate tbTypeTemplate);

    void saveTemplate(TbTypeTemplate tbTypeTemplate);

    TbTypeTemplate findOne(String id);

    void updateTemplate(TbTypeTemplate tbTypeTemplate);
}
