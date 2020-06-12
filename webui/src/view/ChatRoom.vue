<template>
    <el-container style="margin-left: 15%; margin-right: 15%">
        <el-main>
            <el-row type="flex" align="middle">
                <el-col :span="4">
                    <el-image :src="groupPortrait"></el-image>
                </el-col>
                <el-col :span="14" :push="1">
                    <p style="font-size: 2rem; font-weight: bold">群组名称</p>
                    <p>建群时间 | 多少人以加入</p>
                </el-col>
                <el-col :span="4">
                    <el-button type="primary" @click="toGroupInformation(1)">查看群组信息</el-button>
                </el-col>
            </el-row>
            <el-divider>聊天内容</el-divider>
            <el-row v-for="item in 6" :key="item">
                <GroupChatBox/>
            </el-row>
            <el-row style="text-align: right" type="flex" justify="space-between" align="middle">
                <el-col :span="6">
                    <el-button type="primary" @click="drawerShow = true">发送消息</el-button>
                </el-col>
                <el-col :span="12">
                    <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
                </el-col>
            </el-row>
        </el-main>

        <!--侧边栏-->
        <el-aside style="margin-top: 40px; overflow: hidden">
            <el-row style="font-weight: bold; font-size: 1.2rem">
                管理员
            </el-row>
            <el-row :gutter="20">
                <el-col :span="6" v-for="item in 5" :key="item">
                    <el-image :src="groupPortrait" style="margin-top: 20px"></el-image>
                </el-col>
            </el-row>

            <el-divider></el-divider>

            <el-row style="font-weight: bold; font-size: 1.2rem">
                群成员
            </el-row>
            <el-row :gutter="20" style="height: 600px; overflow: scroll">
                <el-col :span="6" v-for="item in 45" :key="item">
                    <el-image :src="groupPortrait" style="margin-top: 20px"></el-image>
                </el-col>
            </el-row>
        </el-aside>

        <!--聊天信息出入抽屉-->
        <el-drawer title="请输入您的聊天信息" direction="btt" :visible.sync="drawerShow">
            <el-row>
                <el-col :offset="1" :span="22">
                    <el-input type="textarea" :rows="6" v-model="chatText"></el-input>
                </el-col>
            </el-row>
            <el-row style="margin-top: 20px; text-align: right">
                <el-col :span="22">
                    <el-button type="primary" @click="sendMessage">发送</el-button>
                </el-col>
            </el-row>
        </el-drawer>
    </el-container>
</template>

<script>
    import router from "../router";
    import GroupChatBox from "../components/group/GroupChatBox";

    export default {
        name: "ChatRoom",
        components: {
            GroupChatBox
        },
        data() {
            return {
                groupPortrait: "http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg",
                chatText: '',
                drawerShow: false
            }
        },
        methods: {
            toGroupInformation(group_id) {
                console.log(group_id);
                router.push({path: "/group/group-information"});
            },
            sendMessage() {
                console.log(this.chatText);
                this.drawerShow = false;
            }
        }
    }
</script>

<style scoped>

</style>