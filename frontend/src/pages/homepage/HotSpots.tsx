import React from "react";
import SpotTag from "../../components/SpotTag";
import { Box, Button, Typography } from "@mui/material";

const hotSpots = [
  {
    name: "Niagara Falls",
    imgPath:
      "https://upload.wikimedia.org/wikipedia/commons/a/ab/3Falls_Niagara.jpg",
  },
  {
    name: "Banff National Park",
    imgPath:
      "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Moraine_Lake_17092005.jpg/640px-Moraine_Lake_17092005.jpg",
  },
  {
    name: "Quebec City",
    imgPath:
      "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Ch%C3%A2teau_Frontenac%2C_Quebec_city%2C_Canada.jpg/1200px-Ch%C3%A2teau_Frontenac%2C_Quebec_city%2C_Canada.jpg",
  },
];

const HotSpots = () => {
  return (
    <div>
      <Box
        sx={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
          marginTop: "6px",
        }}
      >
        <Typography
          variant="h6"
          component="h2"
          color="primary.main"
          sx={{ textTransform: "uppercase" }}
        >
          Hottest Spots
        </Typography>
        <Button
          variant="text"
          sx={{ color: "primary.dark", fontSize: "0.7rem" }}
        >
          Learn More
        </Button>
      </Box>

      {hotSpots.map((hotSpot) => (
        <SpotTag hotSpot={hotSpot} />
      ))}
    </div>
  );
};

export default HotSpots;
