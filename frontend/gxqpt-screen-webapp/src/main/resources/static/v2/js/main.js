$(function(){
    initPlaceholder();
})


/*初始化placeholder提示内容的颜色*/
function initPlaceholder() {
    $('input.holder').each(function () {
        var $this = $(this),
            holder = $this.data('holder');
        if (holder && ($this.val() == "" || $this.val() == holder)) {
            $this.css({color: "#fff"}).val(holder);
        }
    });

    //获取焦点时设置内容的颜色和值为空
    $(document).off('focus', 'input.holder').on('focus', 'input.holder', function () {
        var $this = $(this);

        $this.css({borderColor: "#fff"}).prev().css({borderColor: "#158dd4", color: "#158dd4"});

        if ($this.val() === $this.data('holder')) {
            $this.css('color', '#fff').val('');
        }
    });

    //失去焦点后还原提示内容
    $(document).off('blur', 'input.holder').on('blur', 'input.holder', function () {
        var $this = $(this);
        $this.css({borderColor: "#fff"}).prev().css({borderColor: "#a4a4a4", color: "#a4a4a4"});

        if ($.trim($this.val()) === '') {
            $this.css('color', '#fff').val($this.data('holder'));
        } else {
            $this.css('color', '#303030');
        }
    });
}