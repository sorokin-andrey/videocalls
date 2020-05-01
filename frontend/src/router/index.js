import Vue from 'vue'
import VueRouter from  'vue-router'
import Login from '../components/Login.vue'
import Conference from '../components/Conference.vue'

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "home",
        component: Login
    },
    {
        path: '/conference',
        name: 'conference',
        component: Conference
    }
]

const router = new VueRouter({
    mode: 'history',
    routes
})

export default router