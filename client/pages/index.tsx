import React from "react";
import Footer from "../components/Footer";
import SearchBar from "../components/Searchbar";

/* eslint-disable @next/next/no-img-element */
export default function Home() {
  return (
    <div className='h-screen flex flex-wrap justify-center w-screen'>
      {/* <img src='/bg.svg' alt='bg' className='w-screen object-cover max-h-screen max-w-screen' /> */}
      <SearchBar className="text-xl text-black text-center h-screen mt-72"/>
      <Footer />
    </div>
  )
}
