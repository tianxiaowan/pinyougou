//创建一个controller
app.controller('brandController',function ($scope,$http,$controller,brandService) {

    //controller的继承
    $controller('baseController',{$scope:$scope})


    //查询所有品牌列表
    $scope.getPage=function (page,size) {
        //请求地址
        // var url='/brand/list.shtml?page='+page+'&size='+size;

        //执行查询获取返回结果
        brandService.findAll(page,size,$scope.searchEntity).success(function (response) {
            //获取响应数据  先接受集合数据
            $scope.list=response.list;
            //给分页参数赋值
            $scope.paginationConf.totalItems=response.total;
        });
    }


    //创建save方法
    $scope.save=function () {
        //请求地址
        // var url='/brand/add.shtml';
        var result ;

        //如果id!=null，则执行修改
        if($scope.entity.id!=null){
            //修改地址  提交数据是$scoe.entity
            // url='/brand/modify.shtml';
            result = brandService.update($scope.entity);
        }else{
            result = brandService.add($scope.entity);
        }


        //发送请求   $scope.entity   ，第1个参数是url，第2个参数表示提交的数据
        result.success(function (response) {
            if(response.success){
                //增加成功，刷新页面
                $scope.getPage(1,10);
            }else{
                alert(response.message);
            }
        })
    }


    //根据DI查询   id:品牌ID
    $scope.findOne=function (id) {
        // alert(id);
        //url
        // var url='/brand/'+id+'.shtml';
        brandService.findOne(id).success(function (response) {
            // alert(JSON.stringify(response))
            $scope.entity=response;
        });
    }


    //删除方法
    $scope.delete=function () {
        //url
        // var url='/brand/delete.shtml';

        //执行删除
        brandService.delete($scope.selectIds).success(function (response) {
            if(response.success){
                //删除成功，重新加载页面
                $scope.getPage(1,10);
            }else{
                alert(response.message);
            }
        })
    }


});