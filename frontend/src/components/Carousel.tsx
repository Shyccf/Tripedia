import { Box, IconButton } from "@mui/material";
import KeyboardArrowLeftIcon from "@mui/icons-material/KeyboardArrowLeft";
import KeyboardArrowRightIcon from "@mui/icons-material/KeyboardArrowRight";

const Carousel = ({ children: slides }) => {
  return (
    <>
      <Box
        sx={{
          overflow: "hidden",
          position: "relative",
          maxWidth: "100%",
          marginTop: 4,
        }}
      >
        <Box
          display="flex"
          alignItems="center"
          sx={{ objectFit: "cover", maxHeight: 500 }}
        >
          {slides}
        </Box>

        <Box
          sx={{
            inset: 0,
            position: "absolute",
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
            padding: 2,
          }}
        >
          <IconButton
            aria-label="left button"
            color="primary"
            sx={{
              padding: 0.5,
              borderRadius: "50%",
              backgroundColor: "primary.light",
            }}
          >
            <KeyboardArrowLeftIcon />
          </IconButton>
          <IconButton
            aria-label="right button"
            color="primary"
            sx={{
              padding: 0.5,
              borderRadius: "50%",
              backgroundColor: "primary.light",
            }}
          >
            <KeyboardArrowRightIcon />
          </IconButton>
        </Box>
      </Box>
    </>
  );
};

export default Carousel;
