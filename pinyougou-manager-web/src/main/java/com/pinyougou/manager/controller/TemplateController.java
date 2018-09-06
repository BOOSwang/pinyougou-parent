package com.pinyougou.manager.controller;/**
 * Created by wangyanci on 2018/9/6.
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TemplateService;
import entity.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * &lt;pre&gt;项目名称：
 * 类名称：
 * 类描述：
 * 创建人：王晏赐
 * 创建时间：
 * 修改人：王晏赐
 * 修改时间：
 * 修改备注：
 *
 * @version &lt;/pre&gt;
 */
@RestController
@RequestMapping("/template")
public class TemplateController {

    @Reference
    private TemplateService templateService;


    /**
     * 查询
     * @param page
     * @param rows
     * @param tbTypeTemplate
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows, TbTypeTemplate tbTypeTemplate){
        return templateService.findPage(page,rows,tbTypeTemplate);
    }

    /**
     * 新增/修改
     * @param tbTypeTemplate
     * @return
     */
    @RequestMapping("/saveTemplate")
    public String saveTemplate(@RequestBody TbTypeTemplate tbTypeTemplate){

        if(tbTypeTemplate.getId()!=null && !"".equals(tbTypeTemplate.getId())){
            templateService.updateTemplate(tbTypeTemplate);
        }else{
            templateService.saveTemplate(tbTypeTemplate);
        }
        return "1";
    }


    @RequestMapping("/findOne")
    public TbTypeTemplate findOne(String id){
        return templateService.findOne(id);
    }

}
