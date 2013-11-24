﻿; (function ($) {
    $.widget("ui.pagination", {
        options: {
        	total: 10,
		    size: 10,
		    pageNumber: 1,
		    pageList: [10,20,30,50],
		    loading: false,
            first        : false,
            previous     : "上一页",
            next         : "下一页",
            last         : false,
            startRange   : 1,
			midRange     : 3,
            endRange     : 1,
		    buttons: null,
		    showPageList: true,
		    showRefresh: true,
		
		    onSelectPage: function(pageNumber, size){},
		    onBeforeRefresh: function(pageNumber, size){},
		    onRefresh: function(pageNumber, size){},
		    onChangePagesize: function(size){}
    },
    _create: function () {
    	 this.element.append("<input type='text' name='size'/>")
    	              .append("<input type='hidden' name='start'/>");
         this.opts=this.options;
         this.opts.selectlist=$("<span class='input-append'>");
         this.opts.holder =  $("<ul></ul>");
         this.opts.pagesShowing =$([]);
         
         $.data(this.element, this.widgetName, {
					options: this.opts
		 });
        
	     this._buildToolbar(this.element);

         this._selectPage(this.element,this.opts.pageNumber);


    },

    _buildToolbar: function (target){
        target.addClass('pagination').empty();
        //设置每页显示条数
        var that=this;
        var opts=this.opts;

        
        if (opts.showPageList) {
            var selectedItem = $('<input  style="width:20px;height:18px;"/>').val(opts.pageList[0]);
			selectedItem.appendTo(this.element).spinner({
									step : 10,
									max : 50,
									min : 10,
									spin : function(event, ui) {
									opts.size=ui.value
									that._selectPage(target, opts.pageNumber);
									}
								});
            

        }

       this.opts.holder.appendTo(target);
       that._setNav(target);
       if(opts.showPageList){
	   	   var  Go =$("<span class='input-append go'></span>"),
		   goInput=$("<input  type='text' class='input-mini'>"),
		   goBtn=$("<span class='add-on'>Go</span>");
		   Go.append(goInput).append(goBtn).appendTo(target);
		   goBtn.click(function(){
		   	    var page =  parseInt(goInput.val())||opts.pageNumber;
				 var pageCount= Math.ceil(opts.total / opts.size);
		   	    page = page>pageCount?pageCount:page<0?0:page;
		   	    goInput.val(page);
				if( opts.pageNumber !=page){
					 opts.pageNumber=page;
					that._selectPage(target, opts.pageNumber);
				}
		   });  
	   }
    
	},
    _setNav:function(target){
      var opts =this.opts;
      var pageCount= Math.ceil(opts.total / opts.size);
      function writeBtn(which){
             return  opts[which] && opts[which] != false  ? 
            "<li><a class='jp-" + which + "'>" + opts[which] + "</a></li>" : "";
      }
       var i = 1, navhtml;
        navhtml = writeBtn( "first" ) + writeBtn( "previous" );
        for ( ; i <= pageCount; i++ ) {
            if ( i === 1 && opts.startRange === 0 ) {
                navhtml += "<li><span class='last'>...</span></li>";
            }
            if ( i > opts.startRange && i <= pageCount - opts.endRange ) {
                navhtml += "<li><a href='#'  pageIndex="+i+"  class='hide'>";
            } else {
                navhtml += "<li><a pageIndex="+i+">";
            }
			 navhtml += i;
            navhtml += "</a></li>";
            if ( i === opts.startRange || i === pageCount - opts.endRange ) {
                navhtml += "<li><span class='first'>...</span></li>";
            }
        }

        navhtml += writeBtn( "next" ) + writeBtn( "last" ) + "</div>";

        opts.holder.html(navhtml);

        this._bindNavHandlers(target);

    },

   _bindNavHandlers:function(target){
      var that=this;
      var opts = this.opts;

      target.find("a.jp-first").unbind('.pagination').bind('click.pagination', function(){
			if (opts.pageNumber > 1) that._selectPage(target, 1);
	  });

       target.find("a.jp-previous").unbind('.pagination').bind('click.pagination', function(){
			if (opts.pageNumber > 1) that._selectPage(target, opts.pageNumber - 1);
	  });

       target.find("a.jp-next").unbind('.pagination').bind('click.pagination', function(){
			var pageCount = Math.ceil(opts.total/opts.size);
			if (opts.pageNumber < pageCount) that._selectPage(target, opts.pageNumber + 1);
	  });

       target.find("a.jp-last").unbind('.pagination').bind('click.pagination', function(){
			var pageCount = Math.ceil(opts.total/opts.size);
			if (opts.pageNumber < pageCount) that._selectPage(target, pageCount);
	  });

       target.find("li>a").not(".jp-first, .jp-previous, .jp-next, .jp-last,.jp-current").unbind('.pagination').bind('click.pagination',function(evt){
             that._selectPage(target, parseInt($(this).attr("pageIndex")));
       });
   },

	_selectPage:function (target, page){
		var opts = this.opts;
		var pageCount = Math.ceil(opts.total/opts.size);
		var pageNumber = page;
		if (page < 1) pageNumber = 1;
		if (page > pageCount) pageNumber = pageCount;
		opts.onSelectPage.call(target, pageNumber, opts.size);
		this.element.find("[name='size']").val(opts.size).end().find("[name='start']").val(pageNumber*opts.size);
		opts.pageNumber = pageNumber;
        this._updatePages(target, page);
	},
    _updatePages:function(target,page){
        var opts = this.opts;
       var pageCount= Math.ceil(opts.total / opts.size);
       var neHalf, upperLimit, start, end,interval;
        
        neHalf = Math.ceil( opts.midRange / 2 );
        upperLimit = pageCount - opts.midRange;
        start = page > neHalf ? Math.max( Math.min( page - neHalf, upperLimit ), 0 ) : 0;
        end = page > neHalf ? Math.min( page + neHalf - ( opts.midRange % 2 > 0 ? 1 : 0 ), pageCount ) : Math.min( opts.midRange, pageCount );
        interval = { start: start, end: end };

         if ( page === 1) {
            target.find("a.jp-first").addClass("disabled");
            target.find("a.jp-previous").addClass("disabled");
        } else if(opts.pageNumber !== 1 && page > 1){
             target.find("a.jp-first").removeClass("disabled");
            target.find("a.jp-previous").removeClass("disabled");
        }
        if ( page === pageCount ) {
            target.find("a.jp-next").addClass("disabled");
            target.find("a.jp-last").addClass("disabled");
        }else if(opts.pageNumber !== pageCount && page < pageCount){
            target.find("a.jp-next").removeClass("disabled");
            target.find("a.jp-last").removeClass("disabled");
        }
        target.find("a.jp-current").removeClass("jp-current");
        target.find("a[pageindex='"+page+"']").addClass("jp-current");

       var hold = target.find("ul a").not(".jp-first, .jp-previous, .jp-next, .jp-last");
   
       hold.addClass("hide").slice( interval.start, interval.end ).removeClass("hide");
       hold.slice(0,opts.startRange).removeClass("hide");
       hold.slice(pageCount-opts.endRange).removeClass("hide");

        if ( interval.start > opts.startRange || ( opts.startRange === 0 && interval.start > 0 ) ) { 
            target.find("li>span:first").removeClass("hide");
        } else { 
            target.find("li>span:first").addClass("hide");
        }
        
        if ( interval.end < pageCount - opts.endRange ) {
            target.find("li>span:last").removeClass("hide");
        } else { 
            target.find("li>span:last").addClass("hide");
        }
  
    },

    pageSize:function(total){
       var opts = this.opts;
       opts.total=total;
       this._setNav(this.element);
       this._updatePages(this.element, this.opts.pageNumber);
 
    },

    getOption:function(param){
       return this.opts[param];
    },
    destory: function () {


    }

});

})(jQuery);