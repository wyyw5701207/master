import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
];

const router = createRouter({
  routes,
  history: createWebHistory(),
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

// // 全局前置守卫
// let hasLoadedDynamicRoutes = false;
// router.beforeEach(async (to, from, next) => {
//   // 检查是否已加载动态路由
//   if (!hasLoadedDynamicRoutes) {
//     // 未加载动态路由，执行动态路由加载逻辑
//     // 等待loadDynamicRoutes函数的结果
//     await loadDynamicRoutes();
//     // 动态路由加载完成后，继续导航
//     next();
//   } else {
//     // 已加载动态路由，直接继续导航
//     next();
//   }
// });

// 动态路由加载函数
function loadDynamicRoutes() {
  return new Promise((resolve) => {
    // 发送请求到后端获取菜单数据
    let test = {
      path: "/about",
      name: "about",
      component: "AboutView.vue",
    };
    let testList=[];
    testList.push(test);
    const routes = menuToRoutes(testList);
    for (let route of routes) {
      router.addRoute(route);
    }
    // 把hasLoadedDynamicRoutes变量的值改成true，表示已经加载过动态路由了
    hasLoadedDynamicRoutes = true;
    resolve();
  });
}
// async function loadDynamicRoutes() {
//   // 发送请求到后端获取菜单数据
//   let test = {
//     path: "/about",
//     name: "about",
//     component: "AboutView.vue",
//   };
//   let testList = [];
//   testList.push(test);
//   // 等待axios.get方法返回的Promise
//   const response = await axios.get("/api/menus");
//   // 把菜单数据转换成路由表
//   const routes = menuToRoutes(response.data);
//   for (let route of routes) {
//     router.addRoute(route);
//   }
//   // 把hasLoadedDynamicRoutes变量的值改成true，表示已经加载过动态路由了
//   hasLoadedDynamicRoutes = true;
// }

// 菜单转换成路由表的函数
function menuToRoutes(menus) {
  let callback = (component) => import("@/views/" + component);
  // 创建一个空数组用来存放路由对象
  const routes = [];
  // 遍历menus数组
  for (let menu of menus) {
    // 创建一个路由对象，把menu里面的path和name属性复制过来
    const route = {
      path: menu.path,
      name: menu.name,
    };
    // 如果menu里面有component属性，就用回调函数来返回一个动态导入的Promise，并赋值给route的component属性
    if (menu.component) {
      route.component = callback(menu.component);
    }
    // 如果menu里面有children属性，就递归调用menuToRoutes函数来生成子路由，并赋值给route的children属性
    if (menu.children) {
      route.children = menuToRoutes(menu.children);
    }
    // 把路由对象添加到数组里面
    routes.push(route);
  }
  // 返回路由数组
  return routes;
}

export default router;
