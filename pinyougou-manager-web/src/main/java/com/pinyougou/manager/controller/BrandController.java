package com.pinyougou.manager.controller;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pinyougou.http.Result;

import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.model.Brand;
import com.pinyougou.sellergoods.service.BrandService;

import java.util.HashMap;
import java.util.Map;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Brand> list() {
        return brandService.getAll();
    }


    /**
     * 增加
     *
     * @param brand
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Brand brand) {
        try {
            int acount = brandService.add(brand);
            if (acount > 0) {
                //增加成功
                return new Result(true, "增加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "增加失败");
    }

    /**
     * 修改
     *
     * @param brand
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result modify(@RequestBody Brand brand) {
        try {
            int mcount = brandService.updateBrandById(brand);
            if (mcount > 0) {
                return new Result(true, "修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "修改失败");
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Brand getById(@PathVariable(value = "id") long id) {
        return brandService.getOneById(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete")
    public Result delete(@RequestBody List<Long> ids) {
        try {
            int dcount = brandService.deleteByIds(ids);
            if (dcount > 0) {
                return new Result(true, "删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "删除失败");
    }

    /**
     * 查询+分页
     *
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageInfo<Brand> list(@RequestBody Brand brand, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        System.out.println(brand);
//        System.out.println(page);
//        System.out.println(size);
//        System.out.println(brandService);
        return brandService.getAll(brand, page, size);
    }

}
