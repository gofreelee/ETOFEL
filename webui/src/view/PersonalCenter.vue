<template>
    <el-container style="margin: 40px 15% 40px 15%">
        <el-aside>
            <el-container direction="vertical" class="portrait-title">
                <img :src="information.usr_portrait" fit="fill" class="portrait" alt="用户头像"/>
                <el-row class="username">
                    {{information.usr_nickname}}
                </el-row>
            </el-container>
            <el-container class="aside-menu">
                <el-main style="padding-left: 0; padding-right: 0">
                    <el-row v-bind:class="['menu-normal',{'menu-active':selectPage.information}]"
                            @click.native="changePage('information')">
                        <el-col :span="9" class="menu-icon">
                            <i class="el-icon-setting"/>
                        </el-col>
                        <el-col :span="15" class="menu-text">
                            个人资料
                        </el-col>
                    </el-row>
                    <el-row v-bind:class="['menu-normal',{'menu-active':selectPage.course}]"
                            @click.native="changePage('course')">
                        <el-col :span="9" class="menu-icon">
                            <i class="el-icon-notebook-2"/>
                        </el-col>
                        <el-col :span="15" class="menu-text">
                            我的课程
                        </el-col>
                    </el-row>
                    <el-row v-bind:class="['menu-normal',{'menu-active':selectPage.group}]"
                            @click.native="changePage('group')">
                        <el-col :span="9" class="menu-icon">
                            <i class="el-icon-coordinate"/>
                        </el-col>
                        <el-col :span="15" class="menu-text">
                            我的群组
                        </el-col>
                    </el-row>
                    <el-row v-bind:class="['menu-normal',{'menu-active':selectPage.article}]"
                            @click.native="changePage('article')">
                        <el-col :span="9" class="menu-icon">
                            <i class="el-icon-reading"/>
                        </el-col>
                        <el-col :span="15" class="menu-text">
                            我的托福人
                        </el-col>
                    </el-row>
                </el-main>
            </el-container>
        </el-aside>
        <el-main style="margin-left: 20px; padding: 0">
            <Information v-if="selectPage.information"/>
            <MyCourse v-if="selectPage.course"/>
            <MyGroup v-if="selectPage.group"/>
            <MyArticle v-if="selectPage.article"/>
        </el-main>
    </el-container>
</template>

<script>
    import Information from "../components/personal/Information";
    import MyCourse from "../components/personal/MyCourse";
    import MyGroup from "../components/personal/MyGroup";
    import MyArticle from "../components/personal/MyArticle";
    import Vue from "vue";

    export default {
        name: "PersonalCenter",
        components: {
            Information,
            MyCourse,
            MyGroup,
            MyArticle
        },
        data() {
            return {
                information: '',
                portrait: 'http://img2.imgtn.bdimg.com/it/u=1354268575,1268995723&fm=26&gp=0.jpg',
                selectPage: {
                    'information': true,
                    'course': false,
                    'group': false,
                    'article': false
                }
            }
        },
        methods: {
            changePage(pageName) {
                this.selectPage.information = false;
                this.selectPage.course = false;
                this.selectPage.group = false;
                this.selectPage.article = false;
                this.selectPage[pageName] = true;
            }
        },
        mounted() {
            this.information = Vue.prototype.$user;
        }
    }
</script>

<style scoped>
    .portrait-title {
        text-align: center;
        background-image: url('https://i.loli.net/2020/06/13/HwqQRN1lZucVWIY.jpg');
        background-size: 100% 100%;
        padding-top: 30px;
        padding-bottom: 20px;
    }

    .portrait {
        width: 200px;
        height: 200px;
        align-self: center
    }

    .username {
        font-size: 1.2rem;
        color: white;
        margin-top: 10px;
    }

    .aside-menu {
        border-left: 1px #68BF4A solid;
        border-right: 1px #68BF4A solid;
        border-bottom: 1px #68BF4A solid;
        border-bottom-left-radius: 10px;
        border-bottom-right-radius: 10px;
    }

    .menu-normal {
        font-size: 1.2rem;
        padding: 20px 0 20px 0;
    }

    .menu-normal .menu-icon {
        text-align: center;
        color: #68BF4A;
    }

    .menu-active {
        border-left: solid 5px #68BF4A;
        background-color: rgba(104, 191, 74, 0.2);
    }
</style>