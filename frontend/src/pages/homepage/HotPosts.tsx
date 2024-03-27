import { Typography } from "@mui/material";
import PostCard from "../../components/PostCard";

const HotPosts = () => {
  return (
    <div>
      <Typography variant="h6" component="h2" color="primary.main">
        Hot Posts
      </Typography>
      <PostCard />
    </div>
  );
};

export default HotPosts;
