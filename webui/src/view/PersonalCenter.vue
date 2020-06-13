<template>
    <el-container style="margin: 40px 15% 40px 15%">
        <el-aside>
            <el-container direction="vertical" class="portrait-title">
                <el-image :src="portrait" :fit="fill" class="portrait"></el-image>
                <el-row class="username">
                    余坚
                </el-row>
            </el-container>
            <el-container class="aside-menu">
                <el-main>
                    <el-row class="menu-normal">
                        <el-col :span="8" class="menu-icon">
                            <i class="el-icon-setting"/>
                        </el-col>
                        <el-col :span="16" class="menu-text">
                            个人资料
                        </el-col>
                    </el-row>
                    <el-row class="menu-normal">
                        <el-col :span="8" class="menu-icon">
                            <i class="el-icon-notebook-2"/>
                        </el-col>
                        <el-col :span="16" class="menu-text">
                            我的课程
                        </el-col>
                    </el-row>
                    <el-row class="menu-normal">
                        <el-col :span="8" class="menu-icon">
                            <i class="el-icon-coordinate"/>
                        </el-col>
                        <el-col :span="16" class="menu-text">
                            我的群组
                        </el-col>
                    </el-row>
                    <el-row class="menu-normal">
                        <el-col :span="8" class="menu-icon">
                            <i class="el-icon-reading"/>
                        </el-col>
                        <el-col :span="16" class="menu-text">
                            我的托福人
                        </el-col>
                    </el-row>
                </el-main>
            </el-container>
        </el-aside>
        <el-main style="margin-left: 20px">

        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "PersonalCenter",
        data() {
            return {
                portrait: 'http://img2.imgtn.bdimg.com/it/u=1354268575,1268995723&fm=26&gp=0.jpg',
            }
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
</style>