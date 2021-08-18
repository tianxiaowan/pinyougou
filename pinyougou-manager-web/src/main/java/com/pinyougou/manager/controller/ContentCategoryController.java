package com.pinyougou.manager.controller;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pinyougou.http.Result;

import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.model.ContentCategory;
import com.pinyougou.sellergoods.service.ContentCategoryService;
import java.util.HashMap;
import java.util.Map;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/contentCategory")
public class ContentCategoryController {

	@Reference
	private ContentCategoryService contentCategoryService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public List<ContentCategory> list(){			
		return contentCategoryService.getAll();
	}
	
	
	
	/**
	 * 增加
	 * @param contentCategory
	 * @return
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Result add(@RequestBody ContentCategory contentCategory){
		try {
			int acount =  contentCategoryService.add(contentCategory);
			if(acount>0){
                //增加成功
               return new Result(true,"增加成功");
            }
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return new Result(false, "增加失败");
	}
	
	/**
	 * 修改
	 * @param contentCategory
	 * @return
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Result modify(@RequestBody ContentCategory contentCategory){
		try {
			int mcount =  contentCategoryService.updateContentCategoryById(contentCategory);
			if(mcount>0){
                return new Result(true,"修改成功");
            }
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return new Result(false, "修改失败");
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ContentCategory getById(@PathVariable(value = "id")long id){
		return contentCategoryService.getOneById(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public Result delete(@RequestBody List<Long> ids){
		try {
			int dcount = contentCategoryService.deleteByIds(ids);
			if(dcount>0){
				return new Result(true,"删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result(false, "删除失败");
	}
	
		/**
	 * 查询+分页
	 * @param contentCategory
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public PageInfo<ContentCategory> list(@RequestBody ContentCategory contentCategory, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
																   @RequestParam(value = "size", required = false, defaultValue = "10") int size ){
		return contentCategoryService.getAll(contentCategory, page, size);		
	}
	
}
