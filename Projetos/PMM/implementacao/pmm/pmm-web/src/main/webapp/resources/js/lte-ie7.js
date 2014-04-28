/* Use this script if you need to support IE 7 and IE 6. */

window.onload = function() {
	function addIcon(el, entity) {
		var html = el.innerHTML;
		el.innerHTML = '<span style="font-family: \'icomoon\'">' + entity + '</span>' + html;
	}
	var icons = {
			'icon-book' : '&#xe000;',
			'icon-copy' : '&#xe001;',
			'icon-address-book' : '&#xe003;',
			'icon-copy-2' : '&#xe004;',
			'icon-file' : '&#xe005;',
			'icon-tablet' : '&#xe006;',
			'icon-calculate' : '&#xe007;',
			'icon-podcast' : '&#xe008;',
			'icon-calendar' : '&#xe009;',
			'icon-bullhorn' : '&#xe00a;',
			'icon-user' : '&#xe00b;'
		},
		els = document.getElementsByTagName('*'),
		i, attr, html, c, el;
	for (i = 0; i < els.length; i += 1) {
		el = els[i];
		attr = el.getAttribute('data-icon');
		if (attr) {
			addIcon(el, attr);
		}
		c = el.className;
		c = c.match(/icon-[^\s'"]+/);
		if (c && icons[c[0]]) {
			addIcon(el, icons[c[0]]);
		}
	}
};