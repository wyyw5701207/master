import { createRouter, createWebHistory } from "vue-router";
// import HomeView from "../views/HomeView.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import(/* webpackChunkName: "about" */ '../views/HomeView.vue')
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

// 全局前置守卫
let hasLoadedDynamicRoutes = false;
router.beforeEach((to, from, next) => {
  // 检查是否已加载动态路由
  if (!hasLoadedDynamicRoutes) {
    // 未加载动态路由，执行动态路由加载逻辑
    loadDynamicRoutes().then(() => {
      // 动态路由加载完成后，继续导航
      next();
    });
  } else {
    // 已加载动态路由，直接继续导航
    next();
  }
});

// 模拟动态路由加载函数
function loadDynamicRoutes() {
  return new Promise((resolve) => {
    // 模拟异步加载动态路由的过程
    setTimeout(() => {
      router.addRoute({
        path: "/about",
        name: "about",
        component: () =>
          // 使用default属性来获取导入的组件对象
          import("../views/AboutView.vue").default,
      });
      // 把hasLoadedDynamicRoutes变量的值改成true，表示已经加载过动态路由了
      hasLoadedDynamicRoutes = true;

      resolve();
    }, 200);
  });
}
export default router;
