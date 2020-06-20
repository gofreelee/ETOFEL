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
                width="100">
            </el-table-column>
            <el-table-column
                prop="cosTeacher"
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
                prop="cosEndDate"
                label="结束日期"
                width="160"
                >
            </el-table-column>
            <el-table-column
                prop="cosStage" 
                label="上课周期"
                width="120"
                >
            </el-table-column>
            <el-table-column
                prop="cosStartTime"
                label="上课时间"
                width="120"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                prop="cosFee"
                label="课程费用"
                width="130"
                >
            </el-table-column>
            <el-table-column
                fixed="right"
                prop="cosStatus"
                label="课程状态"
                width="160"
                >
                <template slot-scope="scope">
                    <p v-if='scope.row.cosStatus === "停课" ' style="color: red;">{{ scope.row.cosStatus }}</p>
                    <p v-else>{{ scope.row.cosStatus }}</p>
                </template>
            </el-table-column>
        </el-table>
        <div class="btn_group">
            <el-button type="success" size="small" @click="_close">关闭</el-button>
            <el-button type="primary" size="small" @click="_restore">恢复</el-button>
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
            selectedCourseType: '',
            selectedList: ''
        }
    },
    mounted() {
        this.getDataSource()
    },
    methods: {
        // 勾选 checkbox
        handleSelectionChange(value) {
            console.log(value)
            this.selectedList = value
            this.selectedID = []
            value.forEach(item => {
                this.selectedID.push(item.cosId)
            })
        },
        // 获取数据源
        getDataSource() {
            let url =  `/course/course/getAllCourseInfo`
            this.$axios(url).then(res => {
                console.log('数据源：', res)
                this.tableData = res.data 
                res.data.forEach(item => {
                    this.searchCondition.course_type_list.push(item.cosCategory)
                    this.searchCondition.teacher_list.push(item.cosTeacher)
                })
                this.searchCondition.course_type_list = new Set(this.searchCondition.course_type_list)
                this.searchCondition.teacher_list = new Set(this.searchCondition.teacher_list)
                console.log(this.searchCondition.course_type_list)
            }).catch(err => {
                console.log('获取数据失败：', err)
            })
        },
        // 搜索
        onSearch() {
            let url =  `/course/course/selectCourseDynamic`
            this.$axios.get(url, {
                params: {
                    cosTitle: this.searchCondition.course_title,
                    cosCategory: this.selectedCourseType,
                    cdtTchUsername: this.selectedTeacher
                }
            }).then(res => {
                console.log('文章数据源：', res)
                if(res.data) {
                    this.tableData = res.data 
                }
            }).catch(err => {
                console.log('获取文章数据失败：', err)
            })
        },
        // 关闭
        _close() {
            let body = { cosIds: this.selectedID }
            this.$axios({
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                url: '/course/course/closeCourse',
                data: JSON.stringify(body)
            }).then(() => {
                console.log('关闭课程成功！')
                this.selectedID.forEach(item => {
                    this.tableData[item - 1].cosStatus = '停课'
                })
            }).catch(err => {
                console.log('关闭课程失败...', err)
            })
        },
        // 恢复
        _restore() {
            let body = { cosIds: this.selectedID }
            this.$axios({
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                url: '/course/course/recoverCourse',
                data: JSON.stringify(body)
            }).then(() => {
                console.log('恢复课程成功！')
                this.selectedID.forEach(item => {
                    this.tableData[item - 1].cosStatus = '报名中'
                })
            }).catch(err => {
                console.log('恢复课程失败...', err)
            })
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