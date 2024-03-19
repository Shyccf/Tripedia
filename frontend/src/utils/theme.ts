import { createTheme } from "@mui/material";

export const theme = createTheme({
  palette: {
    mode: "light",
    primary: {
      main: "#43a047",
      contrastText: "#fafafa",
    },
    secondary: {
      main: "#00695c",
    },
    background: {
      default: "fafafa",
    },
  },
});
