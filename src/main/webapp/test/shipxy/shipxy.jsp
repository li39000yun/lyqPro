<%--
  Created by IntelliJ IDEA.
  User: lyq
  Date: 2016/4/28
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>船讯网测试</title>
</head>
<body>
<script src="http://api.shipxy.com/apdll/ap.dll?api=map&key=63EA637BDCEDBC8FD50200939D111A2C&ver=1.3" type="text/javascript"></script>
<script src="shipxy.js" type="text/javascript"></script>
<script src="utils.js" type="text/javascript"></script>
<script type="text/javascript">
    function addRow(data) {// 添加数据
        var T = document.getElementById("dataTable");
        R = document.createElement("TR");
        R = T.insertRow(T.rows.length);

        cell0 = R.insertCell(0);
        cell1 = R.insertCell(1);
        cell2 = R.insertCell(2);
        cell3 = R.insertCell(3);
        cell4 = R.insertCell(4);
        cell5 = R.insertCell(5);
        cell6 = R.insertCell(6);
        cell7 = R.insertCell(7);
        cell8 = R.insertCell(8);
        cell9 = R.insertCell(9);
        cell10 = R.insertCell(10);
        cell11 = R.insertCell(11);
        cell12 = R.insertCell(12);
        cell13 = R.insertCell(13);
        cell14 = R.insertCell(14);
        cell15 = R.insertCell(15);
        cell16 = R.insertCell(16);
        cell17 = R.insertCell(17);
        cell18 = R.insertCell(18);
        cell19 = R.insertCell(19);
        cell20 = R.insertCell(20);
        cell21 = R.insertCell(21);
        cell22 = R.insertCell(22);
        if (data.shipId != undefined) {
            cell0.innerHTML = data.shipId;
        }
        if (data.MMSI != undefined) {
            cell1.innerHTML = data.MMSI;
        }
        if (data.IMO != undefined) {
            cell2.innerHTML = data.IMO;
        }
        if (data.name != undefined) {
            cell3.innerHTML = data.name;
        }
        if (data.callsign != undefined) {
            cell4.innerHTML = data.callsign;
        }
        if (data.country != undefined) {
            cell5.innerHTML = data.country;
        }
        if (data.type != undefined) {
            cell6.innerHTML = data.type;
        }
        if (data.status != undefined) {
            cell7.innerHTML = data.status;
        }
        if (data.cargoType != undefined) {
            cell8.innerHTML = data.cargoType;
        }
        if (data.length != undefined) {
            cell9.innerHTML = data.length;
        }
        if (data.beam != undefined) {
            cell10.innerHTML = data.beam;
        }
        if (data.left != undefined) {
            cell11.innerHTML = data.left;
        }
        if (data.trail != undefined) {
            cell12.innerHTML = data.trail;
        }
        if (data.draught != undefined) {
            cell13.innerHTML = data.draught;
        }
        if (data.lat != undefined) {
            cell14.innerHTML = data.lat;
        }
        if (data.lng != undefined) {
            cell15.innerHTML = data.lng;
        }
        if (data.heading != undefined) {
            cell16.innerHTML = data.heading;
        }
        if (data.course != undefined) {
            cell17.innerHTML = data.course;
        }
        if (data.speed != undefined) {
            cell18.innerHTML = data.speed;
        }
        if (data.rot != undefined) {
            cell19.innerHTML = data.rot;
        }
        if (data.dest != undefined) {
            cell20.innerHTML = data.dest;
        }
        if (data.eta != undefined) {
            cell21.innerHTML = data.eta;
        }
        if (data.lastTime != undefined) {
            cell22.innerHTML = data.lastTime;
        }
    }

    window.onload = function() {
        var shipName = document.getElementById("shipName");
        if (shipName.value != "") {
            searchShip();
        }

        var shipArr = document.getElementById("shipMMSIArr");
        if (shipArr.value != "") {
            searchByShipMMSIArr();
        }
    }

    function searchShip() {
        var shipName = document.getElementById("shipName");
        if (shipName.value != "") {
            shipxyJS.getByName(shipName.value);
        }
    }

    function searchByShipMMSIArr() {
        // 判断是否字符串对象
        var shipArr = document.getElementById("shipMMSIArr");
        if (shipArr.value != "") {
            var mmsiArr = shipArr.value.split(",");
            // 根据mmsi数组批量查询
            shipxyJS.getShipsByMMSIARR(mmsiArr);
        }
    }
</script>

<%
    request.setCharacterEncoding("UTF-8");
    String shipName = request.getParameter("shipName");
    String shipMMSI = request.getParameter("shipMMSI");
    String shipMMSIArr = request.getParameter("shipMMSIArr");
    if (shipName != null) {
        shipName = new String(shipName.getBytes("ISO-8859-1"), "UTF-8");
    } else {
        shipName = "";
    }
    if (shipMMSI != null) {
        shipMMSI = new String(shipMMSI.getBytes("ISO-8859-1"), "UTF-8");
    } else {
        shipMMSI = "";
    }
    if (shipMMSIArr != null) {
        shipMMSIArr = new String(shipMMSIArr.getBytes("ISO-8859-1"), "UTF-8");
    } else {
        shipMMSIArr = "";
    }
%>
<input id="shipName" value="<%=shipName %>" />
<input type="button" value="根据船名查询" onclick="searchShip()" />
<input id="shipMMSI" value="<%=shipMMSI %>" />
<input type="button" value="根据船MMSI号查询" onclick="searchByShipMMSI()" />
<input id="shipMMSIArr" value="<%=shipMMSIArr %>" />
<input type="button" value="根据船MMSI号数组查询(MMSI号用逗号隔开)" onclick="searchByShipMMSIArr()" />
<table border="1" id="dataTable">
    <tr>
        <th width="100px">shipId</th>
        <th width="100px" width="100px">mmsi</th>
        <th width="100px">imo</th>
        <th width="100px">name</th>
        <th width="100px">callsign</th>
        <th width="100px">country</th>
        <th width="100px">type</th>
        <th width="100px">status</th>
        <th width="100px">cargoType</th>
        <th width="100px">length</th>
        <th width="100px">beam</th>
        <th width="100px">left</th>
        <th width="100px">trail</th>
        <th width="100px">draught</th>
        <th width="100px">lat</th>
        <th width="100px">lng</th>
        <th width="100px">heading</th>
        <th width="100px">course</th>
        <th width="100px">speed</th>
        <th width="100px">rot</th>
        <th width="100px">dest</th>
        <th width="100px">eta</th>
        <th width="100px">lastTime</th>
    </tr>
</table>
</body>
</html>
