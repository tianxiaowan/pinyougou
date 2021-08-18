package com.pinyougou.manager.controller;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pinyougou.http.Result;

import org.springframework.web.bind.annotation.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.model.Goods;
import com.pinyougou.sellergoods.service.GoodsService;
import java.util.HashMap;
import java.util.Map;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference
	private GoodsService goodsService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public List<Goods> list(){			
		return goodsService.getAll();
	}
	
	
	
	/**
	 * 增加
	 * @param goods
	 * @return
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Result add(@RequestBody Goods goods){
		try {
			int acount =  goodsService.add(goods);
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
	 * @param goods
	 * @return
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Result modify(@RequestBody Goods goods){
		try {
			int mcount =  goodsService.updateGoodsById(goods);
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
	public Goods getById(@PathVariable(value = "id")long id){
		return goodsService.getOneById(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public Result delete(@RequestBody List<Long> ids){
		try {
			int dcount = goodsService.deleteByIds(ids);
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
	 * @param goods
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public PageInfo<Goods> list(@RequestBody Goods goods, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
																   @RequestParam(value = "size", required = false, defaultValue = "10") int size ){
		return goodsService.getAll(goods, page, size);		
	}
	
}
