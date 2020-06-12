<template>
    <el-container>
        <el-main>
            <el-row>
                <el-col :lg="5" :xs="10">
                    <el-image :src="url" style="width: 120px; height: 120px" fit="fill"></el-image>
                </el-col>
                <el-col :lg="12">
                    <el-row style="font-size: 1.4rem; font-weight: bold; padding: 10px 0 0 0">
                        群组名称
                    </el-row>
                    <el-row style="padding: 10px 0 10px 0">
                        建群时间
                    </el-row>
                    <el-row>
                        djflksdjflkjsdklj
                    </el-row>
                </el-col>
                <el-col :lg="4" style="text-align: center">
                    <el-row style="padding: 10px 0 10px 0">
                        123已参加
                    </el-row>
                    <el-row style="cursor: pointer; padding-bottom: 10px" @click.native="toGroupInformation(1)">
                        群信息
                    </el-row>
                    <el-row>
                        <el-button type="success" @click="toChatRoom(1)">聊天室</el-button>
                    </el-row>
                </el-col>
            </el-row>
            <el-row>
                <el-divider content-position="right">群组</el-divider>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import router from "../../router";

    export default {
        name: "GroupItem",
        data() {
            return {
                url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
            }
        },
        methods: {
            toGroupInformation(group_id) {
                console.log(group_id);
                router.push({path: "/group/group-information"});
            },
            toChatRoom(group_id) {
                console.log(group_id);
                router.push({path: '/group/chat-room'});
            }
        }
    }
</script>

<style scoped>

</style>