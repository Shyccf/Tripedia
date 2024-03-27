import { Box, Paper, Typography } from "@mui/material";
import PlaceIcon from "@mui/icons-material/Place";
import AccessTimeIcon from "@mui/icons-material/AccessTime";
import VisibilityIcon from "@mui/icons-material/Visibility";
import ThumbUpOffAltIcon from "@mui/icons-material/ThumbUpOffAlt";
import CreateIcon from "@mui/icons-material/Create";

const PostCard = () => {
  return (
    <Paper
      elevation={3}
      sx={{
        marginY: "1rem",
        display: "flex",
        flexDirection: {
          xs: "column",
          md: "row",
        },
      }}
    >
      <Box
        sx={{
          width: {
            xs: "auto",
            md: "22rem",
          },
          height: {
            xs: "16rem",
            md: "auto",
          },
          backgroundImage: `url("https://travel.usnews.com/images/Istvan_Kadar_Photographycity-skyline-buidings-cn-tower.jpg")`,
          backgroundSize: "cover",
          borderRadius: "0.3rem",
        }}
      ></Box>
      <Box
        sx={{
          width: "100%",
          paddingX: 2,
          paddingY: 1,
          display: "flex",
          justifyContent: "space-between",
          flexDirection: "column",
        }}
      >
        {/* title and content */}
        <Box>
          <Typography variant="h5" component="h3">
            CN Towers
          </Typography>
          <Typography marginY={2} marginX={2}>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis non
            tempor libero. Pellentesque habitant morbi tristique senectus et
            netus et malesuada...
          </Typography>
        </Box>

        <Box
          sx={{
            display: "flex",
            justifyContent: "space-between",
            alignItems: "start",
          }}
        >
          {/* location, author and date */}
          <Box
            sx={{
              display: "flex",
              justifyContent: "space-between",
              alignItems: "start",
              flexDirection: "column",
            }}
          >
            {/* location */}
            <Box
              sx={{
                display: "flex",
                gap: "0.3rem",
                justifyContent: "flex-start",
                alignItems: "center",
              }}
            >
              <PlaceIcon color="primary" />
              <Typography>Toronto, Canada</Typography>
            </Box>

            {/* author */}
            <Box
              sx={{
                display: "flex",
                gap: "0.3rem",
                justifyContent: "flex-start",
                alignItems: "center",
              }}
            >
              <CreateIcon color="primary" />
              <Typography>Kyrie</Typography>
            </Box>

            {/* date */}
            <Box
              sx={{
                display: "flex",
                gap: "0.3rem",
                justifyContent: "flex-start",
                alignItems: "center",
              }}
            >
              <AccessTimeIcon color="primary" />
              <Typography>03/27/2024</Typography>
            </Box>
          </Box>

          {/* reviews and likes */}
          <Box sx={{ alignSelf: "self-end" }}>
            <Box
              sx={{
                display: "flex",
                justifyContent: "flex-start",
                alignItems: "center",
                gap: "0.3rem",
              }}
            >
              <VisibilityIcon color="primary" />
              <Typography>500</Typography>
            </Box>
            <Box
              sx={{
                display: "flex",
                justifyContent: "flex-start",
                alignItems: "center",
                gap: "0.3rem",
              }}
            >
              <ThumbUpOffAltIcon color="primary" />
              <Typography>66</Typography>
            </Box>
          </Box>
        </Box>
      </Box>
    </Paper>
  );
};

export default PostCard;
