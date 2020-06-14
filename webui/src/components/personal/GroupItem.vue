<template>
    <el-container>
        <el-aside style="width: 100px; padding: 20px 0 20px 0">
            <el-image :src="portrait" fit="fill" style="align-self: center"></el-image>
        </el-aside>
        <el-main>
            <el-row type="flex" align="middle">
                <el-col class="title" :span="8">
                    托福口语强化班—课程群
                </el-col>
                <el-col :span="12" style="color: #68BF4A">
                    名师课程群
                </el-col>
            </el-row>
            <el-row class="info">
                <el-col :span="7">
                    建群时间：2020-6-14 20:00
                </el-col>
                <el-col :span="8">
                    群人数：200
                </el-col>
            </el-row>
            <el-row class="info">
                djfdfjkslfjlksdjlfksjkld
            </el-row>
            <el-row class="info" style="text-align: center">
                <el-col :span="4">
                    <el-button type="primary" plain>进入群聊</el-button>
                </el-col>
                <el-col :span="4">
                    <el-button type="primary" plain>群信息</el-button>
                </el-col>
                <el-col :span="4" v-if="!isAdmin">
                    <el-button type="primary" plain>申请做管理员</el-button>
                </el-col>
                <el-col :span="4" v-if="isAdmin">
                    <el-button type="primary" plain>退出管理员</el-button>
                </el-col>
                <el-col :span="4" v-if="!isAdmin">
                    <el-button type="primary" plain>退出群</el-button>
                </el-col>
                <el-col :span="4" v-if="isAdmin">
                    <el-button type="primary" plain>解散群</el-button>
                </el-col>
            </el-row>
            <el-divider></el-divider>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "GroupItem",
        props: {
          isAdmin: Boolean
        },
        data() {
            return {
                portrait: 'http://b-ssl.duitang.com/uploads/item/201603/06/20160306204517_i4Se8.jpeg',
            }
        }
    }
</script>

<style scoped>
    .title {
        font-weight: bold;
        font-size: 1.4rem;
    }

    .info {
        padding: 15px 0 0 0;
    }
</style>