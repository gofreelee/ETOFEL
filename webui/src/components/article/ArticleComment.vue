<template>
    <el-container>
        <el-main style="padding-top: 0; padding-bottom: 0">
            <el-row type="flex" align="middle">
                <el-col :span="3">
                    <el-image :src="portrait"></el-image>
                </el-col>
                <el-col :span="18">
                    <el-row style="margin-bottom: 10px">
                        余坚
                    </el-row>
                    <el-row>
                        djffklsdjfkdslkjfkdhfkl
                    </el-row>
                </el-col>
                <el-col :span="3">
                    2020-6-12
                </el-col>
            </el-row>
            <el-divider></el-divider>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "ArticleComment",
        data() {
            return {
                portrait: 'http://b-ssl.duitang.com/uploads/item/201812/7/2018127203650_KvXLM.thumb.700_0.jpeg'
            }
        }
    }
</script>

<style scoped>
    .el-divider--horizontal {
        margin-bottom: 0;
    }
</style>