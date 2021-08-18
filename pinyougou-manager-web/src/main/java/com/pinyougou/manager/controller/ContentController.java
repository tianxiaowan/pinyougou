package com.pinyougou.manager.controller;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pinyougou.http.Result;

import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.model.Content;
import com.pinyougou.sellergoods.service.ContentService;
import java.util.HashMap;
import java.util.Map;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/content")
public class ContentController {

	@Reference
	private ContentService contentService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public List<Content> list(){			
		return contentService.getAll();
	}
	
	
	
	/**
	 * 增加
	 * @param content
	 * @return
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Result add(@RequestBody Content content){
		try {
			int acount =  contentService.add(content);
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
	 * @param content
	 * @return
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Result modify(@RequestBody Content content){
		try {
			int mcount =  contentService.updateContentById(content);
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
	public Content getById(@PathVariable(value = "id")long id){
		return contentService.getOneById(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public Result delete(@RequestBody List<Long> ids){
		try {
			int dcount = contentService.deleteByIds(ids);
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
	 * @param content
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public PageInfo<Content> list(@RequestBody Content content, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
																   @RequestParam(value = "size", required = false, defaultValue = "10") int size ){
		return contentService.getAll(content, page, size);		
	}
	
}
