interface Slide {
  label: string;
  imgPath: string;
}

interface CarouselProps {
  slides: Slide[];
}

interface HotSpot {
  name: string;
  imgPath: string;
}

interface HotSpotsProps {
  hotSpots: HotSpot[];
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
