import { RouterProvider, createBrowserRouter } from "react-router-dom";
import "./App.css";
import AppLayout from "./ui/AppLayout";
import Blog from "./features/blog/Blog";
import CreateBlog from "./features/blog/CreateBlog";
import BlogOverview from "./features/blog/BlogOverview";
import City from "./features/trip/City";
import Trip from "./features/trip/Trip";
import User from "./features/user/User";
import Home from "./features/homepage/Home";

const router = createBrowserRouter([
  {
    element: <AppLayout />,
    children: [
      {
        path: "/",
        element: <Home />,
      },
      {
        path: "/user",
        element: <User />,
      },
      {
        path: "/trip",
        element: <Trip />,
      },
      {
        path: "/trip/:cityId",
        element: <City />,
      },
      {
        path: "/blog",
        element: <BlogOverview />,
      },
      {
        path: "/blog/new",
        element: <CreateBlog />,
      },
      {
        path: "/blog/:blogId",
        element: <Blog />,
      },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
