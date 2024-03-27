import { RouterProvider, createBrowserRouter } from "react-router-dom";
import "./App.css";
import AppLayout from "./components/AppLayout";
import City from "./pages/trip/City";
import Trip from "./pages/trip/Trip";
import User from "./pages/user/User";
import Home from "./pages/homepage/Home";
import { ThemeProvider } from "@emotion/react";
import { theme } from "./utils/theme";
import ErrorPage from "./pages/error/ErrorPage";
import Post from "./pages/post/Post";
import CreatePost from "./pages/post/CreatePost";
import PostOverview from "./pages/post/PostOverview";

const router = createBrowserRouter([
  {
    element: <AppLayout />,
    path: "/",
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
        path: "/post",
        element: <PostOverview />,
      },
      {
        path: "/post/new",
        element: <CreatePost />,
      },
      {
        path: "/post/:postId",
        element: <Post />,
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
