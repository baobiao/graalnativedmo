
import http from 'k6/http';
import { check, sleep } from 'k6';
import { randomString } from 'https://jslib.k6.io/k6-utils/1.6.0/index.js';


export const options = {
  scenarios: {
    contacts: {
      executor: 'ramping-vus',
      startVUs: 0,
      stages: [
        { duration: '5s', target: 20 },     // Ramp up to 20 users in first 5 seconds.
        { duration: '10s', target: 20 },    // Stay at 20 users for 10 seconds.
        { duration: '5s', target: 0 },      // Ramp down to 0 users in last 5 seconds.
      ],
      gracefulRampDown: '0s',
      gracefulStop: '0s',
    },
  },
  thresholds: {
    http_req_duration: ['p(95)<100'],   // 95% of requests should be below 100ms
    http_req_duration: ['p(90)<75'],    // 90% of requests should be below 75ms
  },
};

export default function() {
  // Generate random number between 45-50 digits
  const randomLength = Math.floor(Math.random() * (50 - 45 + 1)) + 45;
  const randomNumber = Array(randomLength).fill().map(() => Math.floor(Math.random() * 10)).join('');
  
  const res = http.get(`http://localhost:8080/${randomNumber}`);
  
  check(res, {
    'status is 200': (r) => r.status === 200,
  });
  
  sleep(1);
}