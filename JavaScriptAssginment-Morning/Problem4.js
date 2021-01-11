function digitsSum(str) {
    var sum = 0;
  
    for (let i = 0; i < str.length; i++)
    {
  
      if (/[0-9]/.test(str[i]))
       sum += parseInt(str[i])
    }
    return sum;
  }
  
  console.log(digitsSum("abd516cdv718vha"));