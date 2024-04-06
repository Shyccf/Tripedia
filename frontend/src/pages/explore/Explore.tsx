import { Box, Container } from "@mui/material";
import Carousel from "../../components/Carousel.js";
import { slides } from "../../data/slides.js";
import TopPlaces from "./TopPlaces.js";
import FeaturedThemes from "./FeaturedThemes.js";

const Explore = () => {
  return (
    <Box sx={{ marginTop: "100px"}}>
      <Container maxWidth="lg">
        <Carousel slides={slides} thumbnail={false} height={"50vh"} />
        <TopPlaces />
        <FeaturedThemes />
      </Container>
    </Box>
  );
};

export default Explore;
