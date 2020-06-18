<template>
    <div class="openCourseWrapper">
        <el-form ref="search_form" :inline="true" :model="searchCondition" class="demo-form-inline">
            <el-form-item label="课程名称">
                <el-input v-model="searchCondition.course_title" placeholder="课程名称"></el-input>
            </el-form-item>
            <el-form-item label="讲师">
                <el-select v-model="selectedTeacher" placeholder="讲师" >
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
                label="课程名称"
                width="150">
            </el-table-column>
            <el-table-column
                prop="cosCategory"
                label="课程分类"
                width="150">
            </el-table-column>
            <el-table-column
                prop="address"
                label="讲师"
                width="160"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                prop="cosStartDate"
                label="开始日期"
                width="160"
                >
            </el-table-column>
            <el-table-column
                prop="cosStartTime"
                label="上课时间"
                show-overflow-tooltip>
            </el-table-column>
        </el-table>
        <div class="btn_group">
            <el-button type="success" size="small" @click="_close">关闭</el-button>
            <el-button type="primary" size="small" @click="_restore">恢复</el-button>
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
                teacher_list: ['raj', 'pony', 'jack'],
                course_type_list: []
            },
            selectedTeacher: '',
            selectedCourseType: ''
        }
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
            let url =  `/course/course/selectCourseDynamic`
            this.$axios(url).then(res => {
                console.log('数据源：', res)
                this.tableData = res.data 
                res.data.forEach(item => {
                    this.searchCondition.course_type_list.push(item.cosCategory) 
                })
                console.log(this.searchCondition.course_type_list)
            }).catch(err => {
                console.log('获取数据失败：', err)
            })
        },
        // 搜索
        onSearch() {
            console.log(this.searchCondition.course_title)
            console.log(this.selectedTeacher)
            console.log(this.selectedCourseType)
            console.log(this.selectedID)
        }
    },
    mounted() {
        this.getDataSource()
    },
}
</script>

<style scoped>
    .openCourseWrapper {
        width: 70%;
        margin: 0 auto;
        margin-top: 40px;
        margin-bottom: 100px;
    }
    .btn_group {
        margin-top: 15px;
    }
</style>