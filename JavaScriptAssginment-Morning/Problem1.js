function isPrime(num) {
    for (let i = 2; i <= Math.sqrt(num); i++)
    {
      if (num % i === 0) return false;
    }
    return true;
  }

function prime_factors(num) {
    const factors = [];
    for (let i = 2; i <= num; i++)
    {
      while (isPrime(i) && num % i === 0) 
      {
        if (!factors.includes(i)) factors.push(i);
        num /= i;
      }
    }
    return factors;
  }

  console.log(prime_factors(50));
  console.log(prime_factors(270));