<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/pages/common/top-include.jsp" %>
    <script type="text/javascript" src="<c:url value='/pages/orderinfo/js/orderitem.js'/>"></script>
    <title></title>
</head>
<body>
<div class="mini-layout" style="width: 100%;height: 100%;" allowResize="false">
    <div title="north" region="north" showSplit="false" showSplitIcon="false" height="300" showHeader="false"
         style="border: none">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:30%;">
                        <a name="OrderItemAdd" class="mini-button block-button" iconCls="icon-add" onclick="PageOrderItem.funAdd()">新增</a>
                        <a name="OrderItemEdit" class="mini-button block-button hide" iconCls="icon-edit" id="edit" onclick="PageOrderItem.funModify()">修改</a>
                        <a name="OrderItemDel" class="mini-button block-button hide" iconCls="icon-remove" id="remove" onclick="PageOrderItem.funDelete()">删除</a>
                    </td>
                </tr>
            </table>
        </div>
        <div class="mini-fit">
            <div id="orderItemGrid" class="mini-datagrid" showSummaryRow="true" ondrawsummarycell="onDrawSummaryCell"
                 url="${pageContext.request.contextPath}/orderItem/query"
                 idField="id" allowResize="false"
                 pagesize="10" sizeList="[10,30,50,100]" allowAlternating="true"  sortMode="client" style="height: 100%;">
                <div property="columns">
                    <div type="indexcolumn" headerAlign="center"  width="5%">序号</div>
                    <div field="goodsName" headerAlign="center" allowSort="true">商品名称</div>
                    <div field="materialNum"  headerAlign="center" allowSort="true">物料号</div>
                    <div field="esgouNum" headerAlign="center" allowSort="true">数量</div>
                    <div field="dictName" headerAlign="center" allowSort="true">单位</div>
                    <div field="unitPrice"  headerAlign="center" allowSort="true">单价</div>
                    <div field="totalMoney"  headerAlign="center" allowSort="true" summaryType="sum">总价</div>
                </div>
            </div>
        </div>
    </div>
    <div title="center" region="center" allowResize="false" showSplit="true" showSplitIcon="false"
         allowUnselect="false" style="border:1px solid #cccccc;">

        <div id="orderItemAddForm">
            <input id="id" name="id"  class="mini-hidden" />
            <table class="form-table" border="0" cellpadding="1" cellspacing="2" style="width:100%;table-layout:fixed;">
                <tr>
                    <td class="form-label" style="text-align: right;width:16%;">商品名称：</td>
                    <td style="width:32%;">
                        <input name="goodsName" id="goodsName" class="mini-combobox" style="width:150px;"
                               url="${pageContext.request.contextPath}/goods/queryGoodsList"  idField="id" textField="goodsName"
                               onvaluechanged="PageOrderItem.onMaterialNumChanged()"
                               required="true" maxlength="100"
                               requiredErrorText="商品名称不能为空"/>
                    </td>
                    <td class="form-label" style="text-align: right;width:16%;">物料号：</td>
                    <td style="width:32%;">
                        <input name="materialNum" id="materialNum" class="mini-combobox" style="width:150px;" allowInput="true"
                               allowInput="true"  valueField="id" textField="materialNum"
                               <%--url="${pageContext.request.contextPath}/goods/queryMaterialNum"--%>
                               onvaluechanged="PageOrderItem.onPriceChanged()"
                               required="true" maxlength="19" requiredErrorText="物料号不能为空" />
                    </td>
                    </tr>
                    <tr>
                    <td class="form-label" style="text-align: right;width:16%;">采购数量：</td>
                    <td style="width:32%;">
                        <input name="esgouNum" id="esgouNum" class="mini-textbox" style="width:150px;"
                                 onvaluechanged="PageOrderItem.onPriceChangedByNum()"
                                 required="true" vtype="float;maxlength:19" requiredErrorText="数量不能为空"/>
                    </td>
                    <td class="form-label" style="text-align: right;width:16%;">单价：</td>
                    <td style="width:32%;">
                        <input name="unitPrice" id="unitPrice" class="mini-textbox" style="width:150px;"
                                required="true" vtype="float;maxlength:10" requiredErrorText="单价不能为空"/>
                    </td>
                </tr>
                <tr>
                    <td class="form-label" style="text-align: right;width:16%;">货存量：</td>
                    <td style="width:32%;">
                        <input name="storage" id="storage" class="mini-textbox" style="width:150px;"
                               required="true" vtype="float;maxlength:10" requiredErrorText="单价不能为空"/>
                    </td>
                    <td>
                        <a id="orderItemSave" class="mini-button" iconCls="icon-save" onclick="PageOrderItem.funSave()" plain="true"><label>保存</label></a>
                    </td>
                    <td>
                    <a id="orderItemReset" class="mini-button" iconCls="icon-reset" onclick="PageOrderItem.funReset()" plain="true"><label>重置</label></a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script>
    mini.parse();
    function onDrawSummaryCell(e) {
        //客户端汇总计算
        if (e.field == "totalMoney") {
            e.cellHtml = "总价: " + e.value;
        }
    }
</script>
</body>
</html>

