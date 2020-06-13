import Vue from 'vue';
import VueRouter from "vue-router";
import Home from "./view/Home";
import TofelArticle from "./view/TofelArticle";
import Group from "./view/Group";
import GroupInformation from "./view/GroupInformation";
import ChatRoom from "./view/ChatRoom";
import ArticleDetail from "./view/ArticleDetail";
import Course from "./view/Course";
import CourseDetail from "./view/CourseDetail";

Vue.use(VueRouter);

const routes = [
    {
        path: '/home',
        component: Home
    }, {
        path: '/tofel-article',
        component: TofelArticle
    }, {
        path: '/group',
        component: Group
    }, {
        path: '/group/group-information',
        component: GroupInformation
    }, {
        path: '/group/chat-room',
        component: ChatRoom
    }, {
        path: '/tofel-article/detail',
        component: ArticleDetail
    }, {
        path: '/course',
        component: Course
    }, {
        path: '/course/course-detail',
        component: CourseDetail
    }
]

export default new VueRouter({
    mode: 'history',
    routes: routes
})