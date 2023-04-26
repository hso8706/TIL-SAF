<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>RESTful 웹서비스 클라이언트(JSON)</title>
    <link
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        //rest server에 비동기 요청해서 데이터를 받아온 후에 화면에 뿌려주기 위함
        function selectAll() {
            fetch('http://localhost:8080/cus/customers')
                .then(response => response.json()) //낱개의 응답을 json 으로 변경
                .then(json => selectAllResult(json));  // json 을 다른 메서드로 처리
        }

        function selectAllResult(json){
                let list = ``;
                json.forEach(function (b) { //b: json 내부 값 중의 하나
                    list += `<tr onclick=selectOne(\${b.num})>
                                <td>\${b.num}</td>
                                <td>\${b.name}</td>
                                <td>\${b.address}</td>
                            </tr>`
                });
                document.getElementById('tb').innerHTML = list;
        }

        function selectOne(num){
                fetch('customers/' + num)
                    .then(response => response.json())
                    .then(json => selectOneResult(json));
        }

        function selectOneResult(json){
                var num = document.getElementById('num');
                var name = document.getElementById('name');
                var address = document.getElementById('address');

                if(json != "") {
                    num.value = json.num;
                    name.value = json.name;
                    address.value = json.address;
                }
                else { // 초기화 버튼
                    num.value = "";
                    name.value = "";
                    address.value = "";
                }
        }

        function clearText(){
                selectOneResult("");
        }

        function customerInsert(){
            var num = document.getElementById('num');
            var name = document.getElementById('name');
            var address = document.getElementById('address');

            if(num.value != null && name.value != null && address != null){
                fetch('http://localhost:8080/cus/customers', {
                    method: 'post',
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        num: num.value,
                        name: name.value,
                        address: address.value
                    })
                })
                    .then(response => {
                        selectAll();
                        clearText();
                    })
            }
            else {
                alert("추가할 값을 모두 넣어 주세요.")
            }
        }

        const customerUpdate = () => {
            const num = document.getElementById("num");
            const name = document.getElementById("name");
            const address = document.getElementById("address");

            if (num.value !== "" && name.value !== "" && address.value !== "") {
                fetch("http://localhost:8080/cus/customers", {
                    method: "put",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        "num": num.value,
                        "name": name.value,
                        "address": address.value
                    })
                })
                    .then(() => {
                        alert("수정 성공!");
                        clearText();
                        selectAll();
                    })
            } else {
                alert("수정할 값을 넣어주세요!");
            }
        }

        const customerDelete = () => {
            const num = document.getElementById("num");

            if (num.value !== "") {
                fetch("http://localhost:8080/cus/customers/" + num.value, {
                    method: "delete",
                })
                    .then(() => {
                        alert("삭제 성공!");
                        clearText();
                        selectAll();
                    })
            } else {
                alert("삭제할 값을 넣어주세요!");
            }
        }
    </script>
</head>
<body onload="selectAll()">
<div class="container">
    <form id="form1" class="form-horizontal">
        <h2>REST Customer Management</h2>
        <div class="form-group">
            <label>번호:</label> <input type="text" class="form-control" id="num">
        </div>
        <div class="form-group">
            <label>이름:</label> <input type="text" class="form-control" id="name">
        </div>

        <div class="form-group">
            <label>주소:</label> <input type="text" class="form-control"
                                      id="address">
        </div>

        <div class="btn-group">
            <input type="button" class="btn btn-primary" value="등록" id="btnInsert" onclick="customerInsert()"/>
            <input type="button" class="btn btn-primary" value="수정" id="btnUpdate" onclick="customerUpdate()"/>
            <input type="button" class="btn btn-primary" value="삭제" id="btnDelete" onclick="customerDelete()"/>
            <input type="button" class="btn btn-primary" value="초기화" id="btnInit" onclick="clearText()"/>
        </div>
    </form>
</div>
<hr/>
<div class="container">
    <h2>사용자 목록</h2>
    <table class="table text-center">
        <thead>
        <tr>
            <th class="text-center">번호</th>
            <th class="text-center">이름</th>
            <th class="text-center">주소</th>
        </tr>
        </thead>
        <tbody id="tb"></tbody>
    </table>
</div>
</body>
</html>





