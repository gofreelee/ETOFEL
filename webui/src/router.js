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
import Login from "./view/Login";
import Register from "./view/Register";
import PersonalCenter from "./view/PersonalCenter";

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
    }, {
        path: '/login',
        component: Login
    }, {
        path: '/register',
        component: Register
    }, {
        path: '/personal-center',
        component: PersonalCenter
    }
]

export default new VueRouter({
    mode: 'history',
    routes: routes
})