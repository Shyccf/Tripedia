import { RouterProvider, createBrowserRouter } from "react-router-dom";
import "./App.css";
import AppLayout from "./components/AppLayout";
import Blog from "./pages/blog/Blog";
import CreateBlog from "./pages/blog/CreateBlog";
import BlogOverview from "./pages/blog/BlogOverview";
import City from "./pages/trip/City";
import Trip from "./pages/trip/Trip";
import User from "./pages/user/User";
import Home from "./pages/homepage/Home";
import { ThemeProvider } from "@emotion/react";
import { theme } from "./utils/theme";
import ErrorPage from "./pages/error/ErrorPage";

const router = createBrowserRouter([
  {
    element: <AppLayout />,
    errorElement: <ErrorPage />,
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
  return (
    <ThemeProvider theme={theme}>
      <RouterProvider router={router} />
    </ThemeProvider>
  );
}

export default App;
