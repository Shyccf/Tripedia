import { Box, IconButton } from "@mui/material";
import KeyboardArrowLeftIcon from "@mui/icons-material/KeyboardArrowLeft";
import KeyboardArrowRightIcon from "@mui/icons-material/KeyboardArrowRight";
import React, { useState } from "react";

interface CarouselProps {
  children: JSX.Element[];
}

const Carousel: React.FC<CarouselProps> = ({ children: slides }) => {
  const [curPage, setCurPage] = useState(0);

  const prev = () => {
    const newPage = curPage === 0 ? slides.length - 1 : curPage - 1;
    console.log(`Prev: ${newPage}`);
    setCurPage(newPage);
  };

  const next = () => {
    const newPage = curPage === slides.length - 1 ? 0 : curPage + 1;
    console.log(`Next: ${newPage}`);
    setCurPage(newPage);
  };
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
        {/* images */}
        <Box
          display="flex"
          alignItems="center"
          sx={{
            maxHeight: 500,
            transition: "transform 0.5s ease-in-out",
            transform: `translateX(-${curPage * 100}%) scale(1)`,
            "&:hover": {
              transform: "scale(1.1)",
            },
          }}
        >
          {slides}
        </Box>

        {/* buttons */}
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
          {/* prev button */}
          <IconButton
            onClick={prev}
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

          {/* next button */}
          <IconButton
            onClick={next}
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
