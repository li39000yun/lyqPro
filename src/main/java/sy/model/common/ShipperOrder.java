package sy.model.common;


import java.util.List;
import java.util.ArrayList;
/**
 * Created by lyq on 2016/4/29.
 */
public class ShipperOrder extends MoreFactoryVO {
    private static final long serialVersionUID = 1L;
    protected int count = 0;// 页面列表显示序号
    protected int isOrder = 0;// 是否按票(0:否,1:是)按票时 业务单号不加柜序号
    protected int state = -1;// 当前状态
    protected String stateName = "";// 当前状态名称
    protected int isSign = 0;// 是否签收
    protected int isLock = 0;// 是否锁定
    protected int checkInFee = 0;// 是否录入应收费用
    protected int checkPayFee = 0;// 是否录入应付费用
    protected String invoiceNo = "";// 发票号
    protected int fxState = 0;// 放箱状态
    protected String createTime = "";// 创建时间
    protected String checkBillTime = "";// 核单时间
    // 做柜信息
    protected String busiDate = "";// 接单日期
    protected String appointDate = "";// 做柜日期
    protected String appointTime = "";// 做柜时间,格式:MM-DD mm:ss
    protected String timePoint = "";// 时间点
    protected int customerId = 0;// 客户编号
    protected String customerName = "";// 客户名称
    protected String customerJobNo = "";// 客户编号
    protected String customerContact = "";// 客户联系人
    protected String customsMode = "";// 报关方式
    protected int isAdvance = 0;// 截关日期预警
    protected String cutOffTime = "";// 截关时间
    protected String cutWeightTime = "";// 截重时间
    protected String departmentName = "";// 分公司
    protected String followMan = "";// 跟单员
    protected String operateMan = "";// 操作员
    protected String operationMan = "";// 业务员名称
    protected String followRemark = "";// 跟单备注
    protected String shipperRemark = "";// 托运单备注
    protected String incomeRemark = "";// 应收备注
    protected String payoutRemark = "";// 应付备注
    protected String truckRemark = "";// 车辆备注
    protected String companyRemark = "";// 公司备注
    protected String composeId = "";// 配货编号
    protected String waybillNo = "";// 托运单号
    protected String consignBillPlace = "";// 寄单点
    protected String insideNo = "";// 内部编号
    protected String connectTime = "";// 交接单时间
    protected int isPrint = 0;// 打印状态
    protected String driverRemark = "";// 司机回馈(微信报柜)
    protected int isChecked = 0;// 箱号1是否校验(0:未校验;1:未进港;2:未匹配;3:校验成功)
    protected int isCheckedTwo = 0;// 箱号2是否校验(0:未校验;1:未进港;2:未匹配;3:校验成功)
    protected int messageState = 0;// 无纸化报柜状态(0:未报柜;1:已报柜)
    protected double conWeight = 0;// 柜重
    protected int isConfirmTruck = 0;// 是否确认派车(0:未确认;1:已确认)
    protected String hcbbRemark = "";// 海沧报备备注
    protected String hcbbUpdateTime = "";// 报备修改时间
    protected int conType = 0;// 集装箱类型
    protected String conTypeName = "";// 集装箱类型名称
    protected String whiteCardNo = "";// 白卡号
    protected String expandField = "";// 扩展字段（有简单基础资料）
    protected int isInvoicePrint = 0;// 发票打印状态
    protected int isArrival = 0;// 是否发运抵(0:否;1:是)
    protected String returnBillRemark = "";// 回单备注
    protected int isCompose = 0;// 是否存在带货(0:不存在;大于0存在)
    protected String auditMan = "";// 审核人
    protected String auditTime = "";// 审核时间
    protected double oilPrice = 0;// 油价
    protected String consignUnit = "";// 收货单位
    protected String consignTelephone = "";// 收货电话
    protected String consignAddress = "";// 收货地址
    protected String insuranceNum = "";// 保险单号
    protected String shippingTerms = "";// 运输条款
    protected String deliveryDate = "";// 送货日期
    protected String bookingDate = "";// 订舱日期
    protected int isDeductGoods = 0;// 是否扣货(0:否,1:是)
    protected String deductGoodsTime = "";// 扣货时间
    protected String consignPlace = "";// 收货地点
    protected String consignContact = "";// 收货联系人
    protected String etcRemark = "";// ETC备注
    protected int isPutGoods = 0;// 是否放货(0:否,1:是)
    protected String putGoodsTime = "";// 放货时间
    protected String waybillTime = "";// 运单时间
    protected String deliverFirstId = "";// 转柜首单单号
    protected String deliverParentId = "";// 转柜主单单号
    protected String deliverChildId = "";// 转柜从单单号
    protected int isInsure = 0;// 是否投保(0:否,1:是)
    protected String insureTime = "";// 投保时间
    protected String shipShippingTerms = "";// 船公司条款
    protected String arrivePortTime = "";// 到港时间YYYY-MM-DD
    protected String containerCheckBillTime = "";// 核单时间(按票)YYYY-MM-DD HH:mm:ss
    protected String confirmOrderTime = "";// 确认接单时间(APP上确认)
    protected String conState = "";// 箱状态

    // 提还柜信息
    protected String bookingNo = "";// 订舱号
    protected String getConPile = "";// 提柜堆场
    protected String getConPlace = "";// 提柜地点
    protected String returnConPile = "";// 还柜堆场
    protected String returnConPlace = "";// 还柜地点
    protected String containerNo = "";// 柜号
    protected String sealNo = "";// 封条号
    protected int isDoubleCon = 1;// 是否孖托(1:单柜;2:孖拖;)
    protected String containerType = "";// 柜型
    protected String otherBookingNo = "";// 订舱号2
    protected String otherContainerNo = "";// 柜号2
    protected String otherSealNo = "";// 封条号2
    protected String returnTime = "";// 还柜时间
    protected String customerGetConPile = "";// 客户提柜堆场
    protected String customerGetConPlace = "";// 客户提柜地点
    protected String customerReturnConPile = "";// 客户还柜堆场
    protected String customerReturnConPlace = "";// 客户还柜地点
    protected String factBookingNo = "";// 实际提单号

    // 工厂信息
    protected String arriveTime = "";// 到厂时间
    protected String leaveTime = "";// 离厂时间

