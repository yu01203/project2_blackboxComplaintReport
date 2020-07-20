import DashboardLayout from "@/pages/Layout/DashboardLayout.vue";

import Dashboard from "@/pages/Dashboard.vue";
import Maps from "@/pages/Maps.vue";
import UserProfile from "@/pages/UserProfile.vue";

const routes = [
  {
    path: "/",
    component: DashboardLayout,
    redirect: "dashboard",
    children: [
      {
        path: "dashboard",
        name: "Dashboard",
        component: Dashboard,
      },
      {
        path: "maps",
        name: "Maps",
        component: Maps,
      },
      {
        path: "user",
        name: "User Profile",
        component: UserProfile,
      },
    ],
  },
];

export default routes;
