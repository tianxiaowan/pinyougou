 //控制层 
app.controller('typeTemplateController' ,function($scope,$controller   ,typeTemplateService,brandService,specificationService){

	$controller('baseController',{$scope:$scope});//继承

	//$scope.entity = {customAttributeItems:[{},{}]};
	$scope.addCustomAttributeItems = function () {
		$scope.entity.customAttributeItems.push({});
	}

	$scope.delCustomAttributeItems = function (index) {
		$scope.entity.customAttributeItems.splice(index,1);;
	}

	//读取列表数据绑定到表单中
	$scope.findSpecificationAll=function(){
		specificationService.findAll().success(
			function(response){
				$scope.specificationList = {data: response}
			}
		);
	}

	//法2
	$scope.findSpecificationAll2=function(){
		specificationService.selectOptionList().success(
			function(response){
				$scope.specificationList = {data: response}
			}
		);
	}


    //读取列表数据绑定到表单中
	$scope.findBrandAll=function(){
		brandService.getAll().success(
			function(response){
				$scope.brandList = {data: response}
			}
		);
	}
	
	//分页
	$scope.getPage=function(page,rows){
		typeTemplateService.findPage(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.list;

				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

	$scope.getText= function(obj,key){
		var obj2 = (JSON.parse(obj));
		var str='';
		for(var i=0;i<obj2.length;i++){
			str +=obj2[i][key]+';';
		}

		return str;
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		typeTemplateService.findOne(id).success(
			function(response){
				$scope.entity= response;

				$scope.entity.brandIds = JSON.parse(response.brandIds);

				$scope.entity.customAttributeItems = JSON.parse(response.customAttributeItems);

				$scope.entity.specIds = JSON.parse(response.specIds);
			}
		);				
	}
	
	//保存 
	$scope.save=function(){

		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=typeTemplateService.update( $scope.entity ); //修改  
		}else{
			serviceObject=typeTemplateService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.getPage(1,10);//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框
		typeTemplateService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.getPage(1,10);//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}

	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		typeTemplateService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
});	
