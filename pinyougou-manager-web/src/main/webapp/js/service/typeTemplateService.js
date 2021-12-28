//服务层
app.service('typeTemplateService',function($http){
	    	
	//读取列表数据绑定到表单中
	/*this.findAll=function(){
		return $http.get('../typeTemplate/list.shtml');
	}*/
	//分页 
	this.findPage=function(page,rows,searchEntity){
		return $http.post('../typeTemplate/list.shtml?page='+page+'&rows='+rows,searchEntity);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../typeTemplate/getById/'+id+'.shtml');
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../typeTemplate/add.shtml',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../typeTemplate/update.shtml',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.post('../typeTemplate/delete.shtml',ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../typeTemplate/search.shtml?page='+page+"&rows="+rows, searchEntity);
	}    	
});
