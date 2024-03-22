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
          position: "relative",
          overflow: "hidden",
          marginTop: 4,
          maxWidth: "100%",
        }}
      >
        {/* images */}
        <Box
          display="flex"
          alignItems="start"
          sx={{
            transition: "transform 0.5s ease-in-out",
            transform: `translateX(-${curPage * 100}%) scale(1)`,
            width: "100%",
            height: 600,
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

        {/* small-image navigators */}
        <Box
          sx={{
            position: "absolute",
            bottom: 6,
            left: 0,
            right: 0,
            display: "flex",
            justifyContent: "center",
          }}
        >
          <Box
            sx={{
              display: "flex",
              gap: 2,
              justifyContent: "center",
              alignItems: "center",
              width: 100,
              height: 60,
            }}
          >
            {slides.map((slide, i) =>
              React.cloneElement(slide, {
                key: i,
                style: {
                  filter: curPage === i ? "" : "grayscale(70%)",
                  transition: "all 0.5s ease-in-out",
                  border: curPage === i ? "5px solid red" : "",
                },
                onClick: () => {
                  setCurPage(i);
                },
              })
            )}
          </Box>
        </Box>
      </Box>
    </>
  );
};

export default Carousel;
