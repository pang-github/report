var tablerefrash ={

    refrash:function() {
    layui.use(['tableSelect', 'laydate'], function () {

        var tableSelect = layui.tableSelect;
        var laydate = layui.laydate;

        //药品名
        tableSelect.render({
            elem: '.drug0',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName0").val(data.data[0].drugName)
                $("#drugUnit0").val(data.data[0].drugUnit)
                $("#drugPrice0").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug1',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName1").val(data.data[0].drugName)
                $("#drugUnit1").val(data.data[0].drugUnit)
                $("#drugPrice1").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug2',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName2").val(data.data[0].drugName)
                $("#drugUnit2").val(data.data[0].drugUnit)
                $("#drugPrice2").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug3',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName3").val(data.data[0].drugName)
                $("#drugUnit3").val(data.data[0].drugUnit)
                $("#drugPrice3").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug4',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName4").val(data.data[0].drugName)
                $("#drugUnit4").val(data.data[0].drugUnit)
                $("#drugPrice4").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug5',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName5").val(data.data[0].drugName)
                $("#drugUnit5").val(data.data[0].drugUnit)
                $("#drugPrice5").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug6',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName6").val(data.data[0].drugName)
                $("#drugUnit6").val(data.data[0].drugUnit)
                $("#drugPrice6").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug7',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName7").val(data.data[0].drugName)
                $("#drugUnit7").val(data.data[0].drugUnit)
                $("#drugPrice7").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug8',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName8").val(data.data[0].drugName)
                $("#drugUnit8").val(data.data[0].drugUnit)
                $("#drugPrice8").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug9',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName9").val(data.data[0].drugName)
                $("#drugUnit9").val(data.data[0].drugUnit)
                $("#drugPrice9").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug10',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName10").val(data.data[0].drugName)
                $("#drugUnit10").val(data.data[0].drugUnit)
                $("#drugPrice10").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug11',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName11").val(data.data[0].drugName)
                $("#drugUnit11").val(data.data[0].drugUnit)
                $("#drugPrice11").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug12',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName12").val(data.data[0].drugName)
                $("#drugUnit12").val(data.data[0].drugUnit)
                $("#drugPrice12").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug13',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName13").val(data.data[0].drugName)
                $("#drugUnit13").val(data.data[0].drugUnit)
                $("#drugPrice13").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug14',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName14").val(data.data[0].drugName)
                $("#drugUnit14").val(data.data[0].drugUnit)
                $("#drugPrice14").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug15',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName15").val(data.data[0].drugName)
                $("#drugUnit15").val(data.data[0].drugUnit)
                $("#drugPrice15").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug16',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName16").val(data.data[0].drugName)
                $("#drugUnit16").val(data.data[0].drugUnit)
                $("#drugPrice16").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug17',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName17").val(data.data[0].drugName)
                $("#drugUnit17").val(data.data[0].drugUnit)
                $("#drugPrice17").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug18',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName18").val(data.data[0].drugName)
                $("#drugUnit18").val(data.data[0].drugUnit)
                $("#drugPrice18").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug19',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName19").val(data.data[0].drugName)
                $("#drugUnit19").val(data.data[0].drugUnit)
                $("#drugPrice19").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug20',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName20").val(data.data[0].drugName)
                $("#drugUnit20").val(data.data[0].drugUnit)
                $("#drugPrice20").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug21',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName21").val(data.data[0].drugName)
                $("#drugUnit21").val(data.data[0].drugUnit)
                $("#drugPrice21").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug22',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName22").val(data.data[0].drugName)
                $("#drugUnit22").val(data.data[0].drugUnit)
                $("#drugPrice22").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug23',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName23").val(data.data[0].drugName)
                $("#drugUnit23").val(data.data[0].drugUnit)
                $("#drugPrice23").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug24',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName24").val(data.data[0].drugName)
                $("#drugUnit24").val(data.data[0].drugUnit)
                $("#drugPrice24").val(data.data[0].upprice)
            }
        })
        //药品名
        tableSelect.render({
            elem: '.drug25',	//定义输入框input对象
            checkedKey: 'id',//表格的唯一建值，非常重要，影响到选中状态 必填
            searchKey: 'keyword',	//搜索输入框的name值 默认keyword
            searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
            table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
                url: '/admin/drug/getDrugList',
                cols: [[
                    {type: 'radio'},
                    {field: 'id', title: 'ID', hide: true,},
                    {field: 'drugNum',title: '药品编号',},
                    {field: 'drugName', title: '药品名称'},
                    {field: 'drugUnit', title: '药品单位'},
                    {field: 'upprice', title: '药品价格'},

                ]]
            },
            done: function (elem, data) {
                //选择完后的回调，包含2个返回值 elem:返回之前inpu t对象；data:表格返回的选中的数据 []
                //拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
                $("#drugName25").val(data.data[0].drugName)
                $("#drugUnit25").val(data.data[0].drugUnit)
                $("#drugPrice25").val(data.data[0].upprice)
            }
        })





    })
}

}