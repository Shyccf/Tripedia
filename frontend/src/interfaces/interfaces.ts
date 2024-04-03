interface Slide {
  label: string;
  imgPath: string;
}

interface CarouselProps {
  slides: Slide[];
  buttons?: boolean;
  thumbnail?: boolean;
}

interface HotSpot {
  name: string;
  imgPath: string;
}

interface HotSpotProps {
  hotSpot: HotSpot;
}

interface Post {
  title: string;
  content: string;
  location: string;
  author: string;
  date: string;
  views: string;
  likes: string;
}

interface PostProps {
  post: Post;
}
