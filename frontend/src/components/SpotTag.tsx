import { Box, Paper, Typography } from "@mui/material";
import React from "react";

const SpotTag = () => {
  return (
    <>
      <Paper elevation={5} sx={{ borderRadius: "1rem" }}>
        <Box
          sx={{
            position: "relative", // 确保Typography可以相对于这个Box定位
            width: "100%",
            height: "6rem",
            backgroundImage: `url("https://upload.wikimedia.org/wikipedia/commons/a/ab/3Falls_Niagara.jpg")`,
            backgroundSize: "cover", // 确保背景图片覆盖整个Box区域
            display: "flex", // 使用flex布局来简化居中操作
            justifyContent: "center", // 水平居中
            alignItems: "center", // 垂直居中
            filter: "grayscale(20%)",
            borderRadius: "1rem",
          }}
        >
          <Typography
            component="h2"
            variant="h5"
            color="primary.light"
            sx={{
              textShadow: "1px 1px 3px rgba(0,0,0,0.7)", // 添加文字阴影，提高可读性
            }}
          >
            Niagara Falls
          </Typography>
        </Box>
      </Paper>
    </>
  );
};

export default SpotTag;
