/**
 * 船讯网调用js
 * @author liyunqiang
 * @since 2015-03-19
 */
var shipxyJS = {
    // 根据MMSI号查询船信息
    getShipsByMMSI : function(shipId) {
        var ships = new shipxyAPI.Ships(shipId, shipxyAPI.Ships.INIT_SHIPID); // 构建API请求单条船舶数据对象
        // 调用API的请求单条船舶数据接口
        ships.getShips(function(status) {
            if (status == 0 && ships && ships.length > 0) {
                // 获取数据成功
                var data = ships.data[0];
                return data;
            }
        });
    },
    // 根据MMSI号数组批量查询船信息
    getShipsByMMSIARR : function(shipIdArr) {
        var ships = new shipxyAPI.Ships(shipIdArr, shipxyAPI.Ships.INIT_SHIPID); // 构建API请求单条船舶数据对象
        // 调用API的请求单条船舶数据接口
        ships.getShips(function(status) {
            if (status == 0) {
                // 获取数据成功
                var data=ships.data;
                for (var j=0;j<data.length;j++) {
                    addRow(data[j]);
                }
            }
        });
    },
    // 根据船名、呼号、MMSI或IMO查询AIS信息
    getByName : function(key) {
        searchOj = null; // API查询工具对象
        searchMaxCount = 10; // 查询结果最大返回数
        if (!key) {
            return;
        }
        if (!searchOj) {
            searchOj = new shipxyAPI.Search(); // 构建API查询工具对象
        }
        // 调用API查询船舶接口
        searchOj.searchShip( {
            keyword : key,
            max : searchMaxCount
        }, function(status) {
            var data = this.data;
            if (status == 0 && data && data.length > 0) {// 当有结果，返回第一条结果
                addRow(data[0]);
            }
        });
    }
}