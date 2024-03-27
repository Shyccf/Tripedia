import { Box, Paper, Typography } from "@mui/material";
import React from "react";

const SpotTag: React.FC<HotSpotsProps> = ({ hotSpots }) => {
  return (
    <>
      {hotSpots.map((hotSpot) => (
        <Paper
          key={hotSpot.name}
          elevation={5}
          sx={{ marginY: "1rem", borderRadius: "1rem" }}
        >
          <Box
            sx={{
              position: "relative",
              width: "100%",
              height: "7rem",
              backgroundImage: `url("${hotSpot.imgPath}")`,
              backgroundSize: "cover",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
              filter: "grayscale(30%)",
              borderRadius: "1rem",
            }}
          >
            <Typography
              component="h2"
              variant="h5"
              color="primary.contrastText"
              sx={{
                textShadow: "2px 2px 4px rgba(0,0,0,0.7)",
              }}
            >
              {hotSpot.name}
            </Typography>
          </Box>
        </Paper>
      ))}
    </>
  );
};

export default SpotTag;
