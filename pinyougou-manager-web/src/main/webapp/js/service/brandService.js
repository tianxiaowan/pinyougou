app.service('brandService',function ($http) {
    this.getAll = function () {
        return $http.get('/brand/list.shtml');
    }

    //查询所有 this相当于$scope
    this.findAll = function (page,size,searchEntity) {
        return $http.post('/brand/list.shtml?page='+page+'&size='+size,searchEntity);
    }

    this.add = function (entity) {
        return $http.post('/brand/add.shtml',entity);
    }

    this.update = function (entity) {
        return $http.post('/brand/update.shtml',entity);
    }

    this.findOne = function (id) {
        return $http.post('/brand/'+id+'.shtml');
    }

    this.delete = function (selectIds) {
        return $http.post('/brand/delete.shtml',selectIds);
    }

})