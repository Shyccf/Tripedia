import React from "react";
import Carousel from "../../components/Carousel";
import { Container } from "@mui/material";

const slides = [
  {
    label: "San Francisco – Oakland Bay Bridge, United States",
    imgPath: "https://images.unsplash.com/photo-1537944434965-cf4679d1a598",
  },
  {
    label: "Bird",
    imgPath: "https://images.unsplash.com/photo-1538032746644-0212e812a9e7",
  },
  {
    label: "Bali, Indonesia",
    imgPath: "https://images.unsplash.com/photo-1537996194471-e657df975ab4",
  },
  {
    label: "Goč, Serbia",
    imgPath: "https://images.unsplash.com/photo-1512341689857-198e7e2f3ca8",
  },
  {
    label: "San Francisco – Oakland Bay Bridge, United States2",
    imgPath: "https://images.unsplash.com/photo-1537944434965-cf4679d1a598",
  },
  {
    label: "Bird2",
    imgPath: "https://images.unsplash.com/photo-1538032746644-0212e812a9e7",
  },
  {
    label: "Bali, Indonesia2",
    imgPath: "https://images.unsplash.com/photo-1537996194471-e657df975ab4",
  },
  {
    label: "Goč, Serbia2",
    imgPath: "https://images.unsplash.com/photo-1512341689857-198e7e2f3ca8",
  },
];

const Home = () => {
  return (
    <Container maxWidth="xl">
      <Carousel>
        {slides.map((s) => {
          return <img src={s.imgPath}  key={s.label} />;
        })}
      </Carousel>
    </Container>
  );
};

export default Home;
