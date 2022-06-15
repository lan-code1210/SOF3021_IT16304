const app = angular.module("myApp", ["ngRoute"]);


app.config(function ($routeProvider, $locationProvider) {
  $routeProvider
    .when("/", { templateUrl: "assignment/User.html" })
    .when("/trangchu", { templateUrl: "assignment/MonHoc.html" })
    .when("/hoidap", { templateUrl: "assignment/hoidap.html" })
    .when("/gopy", { templateUrl: "assignment/Gopy.html" })
    .when("/gioithieu", { templateUrl: "assignment/GioiThieu.html" })
    .when("/lienhe", { templateUrl: "assignment/Lienhe.html" })
    .when("/list_taikhoan", { templateUrl: "assignment/list_taikhoan.html" })
    .when("/lambai", { templateUrl: "assignment/quiz.html" })
    .when("/dangky", { templateUrl: "assignment/dangky.html" })
    .when("/cauhoi", { templateUrl: "assignment/cauhoi.html" })

  .otherwise({ rediractTo: "/"});
});

app.controller("sinhviens", function ($scope, $http) {
  $scope.Users = [];
  $scope.user = {};
  $scope.status = false;
  $scope.isSuccess = true;
  $scope.message = "";
  $scope.index = -1;
  $scope.id = -1;
  $scope.user = {

    username: "",
    password: "",
    fullname: "",
    email: "",
    gender: "",
    birthday: "",
    schoolfee: "",
    marks: "",
  };
  $scope.data = {
    username: "",
    oldPassword: "",
    password: "",
    confirmPassword: "",
  };

  const api = "https://621665d07428a1d2a366a311.mockapi.io/students";

  $http
    .get(api)
    .then(function (response) {
      $scope.Users = response.data;
      console.log(response);
    })
    .catch(function (error) {
      console.log(error);
    });

  $scope.insert = function () {
    $http
      .post(api, $scope.user)
      .then(function (response) {

        $scope.Users.push(response.data);

        console.log(response);
        // Thông báo
        $scope.isSuccess = true;
        $scope.message = "thêm thành công";
      })
      .catch(function (error) {
        // Thông báo
        $scope.isSuccess = false;
        $scope.message = "thất bại";

      });
  };

  $scope.edit = function () {
    const updateAPI = api + "/" + $scope.id;
    $http
      .put(updateAPI, $scope.user)
      .then(function (response) {

        $scope.Users[$scope.index] = angular.copy(response.data);

        // Thông báo
        $scope.isSuccess = true;
        $scope.message = "Sửa thành công";
      })
      .catch(function (error) {
        // Thông báo
        $scope.isSuccess = false;
        $scope.message = "thất bại";

      });
  };

  $scope.getDataDelete = function (index) {
    $scope.id = $scope.Users[index].id;
    $scope.index = index;
  }

  $scope.manager_Delete = function () {

    const deleteApi = api + "/" + $scope.id;
    $http
      .delete(deleteApi)
      .then(function (response) {
        $scope.Users.splice($scope.index, 1);
        // Đóng loading`

        //loading lại trang
        // $scope.isLoading = true;
        $scope.isSuccess = true;
        $scope.message = "Xóa thành công";

      })
      .catch(function (error) {
        // Đóng loading
        // $scope.isLoading = false;

        // Thông báo
        console.log("lỗi");
        $scope.message = "Xóa thất bại";
        $scope.isSuccess = false;
      });
  };

  $scope.pushinfor = function (index) {
    $scope.user = angular.copy($scope.Users[index]);
    const id = $scope.Users[index].id;
    $scope.id = id;
    $scope.index = index;

  }


});


function myController($scope, $http) {
  const url = "https://6214ed0517cf186d277ce57e.mockapi.io/Subjects";
  $scope.isLoading = true;
  $http.get(url)
    .then(function (response) {
      console.log(response.data);
      $scope.Subjects = response.data;
      $scope.isLoading = false;
    })
    .catch(function (error) {
      console.log(error);
      $scope.isLoading = false;
    });
}
app.controller("my_controller", myController);



app.controller("qlch", function ($scope, $http) {

  $scope.dscauhoi = {}
  $scope.cauhoi = {}
  $scope.dsMonHoc = []
  $scope.vt = 0
  $http.get("https://621665d07428a1d2a366a311.mockapi.io/monhoc").then(function (dl) {
    $scope.dsMonHoc = dl.data
  })

  $scope.moi = function () {
    $scope.dk = false
  }

  $scope.showF = function (index) {
    $scope.dk = true
    $scope.vt = index
    $scope.cauhoi = angular.copy($scope.dscauhoi.CauHoi[index])
    $scope.cauhoi.AnswerId += ""
  }

  $scope.sua = function () {
    $scope.dscauhoi.CauHoi.splice(index, 1, $scope.cauhoi)
    $scope.update()
  }

  $scope.update = function () {
    $http.put("https://621665d07428a1d2a366a311.mockapi.io/monHoc/" + $scope.dscauhoi.id, $scope.dscauhoi) 
  }



  $scope.them = function () {
    $scope.dscauhoi.CauHoi.push($scope.cauhoi)
    $scope.update()
  }

  $scope.xoa = function (index) {
    $scope.dscauhoi.CauHoi.splice(index, 1)
    $scope.update()
  }

})