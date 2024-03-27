import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Box, Button, IconButton } from "@mui/material";
import FavoriteIcon from "@mui/icons-material/Favorite";
import ShareIcon from "@mui/icons-material/Share";

const SpotCard = () => {
  return (
    <Card sx={{ maxWidth: 345 }}>
      <CardMedia
        component="img"
        alt="green iguana"
        sx={{
          width: "20rem",
          height: "8rem",
          objectFit: "cover",
        }} 
        image="https://upload.wikimedia.org/wikipedia/commons/a/ab/3Falls_Niagara.jpg"
      />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
          Niagara Falls
        </Typography>
        <Typography variant="body2" color="text.secondary">
          A stunning natural wonder at the border of USA and Canada, Niagara
          Falls captivates visitors with its powerful beauty and thunderous
          waters.
        </Typography>
      </CardContent>
      <CardActions
        sx={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
          padding: 2,
        }}
      >
        <Box>
          <IconButton aria-label="add to favorites">
            <FavoriteIcon />
          </IconButton>
          <IconButton aria-label="share">
            <ShareIcon />
          </IconButton>
        </Box>
        <Button variant="text">
          Learn More
        </Button>
      </CardActions>
    </Card>
  );
};

export default SpotCard;
