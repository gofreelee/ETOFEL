<template>
    <el-container>
        <el-aside style="width: 100px; padding: 20px 0 20px 0">
            <img :src="group.grpPortrait" alt="logo"/>
        </el-aside>
        <el-main>
            <el-row type="flex">
                <el-col :span="16" style="color: #68BF4A; font-size: 1.2rem; cursor: pointer"
                        @click.native="toGroupInformation">
                    {{group.grpName}}
                </el-col>
            </el-row>
            <el-row style="margin-top: 8px">
                {{group.grpDescription.substring(0,40) + " ......"}}
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import router from "../../router";

    export default {
        name: "HomeGroup",
        props: {
            group: Object
        },
        methods: {
            toGroupInformation() {
                router.push({path: '/group/group-information', query: {group_id: this.group.grpId}});
            },
        }
    }
</script>

<style scoped>
    .el-aside {
        overflow: hidden;
    }

    .el-aside img {
        width: 100px;
        height: 100px;
    }
</style>