(function ($) {

    $(function () {
        /**
         * sidebar nav 图标切换
         */
        $('.sidebar-title').click(function () {
            var _c = $(this).children().eq(0);
            var _b = $(_c).hasClass('fa-caret-down');
            if (_b === true) {
                $(_c).removeClass('fa-caret-down');
                $(_c).addClass('fa-caret-right');
            } else {
                $(_c).removeClass('fa-caret-right');
                $(_c).addClass('fa-caret-down');
            }
        });

        var expandMenu_new, expandMenu_old;
        $('.sidebar-fold').click(function () {
            var c = $('.view-framework-body').hasClass('view-framework-sidebar-mini');
            var sidebarFoldIconURL = $($(this).find("img")[0]).prop("src");
            if (c === true) {
            	$("#active").children("ul").show()
            	$($(this).find("img")[0]).prop("src", sidebarFoldIconURL.replace("open", "close"));
                $('.view-framework-body').removeClass('view-framework-sidebar-mini');
                $('.view-framework-body').addClass('view-framework-sidebar-full');
                $(this).children('span:last').show();
                $('#sidemenu a').each(function () {
                    $(this).tipsy("disable");
                });
                $("#active").children("ul").collapse("show")
                 
                $('.sidebar-mask').hide();
            } else {
         	$($(this).find("img")[0]).prop("src", sidebarFoldIconURL.replace("close", "open"));
                $('.view-framework-body').removeClass('view-framework-sidebar-full');
                $('.view-framework-body').addClass('view-framework-sidebar-mini');
                $(this).children('span:last').hide();
                $('#sidemenu a').tipsy({title: "title"});
                $('#sidemenu a').each(function () {
                    $(this).tipsy("enable");
                });
                $("#active").children("ul").collapse("hide")
                $("#active").children("ul").hide()
                $('.sidebar-mask').show();
            }

            expandMenu_new = $('#side-menu').children(".active");

            if (expandMenu_new.length > 0) {
                if (!expandMenu_old) {
                    expandMenu_old = expandMenu_new;
                }
            }


            var newtext = expandMenu_new.children("a").children(".nav-label").html();
            var oldtext = expandMenu_old.children("a").children(".nav-label").html();
            if (newtext == oldtext) {
                //alert(1);
                //if(expandMenu_new.hasClass("active")){
                if (expandMenu_new.is(':hidden') == true) {
                    //expandMenu_new.toggleClass("active").children("ul").collapse("toggle");
                    expandMenu_new.toggleClass("active").children("ul").collapse("show");
                } else {
                    expandMenu_new.toggleClass("active").children("ul").collapse("hide");
                }
                //expandMenu_new.toggleClass("active").children("ul").collapse("toggle");
            } else {
                //alert(2);
                if (!newtext) {
                    if (c === true) {
                        expandMenu_old.toggleClass("active").children("ul").collapse("toggle");
                    }
                } else {
                    expandMenu_old = expandMenu_new;
                    if (c !== true) {
                        expandMenu_new.toggleClass("active").children("ul").collapse("toggle");
                    }
                    /*
                     if(!expandMenu_new.hasClass("active")){
                     console.log("catshit4");
                     expandMenu_new.toggleClass("active").children("ul").collapse("toggle");
                     }else{

                     }
                     */
                }
            }
        });

        //$('#sidemenu').metisMenu();

        $.fn.tipsy.defaults = {
            delayIn: 0,      // delay before showing tooltip (ms)
            delayOut: 0,     // delay before hiding tooltip (ms)
            fade: false,     // fade tooltips in/out?
            fallback: '',    // fallback text to use when no tooltip text
            gravity: 'w',    // gravity
            html: false,     // is tooltip content HTML?
            live: false,     // use live event support?
            offset: -128,       // pixel offset of tooltip from element
            opacity: 0.8,    // opacity of tooltip
            title: 'title',  // attribute/callback containing tooltip text
            trigger: 'hover' // how tooltip is triggered - hover | focus | manual
        };


    });

})(jQuery);

$(function () {
    $("#side-menu>li").off().on("click", function () {
        $("#side-menu>li").removeClass("active");
        $(this).addClass("active");
    });
    $("#side-menu ul li").off().on("click", function () {
        $("#side-menu ul li").removeClass("active");
        $(this).addClass("active");
    });
});

