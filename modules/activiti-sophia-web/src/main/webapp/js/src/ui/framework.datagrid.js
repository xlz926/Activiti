; (function ($, window, undefined) {
    
    $.widget("pousheng.datagrid",  {
      options:{
            title: null,
            iconCls: null,
            border: true,
            width: 'auto',
            height: 400,
            striped: false,
            method:"get",
            loadMsg: 'Processing, please wait ...',
            border:true,
            singleSelect:true,
            pagination:false
      },
      _create:function(){
              var elem=this.element;
              
              $.extend(this.options,{
              url:elem.attr("url"),
              width:elem.width(),
              height:elem.height(),
              path:elem.attr("data-path")
              });
              
              
              this._wrapGrid();

              this._setSize();

              
              this._setProperties();
    
      },
      _wrapGrid:function(){
         var grid = this.element,
             that  = this,
             table = this.element.find("table"),
             opts =this.element;
             grid.addClass("datagrid").append(
				'<div class="datagrid-wrap panel-body">' +
					'<div class="datagrid-view">' +
						'<div class="datagrid-view1">' +
							'<div class="datagrid-header">' +
								'<div class="datagrid-header-inner"><table border="0" cellspacing="0" cellpadding="0"><thead></thead></table></div>' +
							'</div>' +
							'<div class="datagrid-body">' +
								'<div class="datagrid-body-inner">' +
									'<table border="0" cellspacing="0" cellpadding="0"></table>' +
								'</div>' +
							'</div>' +
						'</div>' +
						'<div class="datagrid-view2">' +
							'<div class="datagrid-header">' +
								'<div class="datagrid-header-inner"><table border="0" cellspacing="0" cellpadding="0"></table></div>' +
							'</div>' +
							'<div class="datagrid-body"></div>' +
						'</div>' +
					'</div>' +
				'</div>'
		 );

          table.find("th").each(function(i,elem){
        	  var width = $(this).attr("width") || $(this).width();
        	  $(this).removeAttr("width");
        	  $(this).wrapInner($("<div class='datagrid-cell'/>").width(width));
          });
         table.find("thead").appendTo(grid.find(".datagrid-view2 .datagrid-header-inner table"));
          table.appendTo(grid.find(".datagrid-view2 .datagrid-body")).removeClass("table") ; 
          
          $('.datagrid-title', grid).remove();
            if (opts.title) {
                var title = $('<div class="datagrid-title"><span class="datagrid-title-text"></span></div>');
                $('.datagrid-title-text', title).html(this.opts.title);
                title.prependTo(grid);
                if (opts.iconCls) {
                    $('.datagrid-title-text', title).addClass('datagrid-title-with-icon');
                    $('<div class="datagrid-title-icon"></div>').addClass(this.opts.iconCls).appendTo(title);
                }
            }
          

             $('.datagrid-toolbar',grid).prependTo(grid.find('.datagrid-wrap'));
            
            $('.datagrid-pager', grid).remove();
			
            
            
            if (opts.pagination) {
				$('<div class="datagrid-pager"></div>').appendTo($('.datagrid-wrap', grid)).pagination({
					onSelectPage:function(event,params){
						that._request(params);
					}
				});
            }
			
            if (opts.border == true){
				grid.removeClass('datagrid-noborder');
			} else {
				grid.addClass('datagrid-noborder');
			}


      },
      _setSize:function(){
           
            var grid = this.element,
                opts = this.options;
            if (opts.fit == true) {
                var p = grid.parent();
                opts.width = p.innerWidth();
                opts.height = p.innerHeight();
            }


            var gridWidth = opts.width;
            if (gridWidth == 'auto') {
                if ($.boxModel == true) {
                    gridWidth = grid.width();
                } else {
                    gridWidth = grid.outerWidth();
                }
            } else {
                if ($.boxModel == true) {
                    gridWidth -= grid.outerWidth() - grid.width();
                }
            }
            grid.width(gridWidth);


            var innerWidth = gridWidth;
            if ($.boxModel == false) {
                innerWidth = gridWidth - grid.outerWidth() + grid.width();
            }

            $('.datagrid-wrap', grid).width(innerWidth);
            $('.datagrid-view', grid).width(innerWidth);
            $('.datagrid-view1', grid).width($('.datagrid-view1 table', grid).width());
            $('.datagrid-view2', grid).width(innerWidth - $('.datagrid-view1', grid).outerWidth());
            $('.datagrid-view1 .datagrid-header', grid).width($('.datagrid-view1', grid).width());
            $('.datagrid-view1 .datagrid-body', grid).width($('.datagrid-view1', grid).width());
            $('.datagrid-view2 .datagrid-header', grid).width($('.datagrid-view2', grid).width());
            $('.datagrid-view2 .datagrid-body', grid).width($('.datagrid-view2', grid).width());

          

          	var hh;
		    var header1 = $('.datagrid-view1 .datagrid-header',grid);
		    var header2 = $('.datagrid-view2 .datagrid-header',grid);
		    header1.css('height', null);
		    header2.css('height', null);
		
		    if ($.boxModel == true){
			    hh = Math.max(header1.height(), header2.height());
		    } else {
			    hh = Math.max(header1.outerHeight(), header2.outerHeight());
		    }
		
		    $('.datagrid-view1 .datagrid-header table',grid).height(hh);
		    $('.datagrid-view2 .datagrid-header table',grid).height(hh);
		    header1.height(hh);
		    header2.height(hh);
		
		    if (opts.height == 'auto') {
			    $('.datagrid-body', grid).height($('.datagrid-view2 .datagrid-body table', grid).height());
		    } else {
			    $('.datagrid-body', grid).height(
					    opts.height
					    - (grid.outerHeight() - grid.height())
					    - $('.datagrid-header', grid).outerHeight(true)
					    - $('.datagrid-title', grid).outerHeight(true)
					    - $('.datagrid-toolbar', grid).outerHeight(true)
					    - $('.datagrid-search', grid).outerHeight(true)
					    - $('.datagrid-pager', grid).outerHeight(true)
			    );
		    }
		
		    $('.datagrid-view',grid).height($('.datagrid-view2',grid).height());
		    $('.datagrid-view1',grid).height($('.datagrid-view2',grid).height());
		    $('.datagrid-view2',grid).css('left', $('.datagrid-view1',grid).outerWidth());
            
		   /* this.table.find("th").each(function(i,elem){
	        	  table.find("tr td").eq(i).wrapInner($("<div class='datagrid-cell'/>").width($(this).width()));
	          })*/
      },
      _request:function(page){
    	
    	  
      
            var param={method:this.options.url},
                that = this,
                grid =this.element,
                wrap = $('.datagrid-wrap', grid),
                opts =this.options,
                _search={},
                _page ={},
                model =$.view(this.element).data;
            
            if (!this.options.url) {
            	return;
            }
            if(model[this.options.path].search){
            	_search =model[this.options.path].search;
            }
            
            if(page){
            	_page = {start:(page.index-1)*page.size,size:page.size }; 
            }
            $.extend(param,{params:stell.util.serialize($.extend(_search,_page))});
           

           $('<div class="datagrid-mask"></div>').css({
                display: 'block',
                width: wrap.width(),
                height: wrap.height()
            }).appendTo(wrap);
            $('<div class="datagrid-mask-msg"></div>')
				.html(opts.loadMsg)
				.appendTo(wrap)
				.css({
				    display: 'block',
				    left: (wrap.width() - $('.datagrid-mask-msg', grid).outerWidth()) / 2,
				    top: (wrap.height() - $('.datagrid-mask-msg', grid).outerHeight()) / 2
				});

     
            $.ajax({
                type: opts.method,
                url: 'flow/restService/RestService',
                data: param,
                dataType: 'json',
                success: function (result) {
                    $('.datagrid-mask', grid).remove();
                    $('.datagrid-mask-msg', grid).remove();
                    $.observable(model[opts.path].data).refresh(result.data);
                    that.element.find(".datagrid-pager").pagination("pageSize",result.total);
                    that._trigger("onLoadSuccess",null,that.element[0]);
                    that._loadData();
                },
                error: function () {
                    $('.datagrid-mask', grid).remove();
                    $('.datagrid-mask-msg', grid).remove();
                    that._trigger("onLoadError",null,that.element[0]);
                }
            });

      
      },
      _loadData:function(){
    	  var that = this 
    	  this.element.find(".datagrid-header th").each(function(i,elem){
    		  that.element.find(".datagrid-view2  tbody  tr").each(function(){
    			  $(this).find("td").eq(i).wrapInner($("<div class='datagrid-cell'/>").width($(elem).find(".datagrid-cell").width()));
    		  });
          });
      },
      refresh:function(){
    	 this._request(); 
      },
      _setProperties:function(){
            var grid =this.element,
                that =this ;
            grid.on("click",".datagrid-body tr",function(event){
             var	$this =$(this);
            	var index = $this.attr('datagrid-row-index');
			    if ($this.hasClass('datagrid-row-selected')){
			    	$this.removeClass('datagrid-row-selected');
			    	 $this.find("input[type=checkbox].datagrid-cell-check").attr('checked', false);
			    } else {
			    	if(that.options.singleSelect)
			    		grid.find(".datagrid-row-selected").removeClass("datagrid-row-selected")
			    		.end().find("input[type=checkbox].datagrid-cell-check").attr("checked",false);
			    	$this.addClass('datagrid-row-selected');
			    	$this.find("input[type=checkbox].datagrid-cell-check").attr('checked', true);
			         that._trigger("onClickRow",event,$.view(this).data);
			    }
              
            
            }).on("dblclick",".datagrid-body tr",function(event){
                $(this).addClass('datagrid-row-selected');
                    that._trigger("onDblClickRow",event);
            });
        
      },
      getSelected:function(){
    	  var result =[];
    	  this.element.find("tr.datagrid-row-selected").each(function(){
    		  result.push($.view(this).data);
    	  });
    	  return result;
      }


    });


})(jQuery, window, undefined);