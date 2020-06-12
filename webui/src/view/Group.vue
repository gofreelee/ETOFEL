<template>
    <el-container>
        <el-header>
            <el-row class="header" type="flex" align="middle">
                <el-col :span="3">
                    全部
                </el-col>
                <el-col :span="3">
                    名师课堂群
                </el-col>
                <el-col :span="3">
                    同城群
                </el-col>
                <el-col :span="3">
                    结伴备考群
                </el-col>
                <el-col :span="4" :offset="2">
                    <el-input placeholder="请输入群聊名" prefix-icon="el-icon-search"/>
                </el-col>
            </el-row>
        </el-header>
        <el-main style="padding-left: 15%; padding-right: 15%">
            <el-row v-for="item in 4" :key="item">
                <el-col :span="12">
                    <GroupItem/>
                </el-col>
                <el-col :span="12">
                    <GroupItem/>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="9" :offset="15">
                    <el-pagination background layout="prev,pager,next" :total="1000"/>
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    import GroupItem from "../components/group/GroupItem";

    export default {
        name: "Group",
        components: {
            GroupItem
        }
    }
</script>

<style scoped>
    .header {
        margin-top: 10px;
        background-color: #f0f0f0;
        padding: 15px 15% 15px 17%;
        text-align: center;
        font-size: 1.1rem;
    }
</style>