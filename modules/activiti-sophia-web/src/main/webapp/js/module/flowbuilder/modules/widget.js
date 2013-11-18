
InputFilter = Backbone.Model.extend({
	accept: function() {}
}),
AcceptAllInputFilter = InputFilter.extend({
	accept: function() {
		return ! 0
	}
});

Widget = Backbone.View.extend({
	initialize: function(a, b) {
		this._template = a,
		this._data = {},
		b || (this._filter = new AcceptAllInputFilter)
	},
	setValue: function(a) {},
	render: function(a) {
		var b = "#template-widget-" + this._template,
			c = _.template($(b).html()),
			d = c($.extend(this._data, {
				_wid: this.cid,
				_property_title: a
			}));
			
		$(this.el).html(d),
		this.delegateEvents()
	},
	onAttach: function() {}
});

NullWidget = Widget.extend({
	initialize: function() {
		Widget.prototype.initialize.call(this, "nullwidget", new AcceptAllInputFilter)
	}
}),
/**
 * �����ı���
 */
TextWidget = Widget.extend({
	initialize: function(a, b) {
		Widget.prototype.initialize.call(this, "singletext", a),
		this._delay = b,
		this._data = {text: ""}
	},
	events: {
		"keyup input": "onKeyPress",
		"keydown input": "onKeyDown"
	},
	setValue: function(a) {
		this._data.text = a,
		$("input[type=text]", this.el).val(a)
	},
	updateValue: function(a) {
		this._data.text = a
	},
	onKeyDown: function(a) {
		//���ⰴ��ctrl+z�ȿ������������Ĭ����Ϊ����Ȼ�����ֵ����ԭ�����޷�����������ͼ���繤������
		//return (a.ctrlKey || a.metaKey) && a.which == 90 ? (window.App.undo(), !1) : (a.ctrlKey || a.metaKey) && a.which == 89 ? (window.App.redo(), !1) : !0
	},
	onKeyPress: function(a) {
		var b = this,
		c = $(a.currentTarget);
		this._delay ? (clearTimeout(this._delayTimeout), this._delayTimeout = setTimeout(function() {
			b.trigger("valueChanged", c.val())
		}, this._delay)) : this.trigger("valueChanged", c.val())
	}
}),
RadioButtonsWidget = Widget.extend({
	initialize: function(a, b) {
		Widget.prototype.initialize.call(this, "radiobuttons", a),
		this._data = {
			options: b
		}
	},
	events: {
		"click input": "onValueChanged"
	},
	onValueChanged: function(a) {
		var b = $(a.currentTarget);
		this.trigger("valueChanged", b.val())
	},
	setValue: function(a) {
		for (var b in this._data.options) {
			var c = this._data.options[b];
			c.checked = !1,
			c.value == a && (c.checked = !0)
		}
	},
	updateValue: function(a) {
		this.setValue(a)
	}
});



