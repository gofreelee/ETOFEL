<template>
    <el-container>
        <el-main>
            <el-row>
                <el-col :lg="5" :xs="10">
                    <el-image :src="group.grpPortrait" style="width: 120px; height: 120px" fit="fill"></el-image>
                </el-col>
                <el-col :lg="12">
                    <el-row style="font-size: 1.4rem; font-weight: bold; padding: 10px 0 0 0">
                        {{group.grpName}}
                    </el-row>
                    <el-row style="padding: 10px 0 10px 0">
                        建群时间: {{group.grpCreateTime}}
                    </el-row>
                    <el-row>
                        {{group.grpDescription}}
                    </el-row>
                </el-col>
                <el-col :lg="4" style="text-align: center">
                    <el-row style="padding: 10px 0 20px 0">
                        {{groupMembers}}已入群
                    </el-row>
                    <el-row>
                        <el-button type="success" @click="toGroupInformation(1)">群信息</el-button>
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
        props: {
            group: Object
        },
        data() {
            return {
                groupMembers: 0
            }
        },
        methods: {
            toGroupInformation() {
                router.push({path: "/group/group-information", query: {group_id: this.group.grpId}});
            },
            getGroupMemberNumber() {
                let config = {
                    method: 'get',
                    url: '/group/group/countMembers?grpId=' + this.group.grpId,
                };

                this.$axios(config).then(res => {
                    this.groupMembers = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        mounted() {
            this.getGroupMemberNumber();
        }
    }
</script>

<style scoped>

</style>