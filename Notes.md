# Greatest Common Divisor 

```java
int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return Math.abs(a);
}
```

# All Common Divisors
Find GCD first, then compute all divisors of GCD.

```java
List<Integer> divisors(int gcd) {
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i * i <= gcd; i++) {
        if (gcd % i == 0) {
            result.add(i);
            
            if (i != gcd / i) {
                result.add(gcd / i);
            }
        }
    }
    return result;
}
```

# Mental model for the sliding-window
1. Define what makes a window valid
2. Expand greedily to the right
3. When invalid, shrink from the left
4. Record the answer when valid again