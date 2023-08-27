# Bit Manipulation

**`Bit Manipulation`** is a technique used in a variety of problems to get the solution in an <u>optimized way</u>.
- This technique is very effective from a Competitive Programming point of view.
- It is all about <u style="color: MediumSlateBlue;">Bitwise Operators</u> which directly works upon <span style="color: Coral;">binary numbers</span> or <span style="color: Coral;">bits of numbers</span> that help the implementation fast.

Below are the Bitwise Operators that are used:
- Bitwise AND (&)
- Bitwise OR (|)
- Bitwise XOR (^)
- Bitwise NOT (!)

## Bit Representation:

In programming, an n-bit integer is internally stored as a binary number that consists of n bits.
- For example, the C++ type int is a 32-bit type, which means that every int number consists of 32 bits.
- The int number `43 = 00000000000000000000000000101011`

> <br/>
> The bits in the representation are indexed from right to left. 
>
> <br/>

### Binary No. to Decimal No.
To convert a bit representation b<sub>k</sub> ··· b<sub>2</sub> b<sub>1</sub> b<sub>0</sub> into a number, we can use the formula 
b<sub>k</sub>2<sup>k</sup> +…+ b<sub>2</sub>2<sup>2</sup> + b<sub>1</sub>2<sup>1</sup> + b<sub>0</sub>2<sup>0</sup>.

E.g., 1·2<sup>5</sup>+1·2<sup>3</sup> +1·2<sup>1</sup> +1·2<sup>0</sup> = 43.

The bit representation of a number is either `signed` or `unsigned`.

Usually, a `signed representation` is used, which means that both `negative` and `positive` numbers can be represented.

A signed variable of `n bits` can contain any integer between 
`-2`<sup>`n-1`</sup> and `2`<sup>`n-1`</sup> `-1`<br/>
The int type in C++ is a signed type, so an int variable can contain any integer between -2<sup>31</sup> and 2<sup>31</sup> – 1.

The `first bit` in a `signed representation` is <u>the sign of the number</u>
- 0 for non-negative numbers and
- 1 for negative numbers and
- the remaining n−1 bits contain the magnitude of the number.

## Two’s complement

`Two’s complement` is used, which means that the opposite number of a number is calculated by first inverting all the bits in the number, and then increasing the number by one.

i.e. **`2's complement of x = ~(x) + 1`**

The bit representation of the int number `−43` is `11111111111111111111111111010101`

In an `unsigned representation`, only non-negative numbers can be used, but the upper bound for the values is larger.
An `unsigned variable` of `n bits` can contain any integer between `0` and `2`<sup>`n−1`</sup>.

In C++, an unsigned int variable can contain any integer between 0 and 2<sup>32</sup> −1.
There is a connection between the representations:

> <br/>
> A signed number −x equals an unsigned number 2<sup>n</sup> − x.
> 
> <br/>
<br/>

## Bitwise Operations:

### NOT ( ~ ):

- Bitwise NOT is an `unary operator` that `flips the bits of the number` i.e., if the ith bit is 0, it will change it to 1 and vice versa.
- Bitwise NOT is nothing but simply the `one’s complement of a number`.
- Lets take an example.
    ```
    N = 5 = (101)
    ~N = ~5 = ~(101) = (010) = 2
    ```


### AND ( & ):

- Bitwise AND is a `binary operator` that operates on two equal-length bit patterns.
- If both bits in the compared position of the bit patterns are 1, the bit in the resulting bit pattern is 1, otherwise 0.
- Lets take an example.
    ```
    A = 5 = 101
    B = 3 = 011
    A & B = (101) & (011)
          = (001) 
          = 1
    ```


### OR ( | ):

- Bitwise OR is also a `binary operator` that operates on two equal-length bit patterns, similar to bitwise AND.
- If both bits in the compared position of the bit patterns are 0, the bit in the resulting bit pattern is 0, otherwise 1.
- Lets take an example.
    ```
    A = 5 = (101)
    B = 3 = (011)
    A | B = (101) | (011)
          = (111)
          = 7
    ```


### XOR ( ^ ):

- Bitwise XOR also takes two equal-length bit patterns.
- If both bits in the compared position of the bit patterns are 0 or 1, the bit in the resulting bit pattern is 0, otherwise 1.
- Lets take an example.
    ```
    A = 5 = (101)
    B = 3 = (011)
    A ^ B = (101) ^ (011)
          = (110)
          = 6
    ```

### LEFT SHIFT ( << ):

-  Left shift operator is a `binary operator` which shift the some number of bits, in the given bit pattern, to the `left` and append `0` at the end.
-  Left shift is equivalent to `multiplying` the bit pattern with `2`<sup>`k`</sup> ( if we are shifting k bits ).
- Lets take an example.
    ```
    1 << 1 = 2 = 2^1
    1 << 2 = 4 = 2^2
    1 << 3 = 8 = 2^3
    1 << 4 = 16 = 2^4
    …
    1 << n = 2^n
    ```

