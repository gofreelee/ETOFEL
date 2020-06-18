<template>
    <div class="openCourseWrapper">
        <el-form ref="search_form" :inline="true" :model="searchCondition" class="demo-form-inline">
            <el-form-item label="群名称">
                <el-input v-model="searchCondition.group_title" placeholder="群名称"></el-input>
            </el-form-item>
            <el-form-item label="创建日期">
                <el-date-picker
                    v-model="searchCondition.searchDate"
                    type="date"
                    placeholder="选择日期">
                </el-date-picker>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSearch">查询</el-button>
            </el-form-item>
        </el-form>
        <el-table
            ref="multipleTable"
            :data="tableData"
            tooltip-effect="dark"
            style="width: 100%"
            @selection-change="handleSelectionChange">
            <el-table-column
                type="selection"
                width="55">
            </el-table-column>
            <el-table-column
                prop=""
                label="标题"
                width="160">
            </el-table-column>
            <el-table-column
                prop=""
                label="描述"
                width="190">
            </el-table-column>
            <el-table-column
                prop=""
                label="创建日期"
                width="150"
                >
            </el-table-column>
            <el-table-column
                prop=""
                label="创建人"
                width="130"
                >
            </el-table-column>
            <el-table-column
                prop=""
                label="群组人数"
                width="130"
                >
            </el-table-column>
            <el-table-column
                prop=""
                label="管理员人数"
                >
            </el-table-column>
        </el-table>
        <div class="btn_group">
            <el-button type="danger" size="small" @click="_close">关闭</el-button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'managerGroup',
    data() {
        return {
            searchCondition: {
                group_title: '',
                searchDate: ''
            },
            tableData: []
        }
    },
    mounted() {
        
    },
    methods: {
        // 表格 action 监听（checkbox 选择）
        handleSelectionChange(value) {
            console.log(value)
        },
        // 获取 table 数据
        // 查询
        onSearch() {

        },
        // 关闭
        _close() {
            console.log('close')
        }
    },
}
</script>

<style scoped>
.openCourseWrapper {
    width: 70%;
    margin: 0 auto;
    margin-top: 40px;
    margin-bottom: 60px;
}
.btn_group {
    margin-top: 15px;
}
.el-table .warning-row {
    background: oldlace;
}
</style>