<template>
    <el-container style="margin-left: 15%; margin-right: 15%">
        <el-main>
            <el-row type="flex" align="middle">
                <el-col :span="4">
                    <el-image :src="group.grpPortrait" fit="fill"/>
                </el-col>
                <el-col :span="14" :push="1">
                    <p style="font-size: 2rem; font-weight: bold">{{group.grpName}}</p>
                    <p>
                        建群时间: {{group.grpCreateTime}}
                        <el-divider direction="vertical"/>
                        {{groupMembers}}人已加入
                    </p>
                </el-col>
                <el-col :span="4">
                    <el-button type="primary" @click="toGroupInformation(1)">查看群组信息</el-button>
                </el-col>
            </el-row>

            <el-divider>聊天内容</el-divider>
            <el-row v-for="item in messages" :key="item.gmsId">
                <GroupChatBox :message="item"/>
            </el-row>

            <el-row style="text-align: right" type="flex" justify="space-between" align="middle">
                <el-col :span="6">
                    <el-button type="primary" @click="drawerShow = true">发送消息</el-button>
                </el-col>
                <el-col :span="12">
                    <el-pagination background layout="prev, pager, next"
                                   :total="messageNumber"
                                   :page-size="6"
                                   @current-change="pageChange"/>
                </el-col>
            </el-row>
        </el-main>

        <!--侧边栏-->
        <el-aside style="margin-top: 40px; overflow: hidden">
            <el-row style="font-weight: bold; font-size: 1.2rem">
                管理员
            </el-row>
            <el-row :gutter="20">
                <el-col :span="6" v-for="item in admins" :key="item.gmbUsername">
                    <el-image :src="item.userPortrait" style="margin-top: 20px"></el-image>
                </el-col>
            </el-row>

            <el-divider></el-divider>

            <el-row style="font-weight: bold; font-size: 1.2rem">
                群成员
            </el-row>
            <el-row :gutter="20" style="height: 600px; overflow: scroll">
                <el-col :span="6" v-for="item in members" :key="item.gmbUsername">
                    <el-image :src="item.userPortrait" style="margin-top: 20px"></el-image>
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
                chatText: '',
                drawerShow: false,
                grpId: '',
                group: '',
                groupMembers: '',
                admins: [],
                members: [],
                messageNumber: 0,
                currentPage: 1,
                messages: ''
            }
        },
        methods: {
            toGroupInformation(group_id) {
                console.log(group_id);
                router.push({path: "/group/group-information", query: {group_id: this.grpId}});
            },
            getInformation() {
                let config = {
                    method: 'get',
                    url: '/group/group/searchGroupInfo?grpId=' + this.grpId,
                };

                this.$axios(config).then(res => {
                    this.group = res.data.baseInfo;
                    this.groupMembers = res.data.groupMembers;
                    this.admins = res.data.managers;
                    this.members = res.data.members;
                    this.isMemberOrAdmin();
                }).catch(function (error) {
                    console.log(error);
                });
            },
            getMessageNumber() {
                let config = {
                    method: 'get',
                    url: '/group/group/getMessageNum?grpId=' + this.grpId,
                };

                this.$axios(config).then(res => {
                    this.messageNumber = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            getMessageOnePage() {
                let config = {
                    method: 'get',
                    url: '/group/group/getMessage?grpId=' + this.grpId + '&index=' + (this.currentPage - 1),
                };

                this.$axios(config).then(res => {
                    this.messages = res.data;
                }).catch(function (error) {
                    console.log(error);
                });

            },
            sendMessage() {
                console.log(this.chatText);
                this.drawerShow = false;

                let data = new FormData();
                data.append('gmsGrpId', this.grpId);
                data.append('gmsUsername', sessionStorage.getItem("username"));
                data.append('gmsContext', this.chatText);

                let config = {
                    method: 'post',
                    url: '/group/group/sendMessage',
                    data: data
                };

                this.$axios(config).then(res => {
                    if (res.data === 1) {
                        alert("发送成功");
                        this.chatText = '';
                        this.getMessageNumber();
                        this.getMessageOnePage();
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            },
            pageChange(currentPage) {
                this.currentPage = currentPage;
                this.getMessageOnePage();
            }
        },
        mounted() {
            this.grpId = this.$route.query.group_id;
            this.getInformation();
            this.getMessageNumber();
            this.getMessageOnePage();
        }
    }
</script>

<style scoped>

</style>