define(function(require){
	
	//定义首页model
	var indexModel = {
			nav:[{
				title:"待办事项",
				url:"engine/getToClaimList",
				icon:"icon-calendar",
				count:69
			},{
				title:"已办事项",
				url:"engine/getDoneList",
				icon:"icon-shopping-bag",
				count:89
			},{
				title:"待审事项",
				url:"engine/getToDoList",
				icon:"icon-calendar",
				count:69
			},{
				title:"关注",
				url:"",
				icon:"搁置",
				count:99
			}],
			selectedNav:1,
			dataList:[],
			pageIndex:0,
			pageSize:6,
			dataCount:0,
			viewMore:"+查看更多+"
	};
	
	return indexModel;
	
});