import Vue from 'vue'
import Router from 'vue-router'
import Questions from '@/components/Questions'
import Random from '@/components/Random'
import Grades from '@/components/Grades'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Questions',
      name: 'Questions',
      component: Questions
    },
    {
      path: '/Random',
      name: 'Random',
      component: Random
    },
    {
      path: '/Grades',
      name: 'Grades',
      component: Grades
    }
  ]
})