### RIGHT SHIFT ( >> ):

- Right shift operator is a `binary operator` which shift the some number of bits, in the given bit pattern, to the `right` and append `1` at the end.
- Right shift is equivalent to `dividing` the bit pattern with `2`<sup>`k`</sup> ( if we are shifting k bits ).
- Lets take an example.
    ```
    4 >> 1 = 2
    6 >> 1 = 3
    5 >> 1 = 2
    16 >> 4 = 1
    ```

<html>
    <style>
        table, thead, tbody, tr, th, td {
            border: 1px solid;
        }
        th {
            color: IndianRed
            font-weight: bold;
        }
        .op {
            color: IndianRed;
        }
        .OP {
            color: teal;
        }
    </style>
    <table>
        <thead>
            <tr>
                <th>x <span class="op">op</span> <span class="OP">OP</span></th>
                <th class="OP">0</th>
                <th class="OP">1</th>
                <th class="OP">x</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th class="op">NOT (~)</th>
                <td>~0 = 1</td>
                <td>~1 = 0</td>
                <td>~x</td>
            </tr>
            <tr>
                <th class="op">AND (&)</th>
                <td>0</td>
                <td>x</td>
                <td>x</td>
            </tr>
            <tr>
                <th class="op">OR (|)</th>
                <td>x</td>
                <td>1</td>
                <td>x</td>
            </tr>
            <tr>
                <th class="op">XOR (^)</th>
                <td>x</td>
                <td>~x</td>
                <td>0</td>
            </tr>
            <tr>
                <th class="op">Left Shift (<<)</th>
                <td>x * 2<sup>0</sup> = x * 1 = x</td>
                <td>x * 2<sup>1</sup> = x * 2 = 2x</td>
                <td>x * 2<sup>x</sup> = x * 2<sup>x</sup></td>
            </tr>
            <tr>
                <th class="op">Right Shift (>>)</th>
                <td>x / 2<sup>0</sup> = x / 1 = x</td>
                <td>x / 2<sup>1</sup> = x / 2 = x/2</td>
                <td>x / 2<sup>x</sup> = x / 2<sup>x</sup></td>
            </tr>
        </tbody>
        <footer>op: operator, OP: Operand</footer>
    </table>
</html>

## Operations:

### GET Bit:
This method is used to **`find`** the bit at a particular position(say i) of the given number N.

#### `Approach-1`
  - The idea is to find the `Bitwise AND` of the `given number` and `2`<sup>`i`</sup> that can be represented as (`1 << i`).
  -  If the value return is 1 then the bit at the i<sup>th</sup> position is set. Otherwise, it is unset.

  > <br />
  > result = x & (2<sup>i</sup>)<br />
  > result = x & (1 << i)<br />
  >
  > If result == 1 -> SET (i.e. i<sup>th</sup> bit is 1)<br/>
  > If result == 0 -> UNSET (i.e. i<sup>th</sup> bit is 0)
  >
  > <br />

#### `Approach-2`
  - The idea is to find the `Bitwise AND` of the `given number right shifted by i` and `1`.
    - i.e first, `Right Shift` of the `given number`  by `i` that can be represented as (`x >> i`). This will bring ith bit at the right most bit.
    - Now, check if that no. is even or odd
    - If the value return is Odd then the bit at the i<sup>th</sup> position is set. Otherwise, it is unset.

  > <br />
  > result = (x >> i) & 1<br />
  >
  > If result == 1 -> SET (i.e. i<sup>th</sup> bit is 1)<br/>
  > If result == 0 -> UNSET (i.e. i<sup>th</sup> bit is 0)
  >
  > <br />

### SET Bit:
- This method is used to set the bit at a particular position(say i) of the given number N.
- The idea is to **`update`** the value of the given number N to the `Bitwise OR` of the `given number N` and `2`<sup>`i`</sup> that can be represented as (`1 << i`)
-  If the value return is 1 then the bit at the i<sup>th</sup> position is set. Otherwise, it is unset.

> <br />
> result = x | (2<sup>i</sup>)<br />
> result = x | (1 << i)<br />
>
> If result == 1 -> SET (i.e. i<sup>th</sup> bit is set as 1)<br/>
> If result == 0 -> UNSET (i.e. i<sup>th</sup> bit is set as 0)
>
> <br />



### CLEAR Bit:
- This method is used to clear the bit at a particular position(say i) of the given number N.
- The idea is to **`update`** the value of the given number N to the `Bitwise AND` of the `given number N` and `compliment` of `2`<sup>`i`</sup> that can be represented as `~(1 << i)`
-  If the value return is 1 then the bit at the i<sup>th</sup> position is set. Otherwise, it is unset.

> <br />
> result = x & ~(1 << i)<br />
>
> If result == 1 -> SET (i.e. i<sup>th</sup> bit is 1)<br/>
> If result == 0 -> UNSET (i.e. i<sup>th</sup> bit is 0)
>
> <br />


