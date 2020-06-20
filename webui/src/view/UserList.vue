<template>
    <div class="openCourseWrapper">
        <el-form ref="search_form" :inline="true" :model="searchCondition" class="demo-form-inline">
            <el-form-item label="用户名">
                <el-input v-model="searchCondition.user_name" placeholder="用户名"></el-input>
            </el-form-item>
            <el-form-item label="状态">
                <el-select v-model="status" placeholder="状态" >
                    <el-option v-for="(item, index) in searchCondition.teacher_list" :key="index + '_status'" :label="item" :value="item"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="等级">
                <el-select v-model="level" placeholder="等级">
                    <el-option v-for="(item, index) in searchCondition.course_type_list" :key="index + '_level'" :label="item" :value="item"></el-option>
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
                width="65">
            </el-table-column>
            <el-table-column
                prop="cosTitle"
                label="头像"
                width="80">
            </el-table-column>
            <el-table-column
                prop="cosCategory"
                label="用户名称"
                width="120">
            </el-table-column>
            <el-table-column
                prop="性别"
                label="讲师"
                width="120"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                prop="cosStartDate"
                label="邮箱"
                width="180"
                >
            </el-table-column>
            <el-table-column
                prop="cosEndDate"
                label="电话"
                width="170"
                >
            </el-table-column>
            <el-table-column
                prop="cosStage" 
                label="出生日期"
                width="130"
                >
            </el-table-column>
            <el-table-column
                prop="cosStartTime"
                label="注册日期"
                width="130"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                prop="cosFee"
                label="等级"
                width="100"
                >
            </el-table-column>
            <el-table-column
                fixed="right"
                prop="cosStatus"
                label="状态"
                >
                <template slot-scope="scope">
                    <p v-if='scope.row.cosStatus === "停课" ' style="color: red;">{{ scope.row.cosStatus }}</p>
                    <p v-else>{{ scope.row.cosStatus }}</p>
                </template>
            </el-table-column>
        </el-table>
        <div class="btn_group">
            <el-button type="success" size="small" @click="_freezing">冷冻</el-button>
            <el-button type="primary" size="small" @click="_thaw">解冻</el-button>
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
                user_name: '',
                user_status: [],
                user_level: []
            },
            selectedStatus: '',
            selectedLevel: '',
            // selectedList: ''
        }
    },
    mounted() {
        this.getDataSource()
    },
    methods: {
        // 勾选 checkbox
        handleSelectionChange(value) {
            console.log(value)
        },
        // 获取数据源
        getDataSource() {
            let total_list = []
            let url =  `/login/userlist/userlist`
            this.$axios.get(url, {
                params: {
                    state: 'normal'
                }
            }).then(res1 => {
                console.log(res1.data);
                total_list = res1.data
            }).catch(err => {
                console.log('获取失败', err)
            })
            this.$axios.get(url, {
                params: {
                    state: 'frozen'
                }
            }).then(res2 => {
                total_list.concat(res2.data)
            }).catch(err => {
                console.log('获取失败', err)
            })
            this.tableData = total_list
        },
        // 搜索
        onSearch() {
            console.log('搜索')
        },
        // 冷冻
        _freezing() {
            // let body = { cosIds: this.selectedID }
            // this.$axios({
            //     method: 'POST',
            //     headers: {
            //         'Content-Type': 'application/json'
            //     },
            //     url: '/course/course/closeCourse',
            //     data: JSON.stringify(body)
            // }).then(() => {
            //     console.log('关闭课程成功！')
            //     this.selectedID.forEach(item => {
            //         this.tableData[item - 1].cosStatus = '停课'
            //     })
            // }).catch(err => {
            //     console.log('关闭课程失败...', err)
            // })
        },
        // 解冻
        _restore() {
            // let body = { cosIds: this.selectedID }
            // this.$axios({
            //     method: 'POST',
            //     headers: {
            //         'Content-Type': 'application/json'
            //     },
            //     url: '/course/course/recoverCourse',
            //     data: JSON.stringify(body)
            // }).then(() => {
            //     console.log('恢复课程成功！')
            //     this.selectedID.forEach(item => {
            //         this.tableData[item - 1].cosStatus = '报名中'
            //     })
            // }).catch(err => {
            //     console.log('恢复课程失败...', err)
            // })
        },
        // 删除
        _delete() {
            // let url = ``
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