$(function() {
	//粒子背景特效
	window.requestAnimFrame = (function() {
		window.requestAnimationFrame = window.requestAnimationFrame||function (fn) {return setTimeout(fn,1000/60)};
		return window.requestAnimationFrame;
	})();
	var canvas = document.getElementById("space");

	if(!canvas.getContext) {
		//$(".login-back").css("background", "transparent url('images/developer/star.png') no-repeat;");
		return;
	}

	var c = canvas.getContext("2d");

	var numStars = 500;
	var radius = '0.' + Math.floor(Math.random() * 9) + 1;
	var focalLength = canvas.width * 2;
	var warp = 0;
	var centerX, centerY;

	var stars = [],
		star;
	var i;

	var animate = true;
	if(top != self) {
		// 如果判断CAS在iframe框架中，则CAS背景动画停止
		animate = false;
	}

	initializeStars();

	function executeFrame() {
		if(animate){
			requestAnimFrame(executeFrame);
		}
		moveStars();
		drawStars();
	}

	function initializeStars() {
		centerX = canvas.width / 2;
		centerY = canvas.height / 2;

		stars = [];
		for(i = 0; i < numStars; i++) {
			star = {
				x: Math.random() * canvas.width,
				y: Math.random() * canvas.height,
				z: Math.random() * canvas.width,
				o: '0.' + Math.floor(Math.random() * 99) + 1
			};
			stars.push(star);
		}
	}

	function moveStars() {
		for(i = 0; i < numStars; i++) {
			star = stars[i];
			star.z--;

			if(star.z <= 0) {
				star.z = canvas.width;
			}
		}
	}

	function drawStars() {
		var pixelX, pixelY, pixelRadius;

		// Resize to the screen
		if(canvas.width != window.innerWidth || canvas.height != window.innerHeight) {
			canvas.width = window.innerWidth;
			canvas.height = window.innerHeight;
			initializeStars();
		}
		if(warp == 0) {
			c.fillStyle = "rgba(0,23,50,1)";
			c.fillRect(0, 0, canvas.width, canvas.height);
		}
		c.fillStyle = "rgba(209, 255, 255, " + radius + ")";
		for(i = 0; i < numStars; i++) {
			star = stars[i];

			pixelX = (star.x - centerX) * (focalLength / star.z);
			pixelX += centerX;
			pixelY = (star.y - centerY) * (focalLength / star.z);
			pixelY += centerY;
			pixelRadius = 1 * (focalLength / star.z);

			c.fillRect(pixelX, pixelY, pixelRadius, pixelRadius);
			c.fillStyle = "rgba(209, 255, 255, " + star.o + ")";
		}
	}

	executeFrame();

})