    // 车辆信息
    protected int truckId = 0;// 车牌号, 引用(base_truck.id)
    protected String truck = "";// 车牌号
    protected int transportTeamId = 0;// 车队,引用(base_transport_team.id)
    protected String transportTeam = "";// 车队
    protected int driverId = 0;// 司机,引用(base_driver.id)
    protected String driver = "";// 司机
    protected String mobilePhone = "";// 司机手机
    protected int truckShelfId = 0;// 拖架号,引用(base_transport_shelf.id)
    protected String truckShelf = "";// 拖架号
    protected double kilometres = 0;// 公里数
    protected double standConsume = 0;// 标准油耗
    protected double realConsume = 0;// 实际油耗
    protected int manageMode = 0;// 经营方式
    protected double wastageOilKm = 0;// 百公里油耗
    protected String icNo = "";// IC卡号
    protected String customsNo = "";// 海关编号
    protected String checkpointNo = "";// 通关卡号
    protected String lockNo = "";// 电子关锁号
    protected String shelfModel = "";// 托架型号
    protected double shelfWeight = 0.00;// 托架重量
    protected String identityCard = "";// 司机身份证
    protected double truckWeight = 0.00;// 车头重量
    protected String cusPassword = "";// 海关密码
    protected double driverCost = 0;// 司机产值
    protected int returnTruckId = 0;// 还柜车牌号ID
    protected String returnTruck = "";// 还柜车牌号
    protected int returnTransportTeamId = 0;// 还柜车队ID
    protected String returnTransportTeam = "";// 还柜车队
    protected int returnDriverId = 0;// 还柜司机ID
    protected String returnDriver = "";// 还柜司机名称
    protected String returnDriverMobilePhone = "";// 还柜司机手机
    protected String truckCompany = "";// 牌头公司
    protected String truckCompanyAddress = "";// 牌头公司地址
    protected String transportTeamTelephone = "";//车队联系电话
    protected double deductCost = 0;// 扣除产值

    // 船信息
    protected int lineId = 0;// 船公司编号
    protected String line = "";// 船公司
    protected String ship = "";// 船名
    protected String voyage = "";// 航次
    protected String endCustoms = "";// 指运地海关
    protected String startCustoms = "";// 起运地海关
    protected String customs = "";// 报关行
    protected String openCabinTime = "";// 开仓时间
    protected String greenLightTime = "";// 放行时间
    protected int isSupply = 0;// 补料预警
    protected String supplyTime = "";// 补料时间
    protected String endPort = "";// 目的港
    protected String supplyConPile = "";// 补料堆场
    protected String delivery = "";// 交货地
    protected String discharge = "";// 卸货港
    protected String port = "";// 港区
    protected String startHarborTime = "";// 开港时间
    protected String endHarborTime = "";// 截港时间
    protected String sailingDate = "";// 船期
    protected String inPortTime = "";// 进港时间
    protected String checkNo = "";// 动检编号
    protected String grade = "";// 危险品等级
    protected String unCode = "";// 联合国编号
    protected String temperature = "";// 温度
    protected int isFerry = 0;// 是否渡柜(0:否;1:是)
    protected String togetherId = "";// 拼箱编号
    protected String berthingTime = "";// 靠泊时间
    protected String collectHarborTime = "";// 集港时间
    protected String factShip = "";// 实际船名
    protected String factVoyage = "";// 实际航次
    protected String lineProxyMan = "";// 船公司换单人
    protected String doubleConId = "";// 做废的双拖busiid
    protected int oilOrGas = 0;// 加油或加气(0:加油,1:加气)
    protected String conBelongLine = "";// 箱属船公司

    // 货物信息
    protected String goodsName = "";// 货名
    protected double weight = 0.0;// 毛重
    protected double cubage = 0;// 体积
    protected int piece = 0;// 件数
    protected double price = 0.00;// 单价
    protected double payPrice = 0.00;// 应付单价
    protected int measureType = 0;// 计量方式(1:重量;2:件数;3:体积)
    protected List<Object> datas = new ArrayList<Object>();// 列表数据集
    protected List<Object> datasMark = new ArrayList<Object>();// 列表数据标记集
    List<Integer> sumTotalList = new ArrayList<Integer>();// 需统计小计的费用列数组
    protected String goodsModel = "";// 货物规格型号
    protected String goodsPackaging = "";// 货物包装
    protected String goodsDepositType = "";// 货物存放方式
    protected String goodsRemark = "";// 货物备注
    protected String detailPiece = "";//件数详细
    protected String detailWeight = "";//毛重详细
    protected double specialConsume = 0.0;//特殊油耗

    // 费用信息
    protected double money = 0;// 小计
    protected double truckProfitMoney = 0;// 车辆利润金额
    protected double writeOffMoney = 0;// 已核销金额
    protected double balanceMoney = 0.0;// 未核销金额
    protected double feeMoney = 0;// 运输费用小计
    protected double feeMoney$ = 0;// 特殊费用小计
    protected double writeOffMoney$ = 0;// 运输费用已核销金额
    protected String otherFeeRemark = "";// 杂费备注(显示具体的各项费用的名字金额，除运费外)
    protected double cashBack = 0;// 代收款返款金额
    protected boolean isHasCashBack = false;// 是否存在代收款

    // 其他信息
    protected String incomeAccountNo = "";// 应收对账单号
    protected String payoutAccountNo = "";// 应付对账单号
    protected int isInvoice = 0;// 是否开票(0:否;1:是)
    protected String deputyBooking = "";// 副提单号
    protected String truckCode = "";// 车辆编号
    protected double operationManProfit = 0;// 业务员提成

    protected int commonState = 0;// 公共状态(1:进场)
    protected int nmBusiType = 0;// 内贸业务类型(0:进口,1:出口)
    protected double truckPayout = 0.0;//车辆支出
    protected String delContainerDate = "";//产生滞箱费日期

    //扩展字段
    protected String noFReturnTime = "";//没有格式化的还柜时间
    protected String noFOpenCabinTime = "";//没有格式化的开舱时间
    protected String noFLeaveTime = "";//没有格式化的离厂时间


    public String getNoFLeaveTime() {
        return noFLeaveTime;
    }

    public void setNoFLeaveTime(String noFLeaveTime) {
        if (null != noFLeaveTime) {
            this.noFLeaveTime = noFLeaveTime;
        }
    }

    public String getNoFReturnTime() {
        return noFReturnTime;
    }

    public void setNoFReturnTime(String noFReturnTime) {
        if (null != noFReturnTime) {
            this.noFReturnTime = noFReturnTime;
        }
    }

    public String getNoFOpenCabinTime() {
        return noFOpenCabinTime;
    }

    public void setNoFOpenCabinTime(String noFOpenCabinTime) {
        if (null != noFOpenCabinTime) {
            this.noFOpenCabinTime = noFOpenCabinTime;
        }
    }

    public double getSpecialConsume() {
        return specialConsume;
    }

    public void setSpecialConsume(double specialConsume) {
        this.specialConsume = specialConsume;
    }

    public String getDetailPiece() {
        return detailPiece;
    }

    public void setDetailPiece(String detailPiece) {
        if (null != detailPiece) {
            this.detailPiece = detailPiece;
        }
    }

    public String getDetailWeight() {
        return detailWeight;
    }

    public void setDetailWeight(String detailWeight) {
        if (null != detailWeight) {
            this.detailWeight = detailWeight;
        }
    }

    public String getDelContainerDate() {
        return delContainerDate;
    }

    public void setDelContainerDate(String delContainerDate) {
        if (null != delContainerDate) {
            this.delContainerDate = delContainerDate;
        }
    }

    public double getTruckPayout() {
        return truckPayout;
    }

    public void setTruckPayout(double truckPayout) {
        this.truckPayout = truckPayout;
    }

    public int getCommonState() {
        return commonState;
    }

