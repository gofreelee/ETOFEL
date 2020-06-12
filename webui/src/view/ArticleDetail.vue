<template>
    <el-container style="margin-left: 15%; margin-right: 15%">
        <el-main style="margin-right: 20px">
            <el-image :src="articleImg" style="height: 400px"></el-image>
            <el-row class="article-title">
                这里是文章标题
            </el-row>
            <el-row class="article-info">
                发布时间：22:00 2020-6-7
            </el-row>
            <el-row class="article-info">
                发布人：alex
            </el-row>
            <el-row class="article-info" type="flex" align="middle">
                <el-col :span="3">
                    <i class="fa fa-heart"/> 点赞 28
                </el-col>
                <el-col :span="3">
                    <i class="fa fa-share-square-o"/> 转发 28
                </el-col>
                <el-col :span="12">
                    发送至
                    &nbsp;<i class="fa fa-weixin"/>
                    &nbsp;<i class="fa fa-qq"/>
                    &nbsp;<i class="fa fa-weibo"/>
                    &nbsp;<i class="fa fa-tencent-weibo"/>
                </el-col>
            </el-row>
            <el-divider>文章内容</el-divider>
            <el-row class="article">
                几乎在每次托福考试之后，我都可以听到某些同学对着细节题扼腕长叹道：“我怎么这样的题也会错!”是的，我们在上课的时候，反复听着老师一遍遍地说细节题的解题方法，自以为这些方法都早已烂熟于心，但是在做题的过程中却屡屡出错。这是为什么呢?

                要解答这个问题，我们首先就要找到出错的地方，然后对症下药。那么接下来，由新东方在线托福教研中心老师为大家介绍考生经常会出错的地方。这些地方大致可以分为以下三种情况：

                一、不会定位
                提及定位，恐怕所有的同学都会说定位非常简单。但是，是不是所有同学都可以准确定位，并且高效地完成阅读中的细节题呢?其实不然，我们来看以下这道出自TPO16套的细节题：
                According to paragraph 2, how did Middle Eastern shop owners treat their workers?
                有的同学一看到这个题目，第一反应就是用Middle Eastern shop owners去原文定位，很快可以找到本段的第二句话：Production was generally in the hands
                of skilled individual artisans doing piecework under the tutelage of a master who was also the shop
                owner.但是，当我们读过这句话之后，发现它并没有回答前面的问题，于是我们开始纠结。在将这句话反反复复看了好几遍却仍然找不到答案之后，我们才开始继续往下看。有些同学甚至为了寻找答案干脆将整段看一遍。但是，如果大家一开始在定位的时候，用的是shop
                owner, treat,和workers来定位，大家就很容易就知道这道题是在问shop
                owner和workers之间的关系，在读原文第二句话时很快就能发现这句话并没有提到任何与关系相关的单词。于是往下寻找和关系有关的词或者句子。我们很快便会看到后面有一个In these shops
                differences of rank were blurred，也就是说在这些shop里等级区别模糊了。这不正是说明了owner和worker之间的这种等级关系么?因此，不难确定，这句话才是我们要找的答案。

                二、纠结选项
                在选项上纠结的这类同学，在对文章的定位上一般不存在问题。他们的问题是，在找到原文之后，却觉得几个选项在文章中都出现过，于是一遍遍地再来读文章。这样做既费时费力，又不一定能对。
                对于这些同学，新东方在线托福教研中心老师提醒大家，你们需要谨记的就是“符合原文”四个大字。
                例如TPO2中的一道题，假定通过定位我们已经找到了原文中答案所在的句子：the presence of a fluke1 and blowhole2 cannot disguise their
                affinities with land dwelling mammals.这道题对应有两个选项：
                A It clearly indicates that cetaceans are mammals.
                B It cannot conceal the fact that cetaceans are mammals.
                这时爱纠结的同学们又开始纠结了，两个都说cetaceans是mammals，怎么选?亲爱的同学们，你们首先要搞清楚原文到底说的是什么，是说“暗示”还是说“不能掩盖”?如果是说暗示，那就选a，因为a选项清楚的有一个indicate，如果是说不能掩盖，那就选b，
                因为b选项中有一个cannot conceal。
            </el-row>
            <el-divider>文章内容</el-divider>
            <el-row>
                文章评论 200
            </el-row>
            <el-row style="margin-top: 20px; margin-bottom: 20px">
                <el-input type="textarea" :rows="8" placeholder="请输入您的评论" v-model="comment"></el-input>
            </el-row>
            <el-row>
                <el-col :span="8" :push="16" style="text-align: right">
                    <el-button type="success">提交评论</el-button>
                </el-col>
            </el-row>

            <ArticleComment v-for="item in 4" :key="item"/>

            <el-row style="text-align: right; margin-top: 20px">
                <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
            </el-row>
        </el-main>

        <el-aside>
            <!--最新公开课-->
            <el-row type="flex" align="middle" style="font-size: 1.3rem; margin-top: 40px">
                <el-col :span="18">
                    最新公开课
                </el-col>
                <el-col :span="6">
                    <el-button type="text" icon="el-icon-refresh">换一批</el-button>
                </el-col>
            </el-row>
            <HomeCourse v-for="item in 4" :key="item"/>

            <!--名师推荐-->
            <el-row type="flex" align="middle" style="font-size: 1.3rem; margin-top: 40px">
                <el-col :span="18">
                    名师推荐
                </el-col>
                <el-col :span="6">
                    <el-button type="text" icon="el-icon-refresh">换一批</el-button>
                </el-col>
            </el-row>
            <ArticleTeacher v-for="item in 4" :key="item"/>
        </el-aside>
    </el-container>
</template>

<script>
    import HomeCourse from "../components/home/HomeCourse";
    import ArticleTeacher from "../components/article/ArticleTeacher";
    import ArticleComment from "../components/article/ArticleComment";

    export default {
        name: "ArticleDetail",
        components: {
            HomeCourse,
            ArticleTeacher,
            ArticleComment
        },
        data() {
            return {
                articleImg: "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1591944823&di=9eb2bd5cc79d50a8955c205c2fb4150a&src=http://a3.att.hudong.com/14/75/01300000164186121366756803686.jpg",
                comment: ''
            }
        }
    }
</script>

<style scoped>
    .article-title {
        font-size: 2.6rem;
        margin-top: 20px;
        font-weight: bold;
    }

    .article-info {
        margin-top: 20px;
    }

    .article {
        margin-top: 30px;
        line-height: 1.8;
        font-size: 1.1rem;
    }
</style>