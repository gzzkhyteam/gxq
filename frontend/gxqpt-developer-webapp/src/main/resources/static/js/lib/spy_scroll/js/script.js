 window.onload = function (){

	var toc = document.querySelector( '.toc' );
	var tocPath = document.querySelector( '.toc-marker path' );
	var tocItems;

	// 元素必须交叉的屏幕大小系数
	// 在它被认为是可见之前
	var TOP_MARGIN = 0.1,
		BOTTOM_MARGIN = 0.2;

	var pathLength;

	window.addEventListener( 'resize', drawPath, false );
	window.addEventListener( 'scroll', sync, false );

	drawPath();

	function drawPath() {

		tocItems = [].slice.call( toc.querySelectorAll( 'li' ) );

		// 缓存元素参考和测量
		tocItems = tocItems.map( function( item ) {
			var anchor = item.querySelector( 'a' );
			var target = document.getElementById( anchor.getAttribute( 'href' ).slice( 1 ) );

			return {
				listItem: item,
				anchor: anchor,
				target: target
			};
		} );

		// 删除丢失的目标
		tocItems = tocItems.filter( function( item ) {
			return !!item.target;
		} );

		var path = [];
		var pathIndent;

		tocItems.forEach( function( item, i ) {

			var x = item.anchor.offsetLeft - 5,
				y = item.anchor.offsetTop,
				height = item.anchor.offsetHeight;

			if( i === 0 ) {
				path.push( 'M', x, y, 'L', x, y + height );
				item.pathStart = 0;
			}
			else {
				// 当有一个变化时，再画一条线
				// 缩进级别
				if( pathIndent !== x ) path.push( 'L', pathIndent, y );

				path.push( 'L', x, y );

				// 设置当前路径，以便我们可以测量它
				tocPath.setAttribute( 'd', path.join( ' ' ) );
				item.pathStart = tocPath.getTotalLength() || 0;

				path.push( 'L', x, y + height );
			}

			pathIndent = x;

			tocPath.setAttribute( 'd', path.join( ' ' ) );
			item.pathEnd = tocPath.getTotalLength();

		} );

		pathLength = tocPath.getTotalLength();

		sync();

	}

	function sync() {

		var windowHeight = window.innerHeight;

		var pathStart = pathLength,
			pathEnd = 0;

		var visibleItems = 0;

		tocItems.forEach( function( item ) {

			var targetBounds = item.target.getBoundingClientRect();

			if( targetBounds.bottom > windowHeight * TOP_MARGIN && targetBounds.top < windowHeight * ( 1 - BOTTOM_MARGIN ) ) {
				pathStart = Math.min( item.pathStart, pathStart );
				pathEnd = Math.max( item.pathEnd, pathEnd );

				visibleItems += 1;

				item.listItem.classList.add( 'visible' );
			}
			else {
				item.listItem.classList.remove( 'visible' );
			}

		} );

		// S指定可见路径或完全隐藏路径
		// 如果没有可见的项目
		if( visibleItems > 0 && pathStart < pathEnd ) {
			tocPath.setAttribute( 'stroke-dashoffset', '1' );
			tocPath.setAttribute( 'stroke-dasharray', '1, '+ pathStart +', '+ ( pathEnd - pathStart ) +', ' + pathLength );
			tocPath.setAttribute( 'opacity', 1 );
		}
		else {
			tocPath.setAttribute( 'opacity', 0 );
		}

	}

};