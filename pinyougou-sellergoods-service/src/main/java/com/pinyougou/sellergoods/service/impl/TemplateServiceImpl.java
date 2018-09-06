package com.pinyougou.sellergoods.service.impl;/**
 * Created by wangyanci on 2018/9/6.
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.pojo.TbTypeTemplateExample;
import com.pinyougou.sellergoods.service.TemplateService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TbTypeTemplateMapper tbTypeTemplateMapper;

    /**
     * 查询
     * @param page
     * @param rows
     * @param tbTypeTemplate
     * @return
     */
    public PageResult findPage(int page, int rows, TbTypeTemplate tbTypeTemplate) {

        PageHelper.startPage(page,rows);

        TbTypeTemplateExample tbTypeTemplateExample = new TbTypeTemplateExample();

        if(tbTypeTemplate!=null){

            TbTypeTemplateExample.Criteria criteria = tbTypeTemplateExample.createCriteria();

            if(tbTypeTemplate.getName()!=null && !"".equals(tbTypeTemplate.getName())){
                criteria.andNameLike("%"+tbTypeTemplate.getName()+"%");
            }
        }

        Page<TbTypeTemplate> p = (Page<TbTypeTemplate>) tbTypeTemplateMapper.selectByExample(tbTypeTemplateExample);

        List<TbTypeTemplate> result = p.getResult();

        PageResult pageResult = new PageResult();

        pageResult.setTotal(p.getTotal());

        pageResult.setRows(result);

        return pageResult;
    }

    @Override
    public void saveTemplate(TbTypeTemplate tbTypeTemplate) {
        tbTypeTemplateMapper.insert(tbTypeTemplate);
    }

    @Override
    public TbTypeTemplate findOne(String id) {
        return tbTypeTemplateMapper.selectByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public void updateTemplate(TbTypeTemplate tbTypeTemplate) {
        tbTypeTemplateMapper.updateByPrimaryKey(tbTypeTemplate);
    }
}

