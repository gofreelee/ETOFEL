<template>
    <el-container class="box">
        <el-aside style="padding: 20px 0 20px 0">
            <el-image :src="img"></el-image>
        </el-aside>
        <el-main>
            <el-row type="flex" align="middle">
                <el-col style="font-weight: bold; font-size: 1.4rem" :span="16">
                    托福口语5大技巧
                </el-col>
                <el-col :span="4" v-if="!isMine">
                    作者：猴子
                </el-col>
            </el-row>
            <el-row style="padding: 20px 0 20px 0">
                绝对定位的元素的位置相对于最近的已定位祖先元素，如果元素没有已定位的祖先元素，那么它的位置相对于最初的包含块。
                对于定位的主要问题是要记住每种定位的意义。所以，现在让我们复习一下学过的知识吧：相对定位是“相对于”元素在文档中的初始位置，而绝对定位是“相对于”最近的已定位祖先元素，如果不存在已定位的祖先元素，那么“相对于”最初的包含块。
                注释：根据用户代理的不同，最初的包含块可能是画布或 HTML 元素。
                提示：因为绝对定位的框与文档流无关，所以它们可以覆盖页面上的其它元素。可以通过设置 z-index 属性来控制这些框的堆放次序。
            </el-row>
            <el-row type="flex" align="middle">
                <el-col :span="6">
                    所属分类：听力
                </el-col>
                <el-col :span="12">
                    发布日期：2020-12-12
                </el-col>
                <el-col :span="4" v-if="isMine">
                    <el-button type="danger">删除文章</el-button>
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "ArticleItem",
        props: {
            isMine: Boolean
        },
        data() {
            return {
                img: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592110903792&di=acf15564e2feab8f2bfd236a69c0fe58&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F038044356fa333d6ac725794841ade0.jpg'
            }
        }
    }
</script>

<style scoped>
    .box {
        margin-bottom: 20px;
        border-bottom: solid 1px #8c939d;
    }
</style>