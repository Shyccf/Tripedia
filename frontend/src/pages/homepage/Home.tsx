import React from "react";
import Carousel from "../../components/Carousel";
import { Container, Grid } from "@mui/material";
import HotSpot from "./HotSpot";

const slides = [
  {
    label: "Spring",
    imgPath:
      "https://media.cnn.com/api/v1/images/stellar/prod/210316134609-01-wisdom-project-spring.jpg?q=w_4000,h_2250,x_0,y_0,c_fill",
  },
  {
    label: "Summer",
    imgPath:
      "https://www.almanac.com/sites/default/files/styles/or/public/image_nodes/summer-sunset.jpg?itok=fRvO1hlC",
  },
  {
    label: "Autumn",
    imgPath:
      "https://i0.wp.com/cms.babbel.news/wp-content/uploads/2020/09/CM_MagazineHeader_FallVsAutumn.png",
  },
  {
    label: "Winter",
    imgPath:
      "https://hips.hearstapps.com/hmg-prod/images/first-day-of-winter-solstice-2021-1638278570.jpg",
  },
  {
    label: "Universe",
    imgPath:
      "https://bigthink.com/wp-content/uploads/2021/10/greg-rakozy-oMpAz-DN-9I-unsplash-e1633352959373.jpg",
  },
];

const Home = () => {
  return (
    <Container maxWidth="lg" sx={{ border: "4px red solid" }}>
      <Carousel slides={slides} />

      <Grid container columnSpacing={2} marginTop={6}>
        <Grid item xs={6} md={3}>
          <HotSpot />
        </Grid>
        <Grid item xs={6} md={9}>
          <div>Hot Blogs</div>
        </Grid>
      </Grid>
    </Container>
  );
};

export default Home;
