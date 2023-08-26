"use client" // クライアントでuseEffectが必要な場合付ける必要がある。

import Image from 'next/image'
import styles from './page.module.css'
import { Chart, registerables } from "chart.js"
import { Doughnut } from 'react-chartjs-2';
import { VirtualCurrencies } from '@/data/portfolio/VirtualCurrencies';

Chart.register(...registerables)

export default function Home() {
  const handleClick = async () => {
    const url = 'http://localhost:8080/users';
    const requestBody = {
        name: "John Doe3"
    };

    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();
        console.log(data);
    } catch (error: any) {
        console.error('There was a problem with the fetch operation:', error.message);
    }
};

  return (
    <main className={styles.main}>
      <div className={styles.description}>
        <p>
          Get started by editing&nbsp;
          <code className={styles.code}>src/app/page.tsx</code>
        </p>
      </div>

      <div className={styles.center}>
        <Image
          className={styles.logo}
          src="/next.svg"
          alt="Next.js Logo"
          width={180}
          height={37}
          priority
        />
      </div>

      <div>
        <Doughnut data={VirtualCurrencies} />
      </div>
      <button onClick={handleClick}>button</button>
    </main>
  )
}
