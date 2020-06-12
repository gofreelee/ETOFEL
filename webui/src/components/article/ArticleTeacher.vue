<template>
    <el-card style="margin-top: 20px">
        <el-row>
            <el-col :span="8">
                <el-image :src="portrait"></el-image>
            </el-col>
            <el-col :span="15" :push="1">
                <el-row style="font-size: 1.2rem; margin-top: 10px; margin-bottom: 15px">
                    余坚老师
                </el-row>
                <el-row>
                    介绍
                </el-row>
            </el-col>
        </el-row>
    </el-card>
</template>

<script>
    export default {
        name: "ArticleTeacher",
        data() {
            return {
                portrait: 'http://img2.imgtn.bdimg.com/it/u=1311392388,1324290206&fm=26&gp=0.jpg'
            }
        }
    }
</script>

<style scoped>

</style>