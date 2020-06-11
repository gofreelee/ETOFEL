<template>
    <el-container>
        <el-main>
            <el-row style="font-size: 1.2rem" align="middle" type="flex">
                <el-col :span="21">
                    <i v-bind:class="icon"/> {{ChineseNameList[type]}} / {{type}}
                </el-col>
                <el-col :span="3">
                    <el-button type="text">全部</el-button>
                </el-col>
            </el-row>
            <hr/>
            <el-row v-for="item in 4" :key="item" type="flex" align="middle" style="line-height: 40px" :gutter="25">
                <el-col :span="1" :offset="1">
                    <i class="el-icon-search"/>
                </el-col>
                <el-col :span="20" style="font-size: 1.1rem">
                    dfjsdlkfjdfsklghfdskjfdlks
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "ArticleList",
        props: {
            type: String
        },
        data() {
            return {
                iconList: {
                    "Listening": "el-icon-headset",
                    "Speaking": "el-icon-phone-outline",
                    "Reading": "el-icon-reading",
                    "Writing": "el-icon-edit-outline",
                    "Vocabulary": "el-icon-notebook-1",
                    "Information": "el-icon-chat-line-square",
                    "Activity": "el-icon-basketball",
                    "Prediction": "el-icon-trophy"
                },
                ChineseNameList: {
                    "Listening": "听力",
                    "Speaking": "口语",
                    "Reading": "阅读",
                    "Writing": "写作",
                    "Vocabulary": "词汇",
                    "Information": "资讯",
                    "Activity": "活动",
                    "Prediction": "机经"
                }
            }
        },
        computed: {
            icon() {
                return this.iconList[this.type]
            }
        }
    }
</script>

<style scoped>

</style>