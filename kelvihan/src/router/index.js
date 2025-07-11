import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: () => import('@/views/home/index.vue')
    },
    {
      path: '/students/list',
      name: 'List',
      component: () => import('@/views/students/list/index.vue')
    },
    {
      path: '/students/info',
      name: 'Info',
      component: () => import('@/views/students/info/index.vue')
    },
    {
      path: '/students/score',
      name: 'Score',
      component: () => import('@/views/students/score/index.vue')
    },
  ],
})

export default router
