import { Box, Button, Typography } from "@mui/material";
import PostCard from "../../components/PostCard";

const posts = [
  {
    title: "CN Towers",
    imgPath:
      "https://travel.usnews.com/images/Istvan_Kadar_Photographycity-skyline-buidings-cn-tower.jpg",
    content:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis non tempor libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas...",
    location: "Toronto, Canada",
    author: "David",
    date: "03/27/2024",
    views: "666",
    likes: "66",
  },
  {
    title: "Casa Loma",
    imgPath: "https://casaloma.ca/wp-content/uploads/2018/04/ABOUT.jpg",
    content:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis non tempor libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas...",
    location: "Toronto, Canada",
    author: "Yancy",
    date: "03/20/2024",
    views: "888",
    likes: "88",
  },
  {
    title: "Parliament Hill",
    imgPath: "https://www.acec.ca/images/Advocacy/05Parlim/HillGood.jpg",
    content:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis non tempor libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas...",
    location: "Ottawa, Canada",
    author: "Kyrie",
    date: "02/29/2024",
    views: "999",
    likes: "99",
  },
];

const HotPosts = () => {
  return (
    <div>
      <Box
        sx={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
        }}
      >
        <Box
          sx={{
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
          }}
        >
          <Button
            variant="text"
            component="h2"
            color="primary"
            sx={{
              color: "primary.main",
              fontSize: "1rem",
            }}
          >
            Hottest Posts
          </Button>
          <Box
            sx={{
              height: "1.5rem", 
              mx: 1, 
              borderRight: "2px solid", 
              borderColor: "primary.main", 
            }}
          />
          <Button
            variant="text"
            component="h3"
            color="primary"
            sx={{ color: "primary.dark", fontSize: "0.8rem" }}
          >
            Latest Posts
          </Button>
        </Box>
        <Button
          variant="text"
          sx={{ color: "primary.dark", fontSize: "0.7rem" }}
        >
          Learn More
        </Button>
      </Box>

      {posts.map((post) => (
        <PostCard post={post} />
      ))}
    </div>
  );
};

export default HotPosts;
