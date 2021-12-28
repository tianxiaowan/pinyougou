//服务层
app.service('specificationService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../specification/list.shtml');
	}

	//读取列表数据绑定到表单中
	this.selectOptionList=function(){
		return $http.get('../specification/selectOptionList.shtml');
	}

	//分页 
	this.findPage=function(page,rows,searchEntity){
		return $http.post('../specification/list.shtml?page='+page+'&rows='+rows,searchEntity);
	}
	//查询实体
	this.getById=function(id){
		return $http.get('../specification/'+id+'.shtml');
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../specification/add.shtml',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../specification/update.shtml',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.post('../specification/delete.shtml',ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../specification/list.shtml?page='+page+"&rows="+rows, searchEntity);
	}    	
});
