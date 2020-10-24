<template>
    <!--<Sider ref="side1" hide-trigger collapsible :collapsed-width="70" width="220" v-model="isCollapsed">-->
        <Menu class="menu" width="auto" :class="menuitemClasses" :style="{width: !shrink?'220px':'60px'}" style="float:left">
            <MenuItem name="0" class="text-center" disabled @click.native="collapsedSider">
                <Icon :class="rotateIcon" type="chevron-left" size="24"></Icon>
            </MenuItem>
            <template v-for="(menu, index) in menus">
            	<div  :key="index" v-show="!shrink">
	                <MenuItem :name="index" v-if="!menu.subMenu" :key="index" @click.native="goTo(menu.link)">
	                    <i class="icomoon" :class="menu.icon" v-if="menu.icon"></i>
	                    <span>{{menu.name}}<span v-if="menu.countSum>0">({{menu.countSum}})</span></span>
	                </MenuItem>
	                <Submenu :name="index" v-else>
	                    <template slot="title">
	                        <i class="icomoon" :class="menu.icon" v-if="menu.icon"></i>
	                        <span>{{menu.name}}<span v-if="menu.countSum>0">({{menu.countSum}})</span></span>
	                    </template>
	                    <MenuItem v-for="(subMenu, idx) in menu.subMenu" :key="idx"  @click.native="goTo(subMenu.link)" :name="`${index}-${idx}`">
	                        <i class="icomoon" :class="subMenu.icon" v-if="subMenu.icon"></i>
	                        <span>{{subMenu.name}}<span v-if="subMenu.countSum>0">({{subMenu.countSum}})</span></span>
	                    </MenuItem>
	                </Submenu>
            	</div>
            	<div style="text-align: center;" v-show="shrink">
                    <Dropdown transfer v-if="!menu.subMenu" placement="right-start" :key="index" @on-click="goTo(menu.link,menu.name)">
                        <div class="dropDownItem" @click="goTo(menu.link,menu.name)" style="width: 70px;margin-left: -5px;padding:10px 0;">
                            <i class="icomoon" :class="menu.icon" v-if="menu.icon"></i>
                        </div>
                        <DropdownMenu style="width: 200px;" slot="list">
                            <DropdownItem :name="menu.name" :key="'d' + index"><i class="icomoon" :class="menu.icon" v-if="menu.icon"></i><span style="padding-left:10px;">{{ menu.name }}</span></DropdownItem>
                        </DropdownMenu>
                    </Dropdown>
                    <Dropdown transfer v-else placement="right-start" :key="index" @on-click="changeMenu">
                        <div class="dropDownItem" style="width: 70px;margin-left: -5px;padding:10px 0;">
                            <i class="icomoon" :class="menu.icon" v-if="menu.icon"></i>
                        </div>
                        <DropdownMenu style="width: 200px;" slot="list">
                            <template v-for="(subMenu, i) in menu.subMenu">
                                <DropdownItem :name="subMenu.link" :key="i">
                                    <i class="icomoon" :class="subMenu.icon" v-if="subMenu.icon"></i>
                                    <span style="padding-left:10px;">{{ subMenu.name }}</span>
                                </DropdownItem>
                            </template>
                        </DropdownMenu>
                    </Dropdown>
                </div>
            </template>
        </Menu>
    <!--</Sider>-->
</template>
<script>
export default {
    props: [ 'menus' ],
    data() {
        return {
            isCollapsed: false,
            url:'',
            route:'',
            shrink:false,
        }
    },
    inject:['reload'],
    computed: {
        rotateIcon() {
            return [
                'menu-icon',
                this.shrink ? 'rotate-icon' : ''
            ];
        },
        menuitemClasses() {
            return [
                'menu-item',
                this.shrink ? 'collapsed-menu' : 'item-menu'
            ]
        }
    },
    watch: {
        '$route': function (route) {
            console.log(route);
            this.route = route.name;
        },
    },
    methods: {
        collapsedSider() {
            this.shrink = !this.shrink;
            console.log(this.shrink);
            // this.$refs.side1.toggleCollapse();
        },
        getStatus (urlStr) {
            var urlStrArr = urlStr.split('/')
            return urlStrArr[urlStrArr.length - 1]
        },
        changeMenu(name){
            this.goTo(name,'');
        },
        goTo(path,name){
            // console.log(path);
            // console.log(this.url);
            if(this.url == path && this.url.indexOf(this.route) != -1){//判断是否当前页面刷新
                this.reload();//右侧栏目重载
            }else{
                this.$store.state.title = name;
                this.$router.push({
                    path: path
                });
                this.url = path;
            }
        }
    }
}
</script>
<style type="text/css" scoped="scoped">
	.menu /deep/ a.router-link-active{
		color: #2d8cf0 !important;
	}
    .item-menu i{
        transform: translateX(0px);
        transition: font-size 0.2s ease, transform 0.2s ease;
        vertical-align: middle;
        font-size: 20px;
    }
    .collapsed-menu i{
        transform: rotate(-180deg) !important;
        transition: font-size 0.2s ease 0.2s, transform 0.2s ease 0.2s;
        vertical-align: middle;
        font-size: 22px;
    }
</style>