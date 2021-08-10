export interface FooterProps {}

const Footer: React.FC<FooterProps> = () => {
  return (
    <footer className='absolute bottom-3 w-screen text-center'>
      <h1 className="text-center text-lg">Brought to you by iReadRx 🧪</h1>
    </footer>
  );
};

export default Footer;
