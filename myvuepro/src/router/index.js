import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/login',
            name: 'login',
            meta: {
                title: 'Login - 登录',
                hideInMenu: true,
              },
            component: () => import('@/views/login.vue')
        },
        {
            path: '/content',
            name: 'tableData',
            meta: {
                title: 'table - 表格数据',
                hideInMenu: true,
              },
            component: () => import('@/views/content.vue')
        },
        {
            path: '/navigation',
            name: 'navigation',
            meta: {
                title: 'navigation - 侧栏',
                hideInMenu: 'true'
            },
            component: () => import('@/views/navigation.vue')
        }
    ]
})