    public void setCommonState(int commonState) {
        this.commonState = commonState;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIsOrder() {
        return isOrder;
    }

    public void setIsOrder(int isOrder) {
        this.isOrder = isOrder;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        if (stateName != null) {
            this.stateName = stateName;
        }
    }

    public int getIsSign() {
        return isSign;
    }

    public void setIsSign(int isSign) {
        this.isSign = isSign;
    }

    public int getIsLock() {
        return isLock;
    }

    public void setIsLock(int isLock) {
        this.isLock = isLock;
    }

    public int getCheckInFee() {
        return checkInFee;
    }

    public void setCheckInFee(int checkInFee) {
        this.checkInFee = checkInFee;
    }

    public int getCheckPayFee() {
        return checkPayFee;
    }

    public void setCheckPayFee(int checkPayFee) {
        this.checkPayFee = checkPayFee;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        if (invoiceNo != null) {
            this.invoiceNo = invoiceNo;
        }
    }

    public int getFxState() {
        return fxState;
    }

    public void setFxState(int fxState) {
        this.fxState = fxState;
    }

    public String getBusiDate() {
        return busiDate;
    }

    public void setBusiDate(String busiDate) {
        if (busiDate != null) {
            this.busiDate = busiDate;
        }
    }

    public String getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(String appointDate) {
        if (appointDate != null) {
            this.appointDate = appointDate;
        }
    }

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        if (appointTime != null) {
            this.appointTime = appointTime;
        }
    }

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        if (timePoint != null) {
            this.timePoint = timePoint;
            if (!StringManage.isEmpty(timePoint)) {
                this.timePoint = " " + timePoint;
            }
        }
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (customerName != null) {
            this.customerName = customerName;
        }
    }

    public String getCustomerJobNo() {
        return customerJobNo;
    }

    public void setCustomerJobNo(String customerJobNo) {
        if (customerJobNo != null) {
            this.customerJobNo = customerJobNo;
        }
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        if (customerContact != null) {
            this.customerContact = customerContact;
        }
    }

    public String getCustomsMode() {
        return customsMode;
    }

    public void setCustomsMode(String customsMode) {
        if (customsMode != null) {
            this.customsMode = customsMode;
        }
    }

    public int getIsAdvance() {
        return isAdvance;
    }

    public void setIsAdvance(int isAdvance) {
        this.isAdvance = isAdvance;
    }

    public String getCutOffTime() {
        return cutOffTime;
    }

    public void setCutOffTime(String cutOffTime) {
        if (cutOffTime != null) {
            this.cutOffTime = cutOffTime;
        }
    }

    public String getCutWeightTime() {
        return cutWeightTime;
    }

    public void setCutWeightTime(String cutWeightTime) {
        if (cutWeightTime != null) {
            this.cutWeightTime = cutWeightTime;
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (departmentName != null) {
            this.departmentName = departmentName;
        }
    }

    public String getFollowMan() {
        return followMan;
    }

    public void setFollowMan(String followMan) {
        this.followMan = followMan;
    }

    public String getOperateMan() {
        return operateMan;
    }

    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
    }

    public String getOperationMan() {
        return operationMan;
    }

    public void setOperationMan(String operationMan) {
        this.operationMan = operationMan;
    }

    public String getFollowRemark() {
        return followRemark;
    }

    public void setFollowRemark(String followRemark) {
        if (followRemark != null) {
            this.followRemark = followRemark;
        }
    }

    public String getShipperRemark() {
        return shipperRemark;
    }

    public void setShipperRemark(String shipperRemark) {
        if (shipperRemark != null) {
            this.shipperRemark = shipperRemark;
        }
    }

    public String getIncomeRemark() {
        return incomeRemark;
    }

    public void setIncomeRemark(String incomeRemark) {
        if (incomeRemark != null) {
            this.incomeRemark = incomeRemark;
        }
    }

    public String getPayoutRemark() {
        return payoutRemark;
    }

    public void setPayoutRemark(String payoutRemark) {
        if (payoutRemark != null) {
            this.payoutRemark = payoutRemark;
        }
    }

    public String getTruckRemark() {
        return truckRemark;
    }

    public void setTruckRemark(String truckRemark) {
        if (truckRemark != null) {
            this.truckRemark = truckRemark;
        }
    }

    public String getCompanyRemark() {
        return companyRemark;
    }

    public void setCompanyRemark(String companyRemark) {
        if (companyRemark != null) {
            this.companyRemark = companyRemark;
        }
    }

    public String getComposeId() {
        return composeId;
    }

    public void setComposeId(String composeId) {
        if (composeId != null) {
            this.composeId = composeId;
        }
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        if (waybillNo != null) {
            this.waybillNo = waybillNo;
        }
    }

    public int getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(int isPrint) {
        this.isPrint = isPrint;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        if (bookingNo != null) {
            this.bookingNo = bookingNo;
        }
    }

    public String getGetConPile() {
        return getConPile;
    }

    public void setGetConPile(String getConPile) {
        if (getConPile != null) {
            this.getConPile = getConPile;
        }
    }

    public String getGetConPlace() {
        return getConPlace;
    }

    public void setGetConPlace(String getConPlace) {
        if (getConPlace != null) {
            this.getConPlace = getConPlace;
        }
    }

    public String getReturnConPile() {
        return returnConPile;
    }

    public void setReturnConPile(String returnConPile) {
        if (returnConPile != null) {
            this.returnConPile = returnConPile;
        }
    }

    public String getReturnConPlace() {
        return returnConPlace;
    }

    public void setReturnConPlace(String returnConPlace) {
        if (returnConPlace != null) {
            this.returnConPlace = returnConPlace;
        }
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(String containerNo) {
        if (containerNo != null) {
            this.containerNo = containerNo;
        }
    }

    public String getSealNo() {
        return sealNo;
    }

    public void setSealNo(String sealNo) {
        if (sealNo != null) {
            this.sealNo = sealNo;
        }
    }

    public int getIsDoubleCon() {
        return isDoubleCon;
    }

    public void setIsDoubleCon(int isDoubleCon) {
        this.isDoubleCon = isDoubleCon;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        if (containerType != null) {
            this.containerType = containerType;
        }
    }

    public String getOtherBookingNo() {
        return otherBookingNo;
    }

    public void setOtherBookingNo(String otherBookingNo) {
        if (otherBookingNo != null) {
            this.otherBookingNo = otherBookingNo;
        }
    }

    public String getOtherContainerNo() {
        return otherContainerNo;
    }

    public void setOtherContainerNo(String otherContainerNo) {
        if (otherContainerNo != null) {
            this.otherContainerNo = otherContainerNo;
        }
    }

    public String getOtherSealNo() {
        return otherSealNo;
    }

    public void setOtherSealNo(String otherSealNo) {
        if (otherSealNo != null) {
            this.otherSealNo = otherSealNo;
        }
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        if (returnTime != null) {
            this.returnTime = returnTime;
        }
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        if (arriveTime != null) {
            this.arriveTime = arriveTime;
        }
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        if (leaveTime != null) {
            this.leaveTime = leaveTime;
        }
    }

    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        if (truck != null) {
            this.truck = truck;
        }
    }

    public int getTransportTeamId() {
        return transportTeamId;
    }

    public void setTransportTeamId(int transportTeamId) {
        this.transportTeamId = transportTeamId;
    }

    public String getTransportTeam() {
        return transportTeam;
    }

    public void setTransportTeam(String transportTeam) {
        if (transportTeam != null) {
            this.transportTeam = transportTeam;
        }
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        if (driver != null) {
            this.driver = driver;
        }
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        if (mobilePhone != null) {
            this.mobilePhone = mobilePhone;
        }
    }

    public int getTruckShelfId() {
        return truckShelfId;
    }

    public void setTruckShelfId(int truckShelfId) {
        this.truckShelfId = truckShelfId;
    }

    public String getTruckShelf() {
        return truckShelf;
    }

    public void setTruckShelf(String truckShelf) {
        if (truckShelf != null) {
            this.truckShelf = truckShelf;
        }
    }

    public int getManageMode() {
        return manageMode;
    }

    public void setManageMode(int manageMode) {
        this.manageMode = manageMode;
    }

    public double getKilometres() {
        return kilometres;
    }

    public void setKilometres(double kilometres) {
        this.kilometres = kilometres;
    }

    public double getStandConsume() {
        return standConsume;
    }

    public void setStandConsume(double standConsume) {
        this.standConsume = standConsume;
    }

    public double getRealConsume() {
        return realConsume;
    }

    public void setRealConsume(double realConsume) {
        this.realConsume = realConsume;
    }

    public double getWastageOilKm() {
        return wastageOilKm;
    }

    public void setWastageOilKm(double wastageOilKm) {
        this.wastageOilKm = wastageOilKm;
    }

    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        if (icNo != null) {
            this.icNo = icNo;
        }
    }

    public String getCustomsNo() {
        return customsNo;
    }

    public void setCustomsNo(String customsNo) {
        if (customsNo != null) {
            this.customsNo = customsNo;
        }
    }

    public String getCheckpointNo() {
        return checkpointNo;
    }

    public void setCheckpointNo(String checkpointNo) {
        if (checkpointNo != null) {
            this.checkpointNo = checkpointNo;
        }
    }

    public String getLockNo() {
        return lockNo;
    }

    public void setLockNo(String lockNo) {
        if (lockNo != null) {
            this.lockNo = lockNo;
        }
    }

    public String getShelfModel() {
        return shelfModel;
    }

    public void setShelfModel(String shelfModel) {
        if (shelfModel != null) {
            this.shelfModel = shelfModel;
        }
    }

    public double getShelfWeight() {
        return shelfWeight;
    }

    public void setShelfWeight(double shelfWeight) {
        this.shelfWeight = shelfWeight;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        if (identityCard != null) {
            this.identityCard = identityCard;
        }
    }

    public double getTruckWeight() {
        return truckWeight;
    }

    public void setTruckWeight(double truckWeight) {
        this.truckWeight = truckWeight;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public void setCusPassword(String cusPassword) {
        if (cusPassword != null) {
            this.cusPassword = cusPassword;
        }
    }

    public double getDriverCost() {
        return driverCost;
    }

    public void setDriverCost(double driverCost) {
        this.driverCost = driverCost;
    }

    public int getReturnTruckId() {
        return returnTruckId;
    }

    public void setReturnTruckId(int returnTruckId) {
        this.returnTruckId = returnTruckId;
    }

    public String getReturnTruck() {
        return returnTruck;
    }

    public void setReturnTruck(String returnTruck) {
        if (returnTruck != null) {
            this.returnTruck = returnTruck;
        }
    }

    public int getReturnTransportTeamId() {
        return returnTransportTeamId;
    }

    public void setReturnTransportTeamId(int returnTransportTeamId) {
        this.returnTransportTeamId = returnTransportTeamId;
    }

    public String getReturnTransportTeam() {
        return returnTransportTeam;
    }

    public void setReturnTransportTeam(String returnTransportTeam) {
        if (returnTransportTeam != null) {
            this.returnTransportTeam = returnTransportTeam;
        }
    }

    public int getReturnDriverId() {
        return returnDriverId;
    }

    public void setReturnDriverId(int returnDriverId) {
        this.returnDriverId = returnDriverId;
    }

    public String getReturnDriver() {
        return returnDriver;
    }

    public void setReturnDriver(String returnDriver) {
        if (returnDriver != null) {
            this.returnDriver = returnDriver;
        }
    }

    public String getReturnDriverMobilePhone() {
        return returnDriverMobilePhone;
    }

    public void setReturnDriverMobilePhone(String returnDriverMobilePhone) {
        if (returnDriverMobilePhone != null) {
            this.returnDriverMobilePhone = returnDriverMobilePhone;
        }
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        if (line != null) {
            this.line = line;
        }
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        if (ship != null) {
            this.ship = ship;
        }
    }

    public String getVoyage() {
        return voyage;
    }

    public void setVoyage(String voyage) {
        if (voyage != null) {
            this.voyage = voyage;
        }
    }

    public String getEndCustoms() {
        return endCustoms;
    }

    public void setEndCustoms(String endCustoms) {
        if (endCustoms != null) {
            this.endCustoms = endCustoms;
        }
    }

    public String getStartCustoms() {
        return startCustoms;
    }

    public void setStartCustoms(String startCustoms) {
        if (startCustoms != null) {
            this.startCustoms = startCustoms;
        }
    }

    public String getSupplyConPile() {
        return supplyConPile;
    }

    public void setSupplyConPile(String supplyConPile) {
        if (supplyConPile != null) {
            this.supplyConPile = supplyConPile;
        }
    }

    public String getCustoms() {
        return customs;
    }

    public void setCustoms(String customs) {
        if (customs != null) {
            this.customs = customs;
        }
    }

    public String getOpenCabinTime() {
        return openCabinTime;
    }

    public void setOpenCabinTime(String openCabinTime) {
        if (openCabinTime != null) {
            this.openCabinTime = openCabinTime;
        }
    }

    public String getGreenLightTime() {
        return greenLightTime;
    }

    public void setGreenLightTime(String greenLightTime) {
        if (greenLightTime != null) {
            this.greenLightTime = greenLightTime;
        }
    }

    public int getIsSupply() {
        return isSupply;
    }

    public void setIsSupply(int isSupply) {
        this.isSupply = isSupply;
    }

    public String getSupplyTime() {
        return supplyTime;
    }

    public void setSupplyTime(String supplyTime) {
        if (supplyTime != null) {
            this.supplyTime = supplyTime;
        }
    }

    public String getEndPort() {
        return endPort;
    }

    public void setEndPort(String endPort) {
        if (endPort != null) {
            this.endPort = endPort;
        }
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        if (goodsName != null) {
            this.goodsName = goodsName;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCubage() {
        return cubage;
    }

    public void setCubage(double cubage) {
        this.cubage = cubage;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public String getConsignBillPlace() {
        return consignBillPlace;
    }

    public void setConsignBillPlace(String consignBillPlace) {
        if (consignBillPlace != null) {
            this.consignBillPlace = consignBillPlace;
        }
    }

    public String getInsideNo() {
        return insideNo;
    }

    public void setInsideNo(String insideNo) {
        if (insideNo != null) {
            this.insideNo = insideNo;
        }
    }

    public String getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(String connectTime) {
        if (connectTime != null) {
            this.connectTime = connectTime;
        }
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        if (delivery != null) {
            this.delivery = delivery;
        }
    }

    public String getDischarge() {
        return discharge;
    }

    public void setDischarge(String discharge) {
        if (discharge != null) {
            this.discharge = discharge;
        }
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        if (port != null) {
            this.port = port;
        }
    }

    public String getStartHarborTime() {
        return startHarborTime;
    }

    public void setStartHarborTime(String startHarborTime) {
        if (startHarborTime != null) {
            this.startHarborTime = startHarborTime;
        }
    }

    public String getEndHarborTime() {
        return endHarborTime;
    }

    public void setEndHarborTime(String endHarborTime) {
        if (endHarborTime != null) {
            this.endHarborTime = endHarborTime;
        }
    }

    public String getSailingDate() {
        return sailingDate;
    }

    public void setSailingDate(String sailingDate) {
        if (sailingDate != null) {
            this.sailingDate = sailingDate;
        }
    }

    public String getInPortTime() {
        return inPortTime;
    }

    public void setInPortTime(String inPortTime) {
        if (inPortTime != null) {
            this.inPortTime = inPortTime;
        }
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        if (checkNo != null) {
            this.checkNo = checkNo;
        }
    }

    public int getIsFerry() {
        return isFerry;
    }

    public void setIsFerry(int isFerry) {
        this.isFerry = isFerry;
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        if (datas != null) {
            this.datas = datas;
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getTruckProfitMoney() {
        return truckProfitMoney;
    }

    public void setTruckProfitMoney(double truckProfitMoney) {
        this.truckProfitMoney = truckProfitMoney;
    }

    public double getWriteOffMoney() {
        return writeOffMoney;
    }

    public void setWriteOffMoney(double writeOffMoney) {
        this.writeOffMoney = writeOffMoney;
    }

    public double getBalanceMoney() {
        return balanceMoney;
    }

    public void setBalanceMoney(double balanceMoney) {
        this.balanceMoney = balanceMoney;
    }

    public double getFeeMoney() {
        return feeMoney;
    }

    public void setFeeMoney(double feeMoney) {
        this.feeMoney = feeMoney;
    }

    public double getFeeMoney$() {
        return feeMoney$;
    }

    public void setFeeMoney$(double feeMoney$) {
        this.feeMoney$ = feeMoney$;
    }

    public double getWriteOffMoney$() {
        return writeOffMoney$;
    }

    public void setWriteOffMoney$(double writeOffMoney$) {
        this.writeOffMoney$ = writeOffMoney$;
    }

    public String getTruckCompany() {
        return truckCompany;
    }

    public void setTruckCompany(String truckCompany) {
        if (truckCompany != null) {
            this.truckCompany = truckCompany;
        }
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        if (grade != null) {
            this.grade = grade;
        }
    }

    public String getUnCode() {
        return unCode;
    }

    public void setUnCode(String unCode) {
        if (unCode != null) {
            this.unCode = unCode;
        }
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        if (temperature != null) {
            this.temperature = temperature;
        }
    }

    public String getTruckCompanyAddress() {
        return truckCompanyAddress;
    }

    public void setTruckCompanyAddress(String truckCompanyAddress) {
        if (truckCompanyAddress != null) {
            this.truckCompanyAddress = truckCompanyAddress;
        }
    }

    public String getDriverRemark() {
        return driverRemark;
    }

    public void setDriverRemark(String driverRemark) {
        if (driverRemark != null) {
            this.driverRemark = driverRemark;
        }
    }

    public String getOtherFeeRemark() {
        return otherFeeRemark;
    }

    public void setOtherFeeRemark(String otherFeeRemark) {
        if (otherFeeRemark != null) {
            this.otherFeeRemark = otherFeeRemark;
        }
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public int getIsCheckedTwo() {
        return isCheckedTwo;
    }

    public void setIsCheckedTwo(int isCheckedTwo) {
        this.isCheckedTwo = isCheckedTwo;
    }

    public int getMessageState() {
        return messageState;
    }

    public void setMessageState(int messageState) {
        this.messageState = messageState;
    }

    public double getConWeight() {
        return conWeight;
    }

    public void setConWeight(double conWeight) {
        this.conWeight = conWeight;
    }

    public int getIsConfirmTruck() {
        return isConfirmTruck;
    }

    public void setIsConfirmTruck(int isConfirmTruck) {
        this.isConfirmTruck = isConfirmTruck;
    }

    public String getCustomerGetConPile() {
        return customerGetConPile;
    }

    public void setCustomerGetConPile(String customerGetConPile) {
        if (customerGetConPile != null) {
            this.customerGetConPile = customerGetConPile;
        }
    }

    public String getCustomerGetConPlace() {
        return customerGetConPlace;
    }

    public void setCustomerGetConPlace(String customerGetConPlace) {
        if (customerGetConPlace != null) {
            this.customerGetConPlace = customerGetConPlace;
        }
    }

    public String getCustomerReturnConPile() {
        return customerReturnConPile;
    }

    public void setCustomerReturnConPile(String customerReturnConPile) {
        if (customerReturnConPile != null) {
            this.customerReturnConPile = customerReturnConPile;
        }
    }

    public String getCustomerReturnConPlace() {
        return customerReturnConPlace;
    }

    public void setCustomerReturnConPlace(String customerReturnConPlace) {
        if (customerReturnConPlace != null) {
            this.customerReturnConPlace = customerReturnConPlace;
        }
    }

    public String getIncomeAccountNo() {
        return incomeAccountNo;
    }

    public void setIncomeAccountNo(String incomeAccountNo) {
        if (incomeAccountNo != null) {
            this.incomeAccountNo = incomeAccountNo;
        }
    }

    public String getPayoutAccountNo() {
        return payoutAccountNo;
    }

    public void setPayoutAccountNo(String payoutAccountNo) {
        if (payoutAccountNo != null) {
            this.payoutAccountNo = payoutAccountNo;
        }
    }

    public String getTogetherId() {
        return togetherId;
    }

    public void setTogetherId(String togetherId) {
        if (togetherId != null) {
            this.togetherId = togetherId;
        }
    }

    public int getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(int isInvoice) {
        this.isInvoice = isInvoice;
    }

    public String getHcbbRemark() {
        return hcbbRemark;
    }

    public void setHcbbRemark(String hcbbRemark) {
        if (hcbbRemark != null) {
            this.hcbbRemark = hcbbRemark;
        }
    }

    public String getHcbbUpdateTime() {
        return hcbbUpdateTime;
    }

    public int getConType() {
        return conType;
    }

    public void setConType(int conType) {
        this.conType = conType;
    }

    public String getConTypeName() {
        return conTypeName;
    }

    public void setConTypeName(String conTypeName) {
        this.conTypeName = conTypeName;
    }

    public void setHcbbUpdateTime(String hcbbUpdateTime) {
        if (hcbbUpdateTime != null) {
            this.hcbbUpdateTime = hcbbUpdateTime;
        }
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        if (createTime != null) {
            this.createTime = createTime;
        }
    }

    public String getDeputyBooking() {
        return deputyBooking;
    }

    public void setDeputyBooking(String deputyBooking) {
        if (deputyBooking != null) {
            this.deputyBooking = deputyBooking;
        }
    }

    public String getWhiteCardNo() {
        return whiteCardNo;
    }

    public void setWhiteCardNo(String whiteCardNo) {
        if (whiteCardNo != null) {
            this.whiteCardNo = whiteCardNo;
        }
    }

    public String getTruckCode() {
        return truckCode;
    }

    public void setTruckCode(String truckCode) {
        if (truckCode != null) {
            this.truckCode = truckCode;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMeasureType() {
        return measureType;
    }

    public void setMeasureType(int measureType) {
        this.measureType = measureType;
    }

    public String getExpandField() {
        return expandField;
    }

    public void setExpandField(String expandField) {
        if (expandField != null) {
            this.expandField = expandField;
        }
    }

    public int getIsInvoicePrint() {
        return isInvoicePrint;
    }

    public void setIsInvoicePrint(int isInvoicePrint) {
        this.isInvoicePrint = isInvoicePrint;
    }

    public int getIsArrival() {
        return isArrival;
    }

    public void setIsArrival(int isArrival) {
        this.isArrival = isArrival;
    }

    public String getFactBookingNo() {
        return factBookingNo;
    }

    public void setFactBookingNo(String factBookingNo) {
        if (factBookingNo != null) {
            this.factBookingNo = factBookingNo;
        }
    }

    public String getBerthingTime() {
        return berthingTime;
    }

    public void setBerthingTime(String berthingTime) {
        if (berthingTime != null) {
            this.berthingTime = berthingTime;
        }
    }

    public String getCollectHarborTime() {
        return collectHarborTime;
    }

    public void setCollectHarborTime(String collectHarborTime) {
        if (collectHarborTime != null) {
            this.collectHarborTime = collectHarborTime;
        }
    }

    public String getFactShip() {
        return factShip;
    }

    public void setFactShip(String factShip) {
        if (factShip != null) {
            this.factShip = factShip;
        }
    }

    public String getFactVoyage() {
        return factVoyage;
    }

    public void setFactVoyage(String factVoyage) {
        if (factVoyage != null) {
            this.factVoyage = factVoyage;
        }
    }

    public String getLineProxyMan() {
        return lineProxyMan;
    }

    public void setLineProxyMan(String lineProxyMan) {
        if (lineProxyMan != null) {
            this.lineProxyMan = lineProxyMan;
        }
    }

    public String getReturnBillRemark() {
        return returnBillRemark;
    }

    public void setReturnBillRemark(String returnBillRemark) {
        if (returnBillRemark != null) {
            this.returnBillRemark = returnBillRemark;
        }
    }

    public String getCheckBillTime() {
        return checkBillTime;
    }

    public void setCheckBillTime(String checkBillTime) {
        if (checkBillTime != null) {
            this.checkBillTime = checkBillTime;
        }
    }

    public double getOperationManProfit() {
        return operationManProfit;
    }

    public void setOperationManProfit(double operationManProfit) {
        this.operationManProfit = operationManProfit;
    }

    public double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(double payPrice) {
        this.payPrice = payPrice;
    }

    public int getIsCompose() {
        return isCompose;
    }

    public void setIsCompose(int isCompose) {
        this.isCompose = isCompose;
    }

    public String getAuditMan() {
        return auditMan;
    }

    public void setAuditMan(String auditMan) {
        if (auditMan != null) {
            this.auditMan = auditMan;
        }
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        if (auditTime != null) {
            this.auditTime = auditTime;
        }
    }

    public double getOilPrice() {
        return oilPrice;
    }

    public void setOilPrice(double oilPrice) {
        this.oilPrice = oilPrice;
    }

    public String getDoubleConId() {
        return doubleConId;
    }

    public void setDoubleConId(String doubleConId) {
        if (doubleConId != null) {
            this.doubleConId = doubleConId;
        }
    }

    public int getOilOrGas() {
        return oilOrGas;
    }

    public void setOilOrGas(int oilOrGas) {
        this.oilOrGas = oilOrGas;
    }

    public String getConsignUnit() {
        return consignUnit;
    }

    public void setConsignUnit(String consignUnit) {
        if (consignUnit != null) {
            this.consignUnit = consignUnit;
        }
    }

    public String getConsignTelephone() {
        return consignTelephone;
    }

    public void setConsignTelephone(String consignTelephone) {
        if (consignTelephone != null) {
            this.consignTelephone = consignTelephone;
        }
    }

    public String getConsignAddress() {
        return consignAddress;
    }

    public void setConsignAddress(String consignAddress) {
        if (consignAddress != null) {
            this.consignAddress = consignAddress;
        }
    }

    public String getInsuranceNum() {
        return insuranceNum;
    }

    public void setInsuranceNum(String insuranceNum) {
        if (insuranceNum != null) {
            this.insuranceNum = insuranceNum;
        }
    }

    public String getShippingTerms() {
        return shippingTerms;
    }

    public void setShippingTerms(String shippingTerms) {
        if (shippingTerms != null) {
            this.shippingTerms = shippingTerms;
        }
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        if (deliveryDate != null) {
            this.deliveryDate = deliveryDate;
        }
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        if (bookingDate != null) {
            this.bookingDate = bookingDate;
        }
    }

    public int getNmBusiType() {
        return nmBusiType;
    }

    public void setNmBusiType(int nmBusiType) {
        this.nmBusiType = nmBusiType;
    }

    public int getIsDeductGoods() {
        return isDeductGoods;
    }

    public void setIsDeductGoods(int isDeductGoods) {
        this.isDeductGoods = isDeductGoods;
    }

    public String getDeductGoodsTime() {
        return deductGoodsTime;
    }

    public void setDeductGoodsTime(String deductGoodsTime) {
        if (deductGoodsTime != null) {
            this.deductGoodsTime = deductGoodsTime;
        }
    }

    public String getConsignPlace() {
        return consignPlace;
    }

    public void setConsignPlace(String consignPlace) {
        if (consignPlace != null) {
            this.consignPlace = consignPlace;
        }
    }

    public String getConsignContact() {
        return consignContact;
    }

    public void setConsignContact(String consignContact) {
        if (consignContact != null) {
            this.consignContact = consignContact;
        }
    }

    public String getEtcRemark() {
        return etcRemark;
    }

    public void setEtcRemark(String etcRemark) {
        if (etcRemark != null) {
            this.etcRemark = etcRemark;
        }
    }


    public String getConBelongLine() {
        return conBelongLine;
    }

    public void setConBelongLine(String conBelongLine) {
        if (conBelongLine != null) {
            this.conBelongLine = conBelongLine;
        }
    }

    public int getIsPutGoods() {
        return isPutGoods;
    }

    public void setIsPutGoods(int isPutGoods) {
        this.isPutGoods = isPutGoods;
    }

    public String getPutGoodsTime() {
        return putGoodsTime;
    }

    public void setPutGoodsTime(String putGoodsTime) {
        if (putGoodsTime != null) {
            this.putGoodsTime = putGoodsTime;
        }
    }

    public String getWaybillTime() {
        return waybillTime;
    }

    public void setWaybillTime(String waybillTime) {
        if (waybillTime != null) {
            this.waybillTime = waybillTime;
        }
    }

    public String getDeliverFirstId() {
        return deliverFirstId;
    }

    public void setDeliverFirstId(String deliverFirstId) {
        if (deliverFirstId != null) {
            this.deliverFirstId = deliverFirstId;
        }
    }

    public String getDeliverParentId() {
        return deliverParentId;
    }

    public void setDeliverParentId(String deliverParentId) {
        if (deliverParentId != null) {
            this.deliverParentId = deliverParentId;
        }
    }

    public String getDeliverChildId() {
        return deliverChildId;
    }

    public void setDeliverChildId(String deliverChildId) {
        if (deliverChildId != null) {
            this.deliverChildId = deliverChildId;
        }
    }

    public int getIsInsure() {
        return isInsure;
    }

    public void setIsInsure(int isInsure) {
        this.isInsure = isInsure;
    }

    public String getInsureTime() {
        return insureTime;
    }

    public void setInsureTime(String insureTime) {
        if (insureTime != null) {
            this.insureTime = insureTime;
        }
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        if (goodsModel != null) {
            this.goodsModel = goodsModel;
        }
    }

    public String getGoodsPackaging() {
        return goodsPackaging;
    }

    public void setGoodsPackaging(String goodsPackaging) {
        if (goodsPackaging != null) {
            this.goodsPackaging = goodsPackaging;
        }
    }

    public String getGoodsDepositType() {
        return goodsDepositType;
    }

    public void setGoodsDepositType(String goodsDepositType) {
        if (goodsDepositType != null) {
            this.goodsDepositType = goodsDepositType;
        }
    }

    public String getGoodsRemark() {
        return goodsRemark;
    }

    public void setGoodsRemark(String goodsRemark) {
        if (goodsRemark != null) {
            this.goodsRemark = goodsRemark;
        }
    }

    public double getCashBack() {
        return cashBack;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public List<Object> getDatasMark() {
        return datasMark;
    }

    public void setDatasMark(List<Object> datasMark) {
        this.datasMark = datasMark;
    }

    public boolean isHasCashBack() {
        return isHasCashBack;
    }

    public void setHasCashBack(boolean isHasCashBack) {
        this.isHasCashBack = isHasCashBack;
    }


    public String getShipShippingTerms() {
        return shipShippingTerms;
    }

    public void setShipShippingTerms(String shipShippingTerms) {
        if (null != shipShippingTerms) {
            this.shipShippingTerms = shipShippingTerms;
        }
    }

    public String getArrivePortTime() {
        return arrivePortTime;
    }

    public void setArrivePortTime(String arrivePortTime) {
        if (null != arrivePortTime) {
            this.arrivePortTime = arrivePortTime;
        }
    }


    public String getContainerCheckBillTime() {
        return containerCheckBillTime;
    }

    public void setContainerCheckBillTime(String containerCheckBillTime) {
        if (null != containerCheckBillTime) {
            this.containerCheckBillTime = containerCheckBillTime;
        }
    }

    public String getConfirmOrderTime() {
        return confirmOrderTime;
    }

    public void setConfirmOrderTime(String confirmOrderTime) {
        if (confirmOrderTime != null) {
            this.confirmOrderTime = confirmOrderTime;
        }
    }

    public String getConState() {
        return conState;
    }

    public void setConState(String conState) {
        if (conState != null) {
            this.conState = conState;
        }
    }

    public String getTransportTeamTelephone() {
        return transportTeamTelephone;
    }

    public void setTransportTeamTelephone(String transportTeamTelephone) {
        if (transportTeamTelephone != null) {
            this.transportTeamTelephone = transportTeamTelephone;
        }
    }

    public double getDeductCost() {
        return deductCost;
    }

    public void setDeductCost(double deductCost) {
        this.deductCost = deductCost;
    }

    public List<Integer> getSumTotalList() {
        return sumTotalList;
    }

    public void setSumTotalList(List<Integer> sumTotalList) {
        this.sumTotalList = sumTotalList;
    }

    public void clone(ShipperOrder shipperOrder) {
        this.state = shipperOrder.state;
        this.stateName = shipperOrder.stateName;
        this.isSign = shipperOrder.isSign;
        this.isLock = shipperOrder.isLock;
        this.invoiceNo = shipperOrder.invoiceNo;
        this.busiId = shipperOrder.busiId;
        this.sequence = shipperOrder.sequence;
        this.busiDate = shipperOrder.busiDate;
        this.appointDate = shipperOrder.appointDate;
        this.appointTime = shipperOrder.appointTime;
        this.timePoint = shipperOrder.timePoint;
        this.customerId = shipperOrder.customerId;
        this.customerName = shipperOrder.customerName;
        this.customerJobNo = shipperOrder.customerJobNo;
        this.customerContact = shipperOrder.customerContact;
        this.customsMode = shipperOrder.customsMode;
        this.isAdvance = shipperOrder.isAdvance;
        this.cutOffTime = shipperOrder.cutOffTime;
        this.cutWeightTime = shipperOrder.cutWeightTime;
        this.departmentName = shipperOrder.departmentName;
        this.followMan = shipperOrder.followMan;
        this.operationMan = shipperOrder.operationMan;
        this.followRemark = shipperOrder.followRemark;
        this.shipperRemark = shipperOrder.shipperRemark;
        this.incomeRemark = shipperOrder.incomeRemark;
        this.payoutRemark = shipperOrder.payoutRemark;
        this.truckRemark = shipperOrder.truckRemark;
        this.companyRemark = shipperOrder.companyRemark;
        this.composeId = shipperOrder.composeId;
        this.bookingNo = shipperOrder.bookingNo;
        this.getConPile = shipperOrder.getConPile;
        this.getConPlace = shipperOrder.getConPlace;
        this.returnConPile = shipperOrder.returnConPile;
        this.returnConPlace = shipperOrder.returnConPlace;
        this.containerNo = shipperOrder.containerNo;
        this.sealNo = shipperOrder.sealNo;
        this.isDoubleCon = shipperOrder.isDoubleCon;
        this.containerType = shipperOrder.containerType;
        this.otherBookingNo = shipperOrder.otherBookingNo;
        this.otherContainerNo = shipperOrder.otherContainerNo;
        this.otherSealNo = shipperOrder.otherSealNo;
        this.returnTime = shipperOrder.returnTime;
        this.factoryId = shipperOrder.factoryId;
        this.factoryShortName = shipperOrder.factoryShortName;
        this.contact = shipperOrder.contact;
        this.telephone = shipperOrder.telephone;
        this.loadPlace = shipperOrder.loadPlace;
        this.address = shipperOrder.address;
        this.arriveTime = shipperOrder.arriveTime;
        this.leaveTime = shipperOrder.leaveTime;
        this.truckId = shipperOrder.truckId;
        this.truck = shipperOrder.truck;
        this.transportTeamId = shipperOrder.transportTeamId;
        this.transportTeam = shipperOrder.transportTeam;
        this.driverId = shipperOrder.driverId;
        this.driver = shipperOrder.driver;
        this.mobilePhone = shipperOrder.mobilePhone;
        this.truckShelfId = shipperOrder.truckShelfId;
        this.truckShelf = shipperOrder.truckShelf;
        this.kilometres = shipperOrder.kilometres;
        this.standConsume = shipperOrder.standConsume;
        this.realConsume = shipperOrder.realConsume;
        this.manageMode = shipperOrder.manageMode;
        this.wastageOilKm = shipperOrder.wastageOilKm;
        this.returnTruck = shipperOrder.returnTruck;
        this.returnTruckId = shipperOrder.returnTruckId;
        this.returnTransportTeam = shipperOrder.returnTransportTeam;
        this.returnTransportTeamId = shipperOrder.returnTransportTeamId;
        this.returnDriver = shipperOrder.returnDriver;
        this.returnDriverId = shipperOrder.returnDriverId;
        this.returnDriverMobilePhone = shipperOrder.returnDriverMobilePhone;
        this.line = shipperOrder.line;
        this.ship = shipperOrder.ship;
        this.voyage = shipperOrder.voyage;
        this.endCustoms = shipperOrder.endCustoms;
        this.startCustoms = shipperOrder.startCustoms;
        this.customs = shipperOrder.customs;
        this.openCabinTime = shipperOrder.openCabinTime;
        this.greenLightTime = shipperOrder.greenLightTime;
        this.isSupply = shipperOrder.isSupply;
        this.supplyTime = shipperOrder.supplyTime;
        this.endPort = shipperOrder.endPort;
        this.supplyConPile = shipperOrder.supplyConPile;
        this.goodsName = shipperOrder.goodsName;
        this.weight = shipperOrder.weight;
        this.cubage = shipperOrder.cubage;
        this.piece = shipperOrder.piece;
        this.delivery = shipperOrder.delivery;
        this.discharge = shipperOrder.discharge;
        this.port = shipperOrder.port;
        this.startHarborTime = shipperOrder.startHarborTime;
        this.endHarborTime = shipperOrder.endHarborTime;
        this.sailingDate = shipperOrder.sailingDate;
        this.inPortTime = shipperOrder.inPortTime;
        this.checkNo = shipperOrder.checkNo;
        this.insideNo = shipperOrder.insideNo;
        this.connectTime = shipperOrder.connectTime;
        this.consignBillPlace = shipperOrder.consignBillPlace;
        this.datas = shipperOrder.datas;
        this.datasMark = shipperOrder.datasMark;
        this.truckCompany = shipperOrder.truckCompany;
        this.grade = shipperOrder.grade;
        this.unCode = shipperOrder.unCode;
        this.truckCompanyAddress = shipperOrder.truckCompanyAddress;
        this.fxState = shipperOrder.fxState;
        this.driverRemark = shipperOrder.driverRemark;
        this.otherFeeRemark = shipperOrder.otherFeeRemark;
        this.isChecked = shipperOrder.isChecked;
        this.isCheckedTwo = shipperOrder.isCheckedTwo;
        this.messageState = shipperOrder.messageState;
        this.conWeight = shipperOrder.conWeight;
        this.isFerry = shipperOrder.isFerry;
        this.isConfirmTruck = shipperOrder.isConfirmTruck;
        this.customerGetConPile = shipperOrder.customerGetConPile;
        this.customerGetConPlace = shipperOrder.customerGetConPlace;
        this.customerReturnConPile = shipperOrder.customerReturnConPile;
        this.customerReturnConPlace = shipperOrder.customerReturnConPlace;
        this.incomeAccountNo = shipperOrder.incomeAccountNo;
        this.payoutAccountNo = shipperOrder.payoutAccountNo;
        this.togetherId = shipperOrder.togetherId;
        this.isInvoice = shipperOrder.isInvoice;
        this.hcbbRemark = shipperOrder.hcbbRemark;
        this.hcbbUpdateTime = shipperOrder.hcbbUpdateTime;
        this.conType = shipperOrder.conType;
        this.createTime = shipperOrder.createTime;
        this.deputyBooking = shipperOrder.deputyBooking;
        this.whiteCardNo = shipperOrder.whiteCardNo;
        this.truckCode = shipperOrder.truckCode;
        this.price = shipperOrder.price;
        this.measureType = shipperOrder.measureType;
        this.expandField = shipperOrder.expandField;
        this.waybillNo = shipperOrder.waybillNo;
        this.isInvoicePrint = shipperOrder.isInvoicePrint;
        this.isArrival = shipperOrder.isArrival;
        this.berthingTime = shipperOrder.berthingTime;
        this.collectHarborTime = shipperOrder.collectHarborTime;
        this.factBookingNo = shipperOrder.factBookingNo;
        this.factShip = shipperOrder.factShip;
        this.factVoyage = shipperOrder.factVoyage;
        this.lineProxyMan = shipperOrder.lineProxyMan;
        this.returnBillRemark = shipperOrder.returnBillRemark;
        this.checkBillTime = shipperOrder.checkBillTime;
        this.operationManProfit = shipperOrder.operationManProfit;
        this.payPrice = shipperOrder.payPrice;
        this.isCompose = shipperOrder.isCompose;
        this.auditMan = shipperOrder.auditMan;
        this.auditTime = shipperOrder.auditTime;
        this.oilPrice = shipperOrder.oilPrice;
        this.doubleConId = shipperOrder.doubleConId;
        this.oilOrGas = shipperOrder.oilOrGas;
        this.consignAddress = shipperOrder.consignAddress;
        this.consignTelephone = shipperOrder.consignTelephone;
        this.consignUnit = shipperOrder.consignUnit;
        this.shippingTerms = shipperOrder.shippingTerms;
        this.insuranceNum = shipperOrder.insuranceNum;
        this.deliveryDate = shipperOrder.deliveryDate;
        this.bookingDate = shipperOrder.bookingDate;
        this.nmBusiType = shipperOrder.nmBusiType;
        this.consignPlace = shipperOrder.consignPlace;
        this.isDeductGoods = shipperOrder.isDeductGoods;
        this.deductGoodsTime = shipperOrder.deductGoodsTime;
        this.consignContact = shipperOrder.consignContact;
        this.etcRemark = shipperOrder.etcRemark;
        this.conBelongLine = shipperOrder.conBelongLine;
        this.isPutGoods = shipperOrder.isPutGoods;
        this.putGoodsTime = shipperOrder.putGoodsTime;
        this.goodsDepositType = shipperOrder.goodsDepositType;
        this.goodsModel = shipperOrder.goodsModel;
        this.goodsPackaging = shipperOrder.goodsPackaging;
        this.goodsRemark = shipperOrder.goodsRemark;
        this.waybillTime = shipperOrder.waybillTime;
        this.cashBack = shipperOrder.cashBack;
        this.isHasCashBack = shipperOrder.isHasCashBack;
        this.isInsure = shipperOrder.isInsure;
        this.insureTime = shipperOrder.insureTime;
        this.shipShippingTerms = shipperOrder.shipShippingTerms;
        this.arrivePortTime = shipperOrder.arrivePortTime;
        this.containerCheckBillTime = shipperOrder.containerCheckBillTime;
        this.confirmOrderTime = shipperOrder.confirmOrderTime;
        this.conState = shipperOrder.conState;
        this.transportTeamTelephone = shipperOrder.transportTeamTelephone;
        this.deductCost = shipperOrder.deductCost;
    }

}