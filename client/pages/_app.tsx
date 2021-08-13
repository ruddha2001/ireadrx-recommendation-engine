import '../styles/globals.css'
import type { AppProps } from 'next/app'
import React from 'react'
import Head from 'next/head'
import Footer from '../components/Footer'

function MyApp({ Component, pageProps }: AppProps) {
  return <div>
    <Head>
        <title>iChemist - iReadRx</title>
        <meta name="description" content="A fast and extensive patent discovery and recommendation engine" />
        <link rel="icon" href="/favicon.ico" />
        <meta name="description" content="Patent Discovery Simplified" />
        <link rel="icon" href="/favicon.ico" />
        <meta name="author" content="Tech Analogy" />
        <meta property="og:url" content="https://ireadrx.ai" />
        <meta property="og:title" content="iChemist" />
        <meta
          property="og:description"
          content="Patent Discovery Simplified"
        />
        <meta
          property="og:image"
          content="https://billboard.srmkzilla.net/api/blog?title=iChemist&subtitle=iReadRx&theme=dark"
        />
      </Head>
    <Component {...pageProps} />
  </div>
}
export default MyApp
