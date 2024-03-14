import Logo from "/images/logo.png";

const Header = () => {
  return (
    <div className="header container flex justify-between items-center mx-auto bg-slate-300 px-8">
      <img src={Logo} className="w-32 mt-4" alt="logo" />

      <div>SearchBar</div>

      <ul className="flex gap-4">
        <li>Home</li>
        <li>Trips</li>
        <li>Blogs</li>
      </ul>

      <div>userImage</div>
    </div>
  );
};

export default Header;
