<template>
    <div class="openCourseWrapper">
        <el-form ref="search_form" :inline="true" :model="searchCondition" class="demo-form-inline">
            <el-form-item label="标题">
                <el-input v-model="searchCondition.course_title" placeholder="标题"></el-input>
            </el-form-item>
            <el-form-item label="发布讲师">
                <el-select v-model="selectedTeacher" placeholder="发布讲师" >
                    <el-option v-for="(item, index) in searchCondition.teacher_list" :key="index + '_teacher'" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="课程类别">
                <el-select v-model="selectedCourseType" placeholder="课程类别">
                    <el-option v-for="(item, index) in searchCondition.course_type_list" :key="index + '_type'" :label="item" :value="item"></el-option>
                </el-select>
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
                prop="cosTitle"
                label="文章标题"
                width="140">
            </el-table-column>
            <el-table-column
                prop="cosCategory"
                label="文章类别"
                width="130">
            </el-table-column>
            <el-table-column
                prop="cosTeacher"
                label="发布讲师"
                width="130"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                prop="cosStartDate"
                label="发布时间"
                width="160"
                >
            </el-table-column>
            <el-table-column
                prop="cosEndDate"
                label="收藏人数"
                width="140"
                >
            </el-table-column>
            <el-table-column
                prop="cosStage" 
                label="阅读数量"
                >
            </el-table-column>
        </el-table>
        <div class="btn_group">
            <el-button type="success" size="small" @click="_close">禁读</el-button>
            <el-button type="primary" size="small" @click="_restore">解禁</el-button>
            <el-button type="danger" size="small" @click="_delete">删除</el-button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'openCourse',
    data() {
        return {
            tableData: [],
            selectedID: [],
            searchCondition: {
                course_title: '',
                teacher_list: [],
                course_type_list: []
            },
            selectedTeacher: '',
            selectedCourseType: ''
        }
    },
    mounted() {
        this.getDataSource()
    },
    methods: {
        // 勾选 checkbox
        handleSelectionChange(value) {
            console.log(value)
            this.selectedID = []
            value.forEach(item => {
                this.selectedID.push(item.cosId)
            })
        },
        // 获取数据源
        getDataSource() {
            
        },
        // 搜索
        onSearch() {
            
        }
    }
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