"use client" // クライアントでuseEffectが必要な場合付ける必要がある。

// import Image from 'next/image'
import styles from './page.module.css'
import { Chart, registerables } from "chart.js"
import { Doughnut } from 'react-chartjs-2';
import { VirtualCurrencies } from '@/data/portfolio/VirtualCurrencies';
import Link from 'next/link';

Chart.register(...registerables)

export default function Home() {
  return (
    <main className={styles.main}>
      <div className={styles.description}>
        <p>
          Get started by editing&nbsp;
          <code className={styles.code}>src/app/page.tsx</code>
        </p>
      </div>
{/*
      <div className={styles.center}>
        <Image
          className={styles.logo}
          src="/next.svg"
          alt="Next.js Logo"
          width={180}
          height={37}
          priority
        />
      </div> */}

      <Link href={'/users'}>Go To Users Page.</Link>

      <div>
        <Doughnut data={VirtualCurrencies} />
      </div>
    </main>
  )
}