## Advantages of Bitwise Operator:
- Bitwise operations are prominent in embedded systems, control systems, etc where memory(data transmission/data points) is still an issue.
- They are also useful in networking where it is important to reduce the amount of data, so booleans are packed together. Packing them together and taking them apart use bitwise operations and shift instructions.
- Bitwise operations are also heavily used in the compression and encryption of data.
- Useful in graphics programming, older GUIs are heavily dependent on bitwise operations like XOR(^) for selection highlighting and other overlays.


## Things to Remember:

1. To <span style="color:Coral;">Set</span> a bit at position `i` simply do `(x | (1 << i))`. You `left shift` 1 at position n and then `add` it x basically making that place also set (1).
2. <span style="color:Coral;">Even / Odd Check</span>:
   1. if `x % 2 == 0`, then `Even` else `Odd`
   2. Check the right most bit: i.e. 
        ```
        GetBit(0) = x & (2^0)
                    = x & (1<<0)
                    = x & 1
        ```
      1. if `x & 1 == 0`, then `x` is `Even`.
      2. if `x & 1 == 1`, then `x` is `Odd`.
3. To <span style="color:Coral;">Check</span> a bit at any position `i` in number x do `((x >> i) & 1)`.
Alternatively, `(x & (1 << i))`, but it doesn't return 1 or 0, so it can only be used in `conditionals`. Be careful while using it for something else.
4. To <span style="color:Coral;">unset (0) the last bit</span> (first from right) of any number x do `(x & (x - 1))`. (To make last bit 0)
   1. `x-1` will make just last bit 0 and then multiply it with original number i.e. x in this case.
   2. Some other ways - <br/>
        i. `x - (x & - x)` <br/>
        ii. `x ^ (x & (~x + 1))`
5. <span style="color:Coral;">Flip</span> a bit any position i in number x using `x ^ (1 << i)`.
6. <span style="color:Coral;">2's Complement</span> of x is `~x + 1`.
7. <span style="color:Coral;">Case Conversion</span>:
   1. To Upper Case: `x & (~32)`.
   2. To Lower Case: `x | (32)`.
   3. To Toggle Case: `x ^ (32)`.
8. <span style="color:Coral;">Number of 1's in x</span>:
   The `number of ones` in the binary representation of the given number is `x = x&(x-1)`, loop on the equation until x is 0. The no. of iterations is the no. of ones.
    ```
    count = 0
    while(x!=0) {
        x = x & (x-1);
        count++;
    }
    ```
    For example: 
    - x = 5 => (101)
    - count = 0
    - Iteration - 1, as x != 0
        ```
        x = x & (x-1)
        = 5 & 4
        = (101) & (100)
        = 100
        = 4
        ```
        count = 1
    - Iteration - 2 as x != 0
        ```
        x = x & (x-1)
        = 4 & 3
        = (100) & (011)
        = 000
        = 0
        ```
        count = 2
    - Loop End as x == 0
    - Count = 2 i.e. No. of Bits is 2 in x(5)
    
9. <span style="color:Coral;">Number of bit's in x</span>: `(log`<sub>`2`</sub>`x) + 1` <br />
    For example:
    - x = 13 = (1101)
    - (log<sub>2</sub>13) + 1 = 3.70044 + 1 = 4 
10. <span style="color:Coral;">Number of digit's in x</span>: `(log`<sub>`10`</sub>`x) + 1` <br />
    For example:
    - x = 13 = (1101)
    - (log<sub>10</sub>13) + 1 = 1.113943 + 1 = 2
11. <span style="color:Coral;">Minimum No. of bits to convert `a` to `b`</span> = `No. of set bits in a^b`
    1.  First, `XOR` `a` and `b`, to get the bit difference in both  => `a ^ b`
    2.  Count no. of set bits in `a ^ b`, i.e. `x` => `(log`<sub>`2`</sub>`x) + 1` 
12. <span style="color:Coral;">Rightmost 1 in `x`</span> = `x & -x`
    For example:
    ```
    x = 6 = (110)
    -x = -6 = 
       = ~(x)+1
       = ~(110) + 1
       = (001) + 1
       = 010
    x & -x = x & (~(x)+1)
           = (110) & (010)
           = (010)
           = 2
    ```
    - i.e. Rightmost 1 in `x` is at 2nd position from right  



### References
1. [GFG-1](https://www.geeksforgeeks.org/all-about-bit-manipulation/)
2. [LeetCode-1](https://leetcode.com/tag/bit-manipulation/discuss/2960396/Bit-Manipulation-Guide-and-Tricks)
3. [HackerEarth](https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/tutorial/)

### Further Reading 
1. [GFG-2](https://www.geeksforgeeks.org/bits-manipulation-important-tactics/)
2. [LeetCode-2](https://leetcode.com/tag/bit-manipulation/discuss/3629570/Bit-Manipulation-ororBasics-for-Beginners-oror-Concepts-with-all-curated-problems)
3. [LeetCode-3](https://leetcode.com/problems/sum-of-two-integers/solutions/84278/a-summary-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently/)  