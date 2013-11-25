(function ($, window, undefined){
    $.widget("ui.pagination", {
        options: {
        	total: 10,
		    size: 10,
		    pageNumber: 1,
            first        : false,
            previous     : "上一页",
            next         : "下一页",
            last         : false,
            startRange   : 1,
			midRange     : 3,
            endRange     : 1,
    },
    _create: function () {
    	 this.element.append("<input   type='hidden' name='size'/>")
    	              .append("<input type='hidden' name='start'/>").addClass("pagination");
    	  this.options.holder =  $("<ul></ul>").appendTo(this.element);
         $.data(this.element, this.widgetName, {
					options: this.opts
		 });
         this._setNav();
         this._selectPage(this.options.pageNumber);
    },
    _setNav:function(){
      var opts =this.options;
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

        this._bindNavHandlers();

    },

   _bindNavHandlers:function(){
      var that=this;
      var opts = this.options;

      this.element.find("a.jp-first").unbind('.pagination').bind('click.pagination', function(){
			if (opts.pageNumber > 1) that._selectPage( 1);
	  });

       this.element.find("a.jp-previous").unbind('.pagination').bind('click.pagination', function(){
			if (opts.pageNumber > 1) that._selectPage(  opts.pageNumber - 1);
	  });

       this.element.find("a.jp-next").unbind('.pagination').bind('click.pagination', function(){
			var pageCount = Math.ceil(opts.total/opts.size);
			if (opts.pageNumber < pageCount) that._selectPage( opts.pageNumber + 1);
	  });

       this.element.find("a.jp-last").unbind('.pagination').bind('click.pagination', function(){
			var pageCount = Math.ceil(opts.total/opts.size);
			if (opts.pageNumber < pageCount) that._selectPage( pageCount);
	  });

       this.element.find("li>a").not(".jp-first, .jp-previous, .jp-next, .jp-last,.jp-current").unbind('.pagination').bind('click.pagination',function(evt){
             that._selectPage( parseInt($(this).attr("pageIndex")));
       });
   },

	_selectPage:function (page){
		var opts = this.options;
		var pageCount = Math.ceil(opts.total/opts.size);
		var pageNumber = page;
		if (page < 1) pageNumber = 1;
		if (page > pageCount) pageNumber = pageCount;
		
	   this._trigger("onSelectPage",null,{index:pageNumber,size:opts.size});
		this.element.find("[name='size']").val(opts.size).end().find("[name='start']").val(pageNumber*opts.size);
		opts.pageNumber = pageNumber;
        this._updatePages(page);
	},
    _updatePages:function(page){
        var opts = this.options;
       var pageCount= Math.ceil(opts.total / opts.size);
       var neHalf, upperLimit, start, end,interval;
        neHalf = Math.ceil( opts.midRange / 2 );
        upperLimit = pageCount - opts.midRange;
        start = page > neHalf ? Math.max( Math.min( page - neHalf, upperLimit ), 0 ) : 0;
        end = page > neHalf ? Math.min( page + neHalf - ( opts.midRange % 2 > 0 ? 1 : 0 ), pageCount ) : Math.min( opts.midRange, pageCount );
        interval = { start: start, end: end };

         if ( page === 1) {
            this.element.find("a.jp-first").addClass("disabled");
            this.element.find("a.jp-previous").addClass("disabled");
        } else if(opts.pageNumber !== 1 && page > 1){
             this.element.find("a.jp-first").removeClass("disabled");
            this.element.find("a.jp-previous").removeClass("disabled");
        }
        if ( page === pageCount ) {
            this.element.find("a.jp-next").addClass("disabled");
            this.element.find("a.jp-last").addClass("disabled");
        }else if(opts.pageNumber !== pageCount && page < pageCount){
            this.element.find("a.jp-next").removeClass("disabled");
            this.element.find("a.jp-last").removeClass("disabled");
        }
        this.element.find("a.jp-current").removeClass("jp-current");
        this.element.find("a[pageindex='"+page+"']").addClass("jp-current");

       var hold = this.element.find("ul a").not(".jp-first, .jp-previous, .jp-next, .jp-last");
   
       hold.addClass("hide").slice( interval.start, interval.end ).removeClass("hide");
       hold.slice(0,opts.startRange).removeClass("hide");
       hold.slice(pageCount-opts.endRange).removeClass("hide");

        if ( interval.start > opts.startRange || ( opts.startRange === 0 && interval.start > 0 ) ) { 
            this.element.find("li>span:first").removeClass("hide");
        } else { 
            this.element.find("li>span:first").addClass("hide");
        }
        
        if ( interval.end < pageCount - opts.endRange ) {
            this.element.find("li>span:last").removeClass("hide");
        } else { 
            this.element.find("li>span:last").addClass("hide");
        }
  
    },

    pageSize:function(total){
       var opts = this.options;
       opts.total=total;
       this._setNav();
       this._updatePages( opts.pageNumber);
 
    },
    destory: function () {
        this.element.off();
    }

});
	
})(jQuery, window, undefined);