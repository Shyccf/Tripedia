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
